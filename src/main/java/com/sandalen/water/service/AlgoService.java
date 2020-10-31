package com.sandalen.water.service;



import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.PropertiesClass.SMSProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.algo.IsoForest.IsoForest;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.EquipmentMapper;
import com.sandalen.water.dao.ErrRecordMapper;
import com.sandalen.water.dao.WaterdataMapper;
import com.sandalen.water.other.Constants;
import com.sandalen.water.util.*;
import org.ejml.data.DenseMatrix64F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.ujmp.core.util.MathUtil;

import java.io.IOException;
import java.util.*;

@Service
public class AlgoService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private WaterdataMapper waterdataMapper;

    @Autowired
    private DataRelatedService dataRelatedService;

    @Autowired
    private IsoForestProperties isoForestProperties;

    @Autowired
    private SMSProperties smsProperties;

    @Autowired
    private UserService userService;

    @Autowired
    private ErrRecordMapper errRecordMapper;

    public List<Map<String,Object>> isoForest() throws IOException {
        String modelStr = IOUtils.getModelStr(isoForestProperties.getModel_path());
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);

        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);

        List<Map<String,Object>> real_result = new ArrayList<>();

        for (int i = 0;i < equipAndStation.size();i++){
            WaterdataExample waterdataExample = new WaterdataExample();
            WaterdataExample.Criteria criteria = waterdataExample.createCriteria();
            criteria.andEidEqualTo(equipAndStation.get(i).getId());
            List<Waterdata> waterdata = waterdataMapper.selectByExample(waterdataExample);

            List<DenseMatrix64F> bad_data = new ArrayList<>();
            List<DenseMatrix64F> good_data = new ArrayList<>();
            List<DenseMatrix64F> data = new ArrayList<>();
            List<Double> label = new ArrayList<>();
            Map<String, Object> map = new HashMap<>();
            double bad_count = 0.0;
            for (int j = 0;j < waterdata.size(); j++){
                DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, 5);
                denseMatrix64F.set(0,0,waterdata.get(j).getPh());
                denseMatrix64F.set(0,1,waterdata.get(j).getDisslove());
                denseMatrix64F.set(0,2,waterdata.get(j).getNh());
                denseMatrix64F.set(0,3,waterdata.get(j).getKmno());
                denseMatrix64F.set(0,4,waterdata.get(j).getTotalp());

                if (iForest.predict(denseMatrix64F) == -1.0){
                    bad_data.add(denseMatrix64F);
                    label.add(-1.0);
                }
                else {
                    good_data.add(denseMatrix64F);
                    label.add(1.0);
                }

                data.add(denseMatrix64F);
            }

            List<Double> corr = MathUtils.calcCorr(data, label);
            System.out.println(corr.toString());

//            MathUtils.doubleTCheck(bad_data,good_data)
            bad_count = bad_data.size();
            List<Double> bad_data_mean = MathUtils.getMeanForDenseMatrix(bad_data);
            List<Double> good_data_mean = MathUtils.getMeanForDenseMatrix(good_data);
            map.put("bad_count",bad_count);
            map.put("bad_data",bad_data);
            map.put("bad_percent",MathUtils.keepDecimal(bad_count/waterdata.size(),3));
            map.put("bad_data_mean",bad_data_mean);
            map.put("good_data_mean",good_data_mean);
            map.put("data_corr",corr);
            map.put("equipmentId",equipAndStation.get(i).getId());
            map.put("equipmentName",equipAndStation.get(i).getName());
            map.put("station",equipAndStation.get(i).getStation().getName());

            real_result.add(map);
        }
        return real_result;
    }

    public int isError(Waterdata waterdata) throws IOException {
        double ph = waterdata.getPh();
        double nh = waterdata.getNh();
        double dissolve = waterdata.getDisslove();
        double totalc = waterdata.getTotalp();
        double kmno = waterdata.getKmno();

        IForest isoForest = AlgoUtils.getIsoForest();
        DenseMatrix64F denseMatrix64F = new DenseMatrix64F(1, 5);
        denseMatrix64F.set(0,0,ph);
        denseMatrix64F.set(0,1,dissolve);
        denseMatrix64F.set(0,2,nh);
        denseMatrix64F.set(0,3,kmno);
        denseMatrix64F.set(0,4,totalc);

        double predict = isoForest.predict(denseMatrix64F);
        if(predict == 1.0){
            return 1;
        }
        else {
            return -1;
        }
    }

    public void trainIsoForest() throws IOException {
        IsoForest isoForest = new IsoForest();
        int numTrees = isoForestProperties.getNumTrees();
        double score = isoForestProperties.getScore();
        isoForest.train(numTrees, score);
    }

    //秒 分 时 月中的天 月 周中的天 年
    //月中的天和周中的天一定有一个是?
