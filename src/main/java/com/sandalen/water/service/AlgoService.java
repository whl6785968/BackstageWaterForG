package com.sandalen.water.service;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.PropertiesClass.SMSProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.algo.IsoForest.IsoForest;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.EquipmentMapper;
import com.sandalen.water.dao.ErrRecordMapper;
import com.sandalen.water.dao.StationMapper;
import com.sandalen.water.dao.WaterdataMapper;
import com.sandalen.water.other.Constants;
import com.sandalen.water.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.ejml.data.DenseMatrix64F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.ujmp.core.util.MathUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private StationMapper stationMapper;

    public List<Map<String,Object>> errCheckWithPython() throws IOException {
        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);

        List<Map<String,Object>> real_result = new ArrayList<>();

        for (int i = 0;i < equipAndStation.size();i++){
            List<Waterdata> waterdata = waterdataMapper.getDataByEidAndTwe(equipAndStation.get(i).getId());

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


                String param_data = waterdata.get(j).getPh() + "," + waterdata.get(j).getDisslove() + "," +
                waterdata.get(j).getNh() + "," + waterdata.get(j).getKmno() + "," + waterdata.get(j).getTotalp();
                String uri = "http://127.0.0.1:5000/errCheck/?data=" + param_data;

                String response = HttpClientUtils.getRequest(uri);
                if(response.startsWith("request fail")){
                    System.out.println("发生异常");
                }

                JSONObject jsonObject = JSON.parseObject(response);
                Object o = JSON.parseObject(jsonObject.getString("data")).get("result");
                String s = o.toString();

                if (Integer.parseInt(s) == 0){
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
        double totalp = waterdata.getTotalp();
        double kmno = waterdata.getKmno();

        String params = ph + "," + dissolve + "," + nh + "," + kmno + "," + totalp;
        String uri = "http://127.0.0.1:5000/errCheck/?data=" + params;

        String response = HttpClientUtils.getRequest(uri);

        JSONObject jsonObject = JSON.parseObject(response);
        Object o = JSON.parseObject(jsonObject.getString("data")).get("result");
        String s = o.toString();

        if (Integer.parseInt(s) == 0){
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

    public void err_detection() throws Exception{
        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);

        int resultOfWarning = -1;
        List<String> warningFactors = new ArrayList<>();

        for(Equipment equipment : equipAndStation){
            Integer status = equipment.getStatus();
            String responsible = equipment.getStation().getResponsible();
            Userinfo userinfo = userService.getUserDetailsById(responsible);
            String charger_number = userinfo.getLink();
            String charger_name = userinfo.getName();

            Integer isAlert = equipment.getStation().getIsAlert();
            String stationId = equipment.getStation().getId();

            String stationName = equipment.getStation().getName();

            String desc = "";
            if (status == 2){
                desc += "设备状态异常";
                resultOfWarning = 1;
            }
            else{
                List<Waterdata> waterdataList = waterdataMapper.getDataByEidAndTwe(equipment.getId());

                //计算数据异常比例
                Double err_percent = MathUtils.keepDecimal(MathUtils.getErrPercentWithPython(waterdataList),3);

                if(err_percent > 0.1){
                    desc += "该站点最近20条数据中，异常数据比例超过10%";
                    resultOfWarning = 2;
                }
                else{
                    //计算指标趋势
                    String isDes = MathUtils.judgeTheTrend(waterdataList);
                    if(!isDes.equals("")) {
                        resultOfWarning = 3;
                        desc += isDes;
                    }
                    else {
                        //计算指标突变
//                        MathUtils.haveMutation(waterdataList);

                        //计算新异常值某指标是否超过阈值
                        List<String> seriousExeededFactor = MathUtils.getSeriousExeededFactor(waterdataList);

                        String sef = "";
                        if(seriousExeededFactor.size() != 0){
                            for(String s : seriousExeededFactor){
                                sef += s +",";
                            }

                            sef = sef.substring(0,sef.length()-1);

                            desc += "指标" + sef +"等严重超标";

                            resultOfWarning = 4;
                            warningFactors = seriousExeededFactor;
                        }
                    }
                }
            }

            //辅助判断
            if(!desc.equals("") && isAlert != 1){
                desc = "站点："+ stationName + desc;
//                //如果不是某个具体指标的原因，则需要进一步查找是哪些指标出现的问题
                ErrRecord errRecord = new ErrRecord();
                errRecord.setRecordId(IdUtils.getId());
                errRecord.setTitle(desc);
                errRecord.setEmergency(-1);
                errRecord.setChargerId(charger_number);
                errRecord.setChargerName(charger_name);
                errRecord.setOrigin(resultOfWarning);
                errRecord.setIsSolve(0);
                errRecord.setCreateTime(new Date());
                errRecord.setSid(stationId);

                StationExample stationExample = new StationExample();
                stationExample.createCriteria().andIdEqualTo(stationId);
                List<Station> stations = stationMapper.selectByExample(stationExample);
                Station station = stations.get(0);
                station.setIsAlert(1);

                stationMapper.updateByPrimaryKey(station);

                if(resultOfWarning != 4){
                    //前三种异常情况需要检查具体哪些指标出现问题
                    //使用什么方法进行检测？
                    //1.相关度
                    //2.灰色关联分析

                    //采用相关度和灰色关系分析综合判断
                    List<Waterdata> waterdata = waterdataMapper.getDataByEidAndTwe(equipment.getId());


                }
                else{
                    String factors = "";
                    for(String f : warningFactors){
                        factors += f + "-";
                    }

                    factors = factors.substring(0,factors.length()-1);
                    errRecord.setSeriousFactor(factors);
                    errRecordMapper.insert(errRecord);

                }

            }
        }
    }

    //秒 分 时 月中的天 月 周中的天 年
    //月中的天和周中的天一定有一个是?
//    @Scheduled(cron = "0 0/30 * * * ?")

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
