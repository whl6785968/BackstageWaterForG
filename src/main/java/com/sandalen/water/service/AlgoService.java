package com.sandalen.water.service;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.PropertiesClass.IsoForestProperties;
import com.sandalen.water.PropertiesClass.SMSProperties;
import com.sandalen.water.algo.IsoForest.IForest;
import com.sandalen.water.algo.IsoForest.IsoForest;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import com.sandalen.water.other.Constants;
import com.sandalen.water.structure.Graph;
import com.sandalen.water.util.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.ejml.data.DenseMatrix64F;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
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

    @Autowired
    private ErrReportMapper errReportMapper;

    @Autowired
    private RecordReportMapper recordReportMapper;

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
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"ph");
        map.put(1,"dis");
        map.put(2,"nh");
        map.put(3,"kmno");
        map.put(4,"totalp");

        for(Equipment equipment : equipAndStation){
            Integer status = equipment.getStatus();
            String responsible = equipment.getStation().getResponsible();
            Userinfo userinfo = userService.getUserDetailsById(responsible);
            String charger_number = userinfo.getLink();
            String charger_name = userinfo.getName();

            Integer isAlert = equipment.getStation().getIsAlert();
            String stationId = equipment.getStation().getId();

            String stationName = equipment.getStation().getName();
            ErrRecord errRecord = new ErrRecord();

            String desc = "";
            if (status == 2){
                desc += "设备状态异常";
                resultOfWarning = 1;
                errRecord.setEmergency(1);
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
            //1.先将异常记录插入数据库
            if(!desc.equals("") && isAlert != 1){
                desc = "站点："+ stationName + desc;
//                //如果不是某个具体指标的原因，则需要进一步查找是哪些指标出现的问题
                errRecord.setRecordId(IdUtils.getId());
                errRecord.setTitle(desc);
                errRecord.setEmergency(-1);
                errRecord.setChargerId(responsible);
                errRecord.setChargerName(charger_name);
                errRecord.setChargerNumger(charger_number);
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
                String factors = "";

                if(resultOfWarning != 4){
                    //前三种异常情况需要检查具体哪些指标出现问题
                    //使用什么方法进行检测？
                    //1.相关度
                    //2.灰色关联分析

                    //采用相关度和灰色关系分析综合判断
                    List<Waterdata> waterdata = waterdataMapper.getDataByEidAndTwe(equipment.getId());
                    List<Double> label = new ArrayList<>();
                    List<DenseMatrix64F> data = new ArrayList<>();

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
                            label.add(-1.0);
                        }
                        else {
                            label.add(1.0);
                        }

                        data.add(denseMatrix64F);
                    }

                    List<Double> corr = MathUtils.calcCorr(data, label);

                    int max_index = 0;
                    for(int i = 1;i < corr.size();i++) {
                        if(Math.abs(corr.get(i)) > Math.abs(corr.get(max_index))){
                            max_index = i;
                        }
                    }

                    factors = map.get(max_index);

                    System.out.println("预警："+desc + ",指标："+factors);
                    errRecord.setSeriousFactor(factors);
                    errRecordMapper.insert(errRecord);
                    Neo4jUtils.updateWarningStation(stationId,factors);
                }
                else{
                    for(String f : warningFactors){
                        factors += f + "-";
                    }

                    factors = factors.substring(0,factors.length()-1);
                    System.out.println("预警："+desc + ",指标："+factors);
                    errRecord.setSeriousFactor(factors);
                    errRecordMapper.insert(errRecord);
                    Neo4jUtils.updateWarningStation(stationId,factors);

                }
            }

        }

        //2.知识图谱异常原因查询
        //生成异常报告（另外一个表）
        //报告内容包括：
        //- 上下游站点是否存在异常情况
        //- 流域企业是否排放超标
        //- 相关指标超标的解决方案

        //1)上下游站点是否存在异常情况
        //2)若当前站点出现异常，且上游站点出现异常和上游站点异常指标一致，则认为是上游站点流入当前站点
        //选取最上游站点作为当前节点，查找是否有企业排污超标
        //3)若当前站点出现异常，上游没出现异常，下游出现异常，则认为当前站点流入下游导致下游异常，保持
        //当前站点不变，查找是否有企业排污超标
        //若当前站点出现异常，上下游都未出现异常或异常指标不同，考虑当前站点自身问题，保持当前站点不变，
        //查找是否有企业排污超标

        //4)根据异常指标到知识图谱寻找对应解决方案

        Map<String,String> factor2name = new HashMap<>();
        factor2name.put("ph","ph");
        factor2name.put("dis","溶解氧");
        factor2name.put("nh","氨氮");
        factor2name.put("kmno","高锰酸盐");
        factor2name.put("totalp","总磷");

        ErrRecordExample errRecordExample = new ErrRecordExample();

        List<ErrRecord> errRecords = errRecordMapper.selectByExample(errRecordExample);
        for(ErrRecord errRecord : errRecords){
            String initial_judge = "";
            String currentStationId = errRecord.getSid();
            String factor = errRecord.getSeriousFactor();
            String title = errRecord.getTitle();
            String recordId = errRecord.getRecordId();
            List<Record> records = Neo4jUtils.searchBasin(currentStationId);
            ErrReport errReport = new ErrReport();
            String reportId = IdUtils.getId();
            errReport.setReportId(reportId);
            errReport.setResult(title);
            errReport.setSid(errRecord.getSid());

            RecordReport recordReport = new RecordReport();
            recordReport.setRecordId(recordId);
            recordReport.setReportId(reportId);

            String enterpriseProblem = "临近企业";

            if(records.size() == 0){
                initial_judge = "上下游皆为出现异常，考虑当前站点自身原因。";
                errReport.setBasinError(initial_judge);
                List<Record> enterpriseRecord = Neo4jUtils.searchEnterprise(currentStationId);
                if(enterpriseRecord.size() != 0){
                    for(Record r : enterpriseRecord){
                        String enterprise = r.get("m").asNode().get("name").toString().replace("\"", "");
                        enterpriseProblem += enterprise + "、";
                    }

                    if(!enterpriseProblem.equals("临近企业")){
                        enterpriseProblem = enterpriseProblem.substring(0,enterpriseProblem.length() - 1);
                        enterpriseProblem += "等排污"+ factor2name.get(factor) +"超标，请联系相关负责人";
                        errReport.setEnterpriseError(enterpriseProblem);
                    }
                }

                if(errRecord.getOrigin() != 1){
                    errRecord.setEmergency(2);
                }
            }
            else {
                if(errRecord.getOrigin() != 1){
                    errRecord.setEmergency(3);
                }

                List<Long> upstreams = new ArrayList<>();
                List<String> upstreamSid = new ArrayList<>();
                Map<Integer,String> idAndStation = new HashMap<>();
                Map<Integer,String> idAndSid = new HashMap<>();

                Long currentStationNodeId = 0L;


                Set<List<Long>> paths = new HashSet<>();
                Long max_node = Long.MIN_VALUE;

                for(Record record : records){
                    Node n = record.get("n").asNode();
                    String sourceName = n.get("name").toString().replace("\"","");
                    String sourceSid = n.get("sid").toString().replace("\"","");

                    if(sourceSid.equals(currentStationId) && currentStationNodeId == 0L){
                        currentStationNodeId = n.id();
                    }

                    if(!idAndStation.containsKey(n.id())){
                        idAndStation.put((int) n.id(),sourceName);
                    }

                    if(!idAndSid.containsKey((int)n.id())){
                        idAndSid.put((int)n.id(),sourceSid);
                    }

                    max_node = Math.max(max_node,n.id());

                    Node m = record.get("m").asNode();
                    String targetName = m.get("name").toString().replace("\"","");
                    String targetSid = m.get("sid").toString().replace("\"","");

                    max_node = Math.max(max_node,m.id());

                    if(targetSid.equals(currentStationId) && currentStationNodeId == 0L){
                        currentStationNodeId = m.id();
                    }

                    if(!idAndStation.containsKey(m.id())){
                        idAndStation.put((int) m.id(),targetName);
                    }

                    if(!idAndSid.containsKey((int)m.id())){
                        idAndSid.put((int)m.id(),targetSid);
                    }

                    Value values = record.get("r");

                    if(values.size() > 0){
                        for(int i = 0;i < values.size();i++){
                            Relationship relationship = values.get(i).asRelationship();
                            ArrayList<Long> tmp = new ArrayList<>();
                            tmp.add(relationship.startNodeId());
                            tmp.add(relationship.endNodeId());
                            paths.add(tmp);
                            if(relationship.endNodeId() == currentStationNodeId && !upstreams.contains(relationship.startNodeId())){
                                upstreams.add(relationship.startNodeId());
                                upstreamSid.add(idAndSid.get((int)relationship.startNodeId()));
                            }

                            for(int j = 0;j < upstreams.size();j++){
                                if(relationship.endNodeId() == upstreams.get(j) && !upstreams.contains(relationship.startNodeId())){
                                    upstreams.set(j,relationship.startNodeId());
                                    upstreamSid.set(j,idAndSid.get((int)relationship.startNodeId()));
                                }
                            }
                        }
                    }
                    else{
                        Relationship relationship = values.asRelationship();
                        ArrayList<Long> tmp = new ArrayList<>();
                        tmp.add(relationship.startNodeId());
                        tmp.add(relationship.endNodeId());
                        paths.add(tmp);
                        if(relationship.endNodeId() == currentStationNodeId && !upstreams.contains(relationship.startNodeId())){
                            upstreams.add(relationship.startNodeId());
                            upstreamSid.add(idAndSid.get((int)relationship.startNodeId()));
                        }

                        for(int j = 0;j < upstreams.size();j++){
                            if(relationship.endNodeId() == upstreams.get(j) && !upstreams.contains(relationship.startNodeId())){
                                upstreams.set(j,relationship.startNodeId());
                                upstreamSid.set(j,idAndSid.get((int)relationship.startNodeId()));
                            }
                        }
                    }
                }

                List<List<Long>> p = new ArrayList<>(paths);

                if(upstreams.size() != 0){
                    for(Long upstream : upstreams){
                        int up = Math.toIntExact(upstream);
                        Graph graph = new Graph(max_node, p,idAndStation);
                        List<String> vector = new ArrayList<>();
                        graph.dfs(up,vector);

                        List<List<String>> rs = graph.getResult();
                        String rp = "";
                        for(List<String> rr : rs){
                            for(String rrr : rr){
                                rp +=  rrr +"->";
                            }
                        }

                        rp = rp.substring(0,rp.length() - 2);
                        initial_judge += "从站点"+idAndStation.get(up) + "为起点至当前站点" + idAndStation.get(Math.toIntExact(currentStationNodeId)) +
                        "的流域皆发生与指标"+ factor2name.get(factor) +"相关异常，沿途流域为" + rp + "。";
                        errReport.setBasinError(initial_judge);

                        for(String upSid : upstreamSid){
                            List<Record> enterprise = Neo4jUtils.searchEnterprise(upSid);
                            if(enterprise.size() != 0){
                                for(Record r : enterprise){
                                    String errEnterprise = r.get("m").asNode().get("name").toString().replace("\"", "");
                                    enterpriseProblem += errEnterprise +"、";
                                }
                            }
                        }

                        if(!enterpriseProblem.equals("临近企业")){
                            enterpriseProblem = enterpriseProblem.substring(0,enterpriseProblem.length() - 1);
                            enterpriseProblem += "等排污"+ factor +"超标，请联系相关负责人";
                            errReport.setEnterpriseError(enterpriseProblem);
                        }
                    }
                }
                else {
                    int cur = Math.toIntExact(currentStationNodeId);
                    Graph graph = new Graph(max_node, p,idAndStation);
                    List<String> vector = new ArrayList<>();
                    graph.dfs(cur,vector);

                    List<List<String>> rs = graph.getResult();
                    String rp = "";
                    for(List<String> rr : rs){
                        for(String rrr : rr){
                            rp += rrr + "->";
                        }
                    }

                    rp = rp.substring(0,rp.length() - 2);
                    initial_judge = "上游站点未发生异常，由当前站点"+ idAndStation.get(Math.toIntExact(currentStationNodeId)) +"出发" +
                    "的下游流域" + rp + "中各站点出现" + factor2name.get(factor) + "有关异常，判断当前站点存在问题。";
                    errReport.setBasinError(initial_judge);

                    List<Record> enterpriseRecord = Neo4jUtils.searchEnterprise(currentStationId);
                    if(enterpriseRecord.size() != 0){
                        for(Record r : enterpriseRecord){
                            String enterprise = r.get("m").asNode().get("name").toString().replace("\"", "");
                            enterpriseProblem += enterprise + "、";
                        }

                        if(!enterpriseProblem.equals("临近企业")){
                            enterpriseProblem = enterpriseProblem.substring(0,enterpriseProblem.length() - 1);
                            enterpriseProblem += "等排污"+ factor2name.get(factor) +"超标，请联系相关负责人";
                            errReport.setEnterpriseError(enterpriseProblem);
                        }
                    }
                }
            }

            List<Record> list = Neo4jUtils.getFactorOrigin(factor2name.get(factor));
            Record record = list.get(0);
            String factorOrigin = record.values().get(0).toString().replace("\"","");
            errReport.setFactorResult(factorOrigin);

            String factorSolution = Neo4jUtils.getFactorSolution(factor2name.get(factor)).get(0).values().toString().replace("\"", "");
            errReport.setFactorSolution(factorSolution);

            errRecordMapper.updateByPrimaryKey(errRecord);
            errReportMapper.insert(errReport);
            recordReportMapper.insert(recordReport);

        }

    }

    //秒 分 时 月中的天 月 周中的天 年
    //月中的天和周中的天一定有一个是?
//    @Scheduled(cron = "0 0/30 * * * ?")

    public List<ErrRecord> getErrRecord(){
        List<ErrRecord> errRecords = errRecordMapper.getErrRecordAndReportId();
        return errRecords;
    }

    public ErrReport getErrReport(String reportId){
        ErrReportExample errReportExample = new ErrReportExample();
        errReportExample.createCriteria().andReportIdEqualTo(reportId);

        List<ErrReport> errReports = errReportMapper.selectByExample(errReportExample);

        return errReports.get(0);

    }

}