//    @Scheduled(cron = "0 0/30 * * * ?")
    public void err_check() throws IOException {
        String modelStr = IOUtils.getModelStr(isoForestProperties.getModel_path());
        IForest iForest = IOUtils.load_model(modelStr, IForest.class);
        System.out.println("我运行了"+new Date(System.currentTimeMillis()));

        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);

        for (Equipment equip : equipAndStation){
            Integer equipStatus = equip.getStatus();
            String responsible = equip.getStation().getResponsible();
            Userinfo userinfo = userService.getUserDetailsById(responsible);
            String number = userinfo.getLink();
            String station_name = equip.getStation().getName();
            String charger_name = userinfo.getName();
            Integer isAlert = equip.getStation().getIsAlert();
            String stationId = equip.getStation().getId();
            String desc = "";
            String sub_desc = "";

            if (equipStatus == 2){
                sub_desc = "编号"+equip.getId()+"设备状态异常";
                desc = "站点"+station_name+"中"+sub_desc+"，请负责人尽快排查和解决，自动判断原因为" +
                        "设备状态异常";

            }
            else if(equipStatus == 1){
                WaterdataExample waterdataExample = new WaterdataExample();
                WaterdataExample.Criteria criteria = waterdataExample.createCriteria();
                criteria.andEidEqualTo(equip.getId());
                List<Waterdata> waterdataList = waterdataMapper.selectByExample(waterdataExample);
                Double err_percent = MathUtils.keepDecimal(MathUtils.get_err_percent(waterdataList, iForest),3);

                if (err_percent > 0.05){
                    String format_err_percent = err_percent * 100 + "%";
                    desc = "站点"+station_name+"的水质异常数据达到"+format_err_percent+"。";
                }
                else if(MathUtils.isAscend(waterdataList)){
                    desc += "站点"+station_name+"呈恶化趋势。";
                }
            }
            if (!desc.equals("") && isAlert == 0){
                Map<String, List<String>> map = MathUtils.analysis_basin1(equip);
                List<String> upstream = map.get("upstream");
                List<String> downstream = map.get("downstream");

                if (upstream.size() == 0 && downstream.size() != 0){
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0;i < downstream.size();i++){
                        sb.append(downstream.get(i)+"->");
                    }
                    String s = sb.toString();
                    sub_desc = "自动诊断：下游水质出现异常,考虑是"+station_name+"站点的水质本身出现异常,其中下游异常站点顺序为"+s.substring(0,s.length()-2);

                }
                else if(upstream.size() !=0 && downstream.size() == 0){
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0;i < upstream.size();i++){
                        sb.append(upstream.get(i)+"->");
                    }
                    String s = sb.toString();
                    sub_desc = "自动诊断：上游水质出现异常，考虑是上游站点水质出现异常流入站点"+station_name+"导致异常,上游异常站点顺序为"+s.substring(0,s.length()-2);
                }
                else if(upstream.size() !=0 && downstream.size() != 0){
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0;i < upstream.size();i++){
                        sb.append(upstream.get(i)+"->");
                    }
                    String s = sb.toString();
                    sub_desc = "自动诊断：上下游站点水质都出现异常，考虑上游站点水质出现异常而导致的下游水质出现异常，上游站点顺序为"+s.substring(0,s.length()-2);
                }
                else {
                    sub_desc = "自动诊断：上下游水质都未出现异常，考虑设备出现问题或者本站点水质自身问题，需进一步分析";
                }
                dataRelatedService.update_alert(0,stationId);
                ErrRecord errRecord = new ErrRecord();
                errRecord.setRecordId(IdUtils.getId());
                errRecord.setTitle("站点"+station_name + "出现水质异常" );
                errRecord.setJudge(sub_desc);
                errRecord.setEmergency(0);
                errRecord.setChargerId(responsible);
                errRecord.setChargerName(charger_name);
                errRecord.setIsSolve(0);
                errRecord.setCreateTime(new Date());
                errRecord.setSid(stationId);
                errRecordMapper.insert(errRecord);
//                System.out.println(sub_desc);
//                System.out.println(desc);
                SMSUtils.send(smsProperties.getUid(),smsProperties.getKey(),number,desc+sub_desc);
            }
        }
    }

    public List<ErrRecord> getErrRecord(){
        ErrRecordExample errRecordExample = new ErrRecordExample();
        List<ErrRecord> errRecords = errRecordMapper.selectByExample(errRecordExample);
        return errRecords;
    }

    public String tst() throws IOException {
        String s = MathUtils.analysis_basin2("005",true);
        System.out.println(s);
        String d = MathUtils.analysis_basin2("005",false);
        System.out.println(d);
        return s;
    }

}
