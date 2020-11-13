package com.sandalen.water.service;


import com.github.pagehelper.PageHelper;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import com.sandalen.water.other.CypherUtils;
import com.sandalen.water.util.DateUtils;
import com.sandalen.water.util.Neo4jUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataRelatedService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private WaterdataMapper waterdataMapper;

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private DistrictMapper districtMapper;

    @Autowired
    private StationDistrictMapper stationDistrictMapper;

    @Autowired
    private EquipStaMapper equipStaMapper;

    @Autowired
    private HistoryListMapper historyListMapper;

    @Autowired
    private HistoryRecordMapper historyRecordMapper;

    @Autowired
    private StationProvinceMapper stationProvinceMapper;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ProvinceMapper provinceMapper;

    @Autowired
    private EnpMapper enpMapper;

    @Autowired
    private EtsStaMapper etsStaMapper;

    public int deleteEnterprise(int id){
        EtsStaExample etsStaExample = new EtsStaExample();
        etsStaExample.createCriteria().andEidEqualTo(id);
        etsStaMapper.deleteByExample(etsStaExample);

        int i = enpMapper.deleteByPrimaryKey(id);

        return i;
    }

    public int updateEnterprise(Enp enp){
        EtsStaExample etsStaExample = new EtsStaExample();
        etsStaExample.createCriteria().andEidEqualTo(enp.getId());
        List<EtsSta> etsStas = etsStaMapper.selectByExample(etsStaExample);
        EtsSta etsSta = etsStas.get(0);

        etsSta.setSid(enp.getStation().getId());
        etsStaMapper.updateByPrimaryKey(etsSta);

        int i = enpMapper.updateByPrimaryKey(enp);
        return i;
    }

    public int addEnterprise(Enp enp){
        int i = enpMapper.insert(enp);

        EtsSta etsSta = new EtsSta();
        etsSta.setEid(enp.getId());
        etsSta.setSid(enp.getStation().getId());
        etsStaMapper.insert(etsSta);

        Neo4jUtils.createEnterprise(enp.getId(),enp.getName(),enp.getContacts(),enp.getContactsNumber(),
                enp.getMainPollutions(),enp.getPollutionsNum(),enp.getIsExceed(),enp.getExceedFactor());

        Neo4jUtils.createRelBetweenEnterPriseAndStation(enp.getId(),enp.getStation().getId());

        return i;
    }

    public List<Enp> getAllEnterprise(){
//        EnterpriseExample example = new EnterpriseExample();
//        List<Enterprise> enterprises = enterpriseMapper.selectByExample(example);
        List<Enp> enterprises = enpMapper.getAllEnp();
        return enterprises;
    }

    public Map<String,Integer> getBasicData(){
        Map<String,Integer> map = new HashMap<>();
//        StationExample example = new StationExample();
        List<Station> stations = stationMapper.getCountByLevel();

        Map<String,Integer> districtCnt = new HashMap<>();

        int station_normal_num = 0;
        int station_err_num = 0;
        int station_stop_num = 0;

        for(Station station : stations){
            if(station.getIsAlert() == 0){
                station_normal_num += 1;
            }
            else if(station.getIsAlert() == 1){
                station_err_num += 1;
            }
            else{
                station_stop_num += 1;
            }
//
//            String district = station.getDistrict().getName();
//            districtCnt.put(district,districtCnt.getOrDefault(district,0)+1);
        }



        map.put("station_normal_num",station_normal_num);
        map.put("station_err_num",station_err_num);
        map.put("station_stop_num",station_stop_num);

//        Set<String> set = districtCnt.keySet();
//        for(String key:set){
//            map.put(key,districtCnt.get(key));
//        }

        return map;
    }

    public List<Waterdata> getWaterDataBySid(int stationId) throws ParseException {
        List<Waterdata> data = waterdataMapper.getDataBySid(stationId);
        for(Waterdata d : data){
            Date date = d.getCreateTame();
            long time = (date.getTime() - 8 * 60 * 60 * 1000);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = format.format(time);
//            String formatDate = DateUtils.specialFormatDate(d.getCreateTame());
            d.setFormatDate(s);
        }
        return data;
    }

    public List<Equipment> getEquipAndStation(SearchCondition searchCondition){
        List<Equipment> equipAndStation = equipmentMapper.getEquipAndStation(searchCondition);
        return equipAndStation;
    }

    public List<Station> getStations(){
        StationExample example = new StationExample();
//        StationExample.Criteria criteria = example.createCriteria();

        List<Station> stations = stationMapper.selectByExample(example);
        return stations;
    }

    public Map<String,Double> getWQIByDistrict(){
        List<NewestWaterData> newestWaterData = stationMapper.getNewestWaterData();
        Map<String,Double> map = new HashMap<>();
        Map<String,Double> recordNum = new HashMap<>();
        for(NewestWaterData data : newestWaterData){
            double wqi = 0.27 * (data.getDis() / 5.0) + 1.0156959 * (data.getNh() / 1.0) + 0.95732255 * (data.getKmno() / 6.0) + 1.2295406*(data.getTotalp() / 0.2);
            map.put(data.getDistrict(),map.getOrDefault(data.getDistrict(),0.0)+wqi);
            recordNum.put(data.getDistrict(),recordNum.getOrDefault(data.getDistrict(),0.0)+1.0);
        }

        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for(Map.Entry<String, Double> entry : entries){
            String district = entry.getKey();
            map.put(district,map.get(district) / recordNum.get(district));
        }

        return map;
    }

    public Map<String,Double> getWQIByStation(){
        List<NewestWaterData> newestWaterData = stationMapper.getNewestWaterData();
        Map<String,Double> map = new HashMap<>();
        Map<String,Double> recordNum = new HashMap<>();

        for(NewestWaterData data : newestWaterData){
            double wqi = 0.27 * (data.getDis() / 5.0) + 1.0156959 * (data.getNh() / 1.0) + 0.95732255 * (data.getKmno() / 6.0) + 1.2295406*(data.getTotalp() / 0.2);
//            double wqi = 0.267 * (data.getDis() / 5.0) + 1.478 * (data.getNh() / 1.0) + 1.367 * (data.getKmno() / 6.0);
            map.put(data.getStation(),map.getOrDefault(data.getStation(),0.0) + wqi);
            recordNum.put(data.getStation(),recordNum.getOrDefault(data.getStation(),0.0) + 1.0);
        }

        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for(Map.Entry<String, Double> entry : entries){
            String station = entry.getKey();
            double res = 10.0 / (map.get(station) / recordNum.get(station));
            map.put(station,res);
        }

        return map;
    }

    public List<Waterdata> getWaterData(String eid){
        WaterdataExample example = new WaterdataExample();
        WaterdataExample.Criteria criteria = example.createCriteria();
        criteria.andEidEqualTo(eid);
        List<Waterdata> waterdata = waterdataMapper.selectByExample(example);
        return waterdata;
    }

    public List<Station> getStationForMap(){
        StationExample stationExample = new StationExample();
        List<Station> stations = stationMapper.selectByExample(stationExample);
        return stations;
    }

    public List<Station> getAllInfoForStation(HashMap<String, Object> map){
        List<Station> stations = stationMapper.getAllInfoForStation(map);

        return stations;
    }

    public List<Userinfo> getAllUser(){
        UserinfoExample example = new UserinfoExample();
        List<Userinfo> userinfos = userinfoMapper.selectByExample(example);
        return userinfos;
    }

    public List<District> getAllDistrict(){
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);

        return districts;
    }

    public List<Province> getAllProvince(){
        ProvinceExample provinceExample = new ProvinceExample();
        List<Province> provinces = provinceMapper.selectByExample(provinceExample);
        return provinces;
    }

    public int addStation(Station station){

//        station.setUpstreamId(null);
//        station.setDownstreamId(null);
        station.setIsAlert(0);
        int insert = stationMapper.insert(station);

        StationDistrict stationDistrict = new StationDistrict();
        stationDistrict.setSid(station.getId());
        stationDistrict.setDid(station.getDistrict().getId());
        int insert1 = stationDistrictMapper.insert(stationDistrict);

        StationProvince stationProvince = new StationProvince();
        stationProvince.setSid(station.getId());
        stationProvince.setPid(station.getProvince().getId());
        stationProvinceMapper.insert(stationProvince);

        Neo4jUtils.createStation(station.getName(),station.getId(),station.getCurrlevel(),station.getIsAlert(),"",station.getUpstreamId(),station.getDownstreamId());
        Neo4jUtils.createRelWithStationAndCharger(station.getId(),station.getResponsible());
        Neo4jUtils.createRelBetweenStationAndBasin(station.getId(),station.getDistrict().getId());
        Neo4jUtils.createRelBetweenStationAndProvince(station.getId(),String.valueOf(station.getProvince().getId()));

        simpMessagingTemplate.convertAndSend("/topic/getNewDataForBD","有新消息了");
        if(insert1 !=0 && insert != 0){
            return 1;
        }

        return 0;
    }

    public int modifyStation(Station station){
//        if(station.getUpstreamId().equals("null")){
//            station.setUpstreamId(null);
//        }
//
//        if(station.getDownstreamId().equals("null")){
//            station.setDownstreamId(null);
//        }
        StationExample stationExample = new StationExample();
        stationExample.createCriteria().andIdEqualTo(station.getId());
        List<Station> stations = stationMapper.selectByExample(stationExample);
        Station station1 = stations.get(0);
        String originCharger = station1.getResponsible();

        StationProvinceExample sp = new StationProvinceExample();
        sp.createCriteria().andSidEqualTo(station1.getId());
        StationDistrictExample sd1 = new StationDistrictExample();
        sd1.createCriteria().andSidEqualTo(station1.getId());

        List<StationDistrict> sds = stationDistrictMapper.selectByExample(sd1);
        StationDistrict stationDistrict1 = sds.get(0);

        List<StationProvince> sps = stationProvinceMapper.selectByExample(sp);
        StationProvince stationProvince1 = sps.get(0);

        String originProvince = String.valueOf(stationProvince1.getPid());
        String originBasin = stationDistrict1.getDid();

        int i = stationMapper.updateByPrimaryKey(station);


        StationDistrictExample stationDistrictExample = new StationDistrictExample();
        stationDistrictExample.createCriteria().andSidEqualTo(station.getId());
        List<StationDistrict> stationDistricts = stationDistrictMapper.selectByExample(stationDistrictExample);
        StationDistrict stationDistrict = stationDistricts.get(0);
        stationDistrict.setDid(station.getDistrict().getId());
        int i1 = stationDistrictMapper.updateByPrimaryKey(stationDistrict);

        StationProvinceExample stationProvinceExample = new StationProvinceExample();
        stationProvinceExample.createCriteria().andSidEqualTo(station.getId());
        List<StationProvince> stationProvinces = stationProvinceMapper.selectByExample(stationProvinceExample);
        StationProvince stationProvince = stationProvinces.get(0);
        stationProvince.setPid(station.getProvince().getId());
        stationProvinceMapper.updateByPrimaryKey(stationProvince);

        //修改Neo4j
        String station_name = station.getName();
        int level = station.getCurrlevel();
        int status = station.getIsAlert();
        Neo4jUtils.updateStation(station.getId(),station_name,level,status);

        //修改负责人
        Neo4jUtils.deleteRel(originCharger,station.getId());
        Neo4jUtils.createRelWithStationAndCharger(station.getId(),station.getResponsible());

        //修改省市
        Neo4jUtils.deleteRel(station.getId(),originProvince);
        Neo4jUtils.createRelBetweenStationAndProvince(station.getId(),String.valueOf(station.getProvince().getId()));

        //修改流域
        Neo4jUtils.deleteRel(station.getId(),originBasin);
        Neo4jUtils.createRelBetweenStationAndBasin(station.getId(),station.getDistrict().getId());

        simpMessagingTemplate.convertAndSend("/topic/getNewDataForBD","有新消息了");
        if(i != 0 && i1 != 0){
            return 1;
        }

        return 0;
    }

    public int deleteStation(String stationId){
        //删除与站点有关的设备
        EquipStaExample equipStaExample = new EquipStaExample();
        equipStaExample.createCriteria().andSidEqualTo(stationId);
        equipStaMapper.deleteByExample(equipStaExample);


//        List<EquipSta> equipStas = equipStaMapper.selectByExample(equipStaExample);
//        if(!CollectionUtils.isEmpty(equipStas)){
//            for (EquipSta equipSta : equipStas){
//                equipSta.setSid("000");
//                equipStaMapper.updateByExample(equipSta,equipStaExample);
//                equipStaMapper.deleteByExample(equipStaExample);
//            }
//        }
//
        //删除站点与流域之间的关系
        StationDistrictExample stationDistrictExample = new StationDistrictExample();
        stationDistrictExample.createCriteria().andSidEqualTo(stationId);
        stationDistrictMapper.deleteByExample(stationDistrictExample);

        //删除站点与省市之间的关系
        StationProvinceExample stationProvinceExample = new StationProvinceExample();
        stationProvinceExample.createCriteria().andSidEqualTo(stationId);
        stationProvinceMapper.deleteByExample(stationProvinceExample);

        //删除neo4j中的关系
        Neo4jUtils.deleteEntity(stationId);

//        StationExample stationExample1 = new StationExample();
//        List<Station> stations = stationMapper.selectByExample(stationExample1);
//        for (Station station : stations){
//            if(station.getDownstreamId() != null){
//                if(station.getDownstreamId().equals(stationId)){
//                    station.setDownstreamId(null);
//                }
//            }
//            if(station.getUpstreamId() != null){
//                if(station.getUpstreamId().equals(stationId)){
//                    station.setUpstreamId(null);
//                }
//            }
//
//
//            stationMapper.updateByPrimaryKey(station);
//        }

        //删除站点
        StationExample stationExample = new StationExample();
        stationExample.createCriteria().andIdEqualTo(stationId);
        int i = stationMapper.deleteByExample(stationExample);

        return i;


    }

    public List<String> getRelBySid(String stationId){
        List<String> relBySid = Neo4jUtils.getRelBySid(stationId);
        return relBySid;
    }

    public int addDistrict(District district){
        int insert = districtMapper.insert(district);
        return insert;
    }

    public int modifyDistrict(District district){
//        DistrictExample districtExample = new DistrictExample();
//        districtExample.createCriteria().andIdEqualTo(district.getId());
        int i = districtMapper.updateByPrimaryKey(district);
        return i;
    }

    public int deleteDistrict(String id){
        StationDistrictExample stationDistrictExample = new StationDistrictExample();
        stationDistrictExample.createCriteria().andDidEqualTo(id);
        int i = stationDistrictMapper.deleteByExample(stationDistrictExample);

        int i1 = districtMapper.deleteByPrimaryKey(id);


        return i1;
    }

    public int addEquip(Equipment equipment){
        int insert = equipmentMapper.insert(equipment);

        EquipSta equipSta = new EquipSta();
        equipSta.setEid(equipment.getId());
        equipSta.setSid(equipment.getStation().getId());

        int insert1 = equipStaMapper.insert(equipSta);

        if(insert !=0 && insert1 != 0){
            return 1;
        }

        return 0;

    }

    //
    public int modifyEquip(Equipment equipment){
        EquipStaExample equipStaExample = new EquipStaExample();
        equipStaExample.createCriteria().andEidEqualTo(equipment.getId());
        List<EquipSta> equipStas = equipStaMapper.selectByExample(equipStaExample);
        if(equipStas != null && equipStas.size() != 0){
            EquipSta equipSta = equipStas.get(0);
            equipSta.setSid(equipment.getStation().getId());
            int i1 = equipStaMapper.updateByExample(equipSta, equipStaExample);

            int i = equipmentMapper.updateByPrimaryKey(equipment);

            if( i1 != 0 || i != 0){
                return 1;
            }

            return 0;
        }

        return 0;
    }

    public List<NewestWaterData> getNewestData(){
        List<NewestWaterData> newestWaterData = stationMapper.getNewestWaterData();
        return newestWaterData;
    }

    public List<Equipment> getBreakDownEquip(){
        List<Equipment> breakDownEquip = equipmentMapper.getBreakDownEquip();
        return breakDownEquip;
    }


    public List<HistoryList> getHistoryList(){
        HistoryListExample example = new HistoryListExample();
        List<HistoryList> historyLists = historyListMapper.selectByExample(example);
        return historyLists;
    }

    public List<HistoryRecord> getHistoryDetails(String createTime){
        HistoryRecordExample example = new HistoryRecordExample();
        HistoryRecordExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeEqualTo(createTime);

        List<HistoryRecord> historyRecords = historyRecordMapper.selectByExample(example);
        return historyRecords;
    }

    public Map<String,List<Integer>> getHistoryByDistrict(String createTime){
        Map<String,List<Integer>> map = new HashMap<>();
        List<District> allDistrict = getAllDistrict();
        for (District district : allDistrict){
            String id = district.getId();
            String name = district.getName();
            HistoryRecordExample example = new HistoryRecordExample();
            HistoryRecordExample.Criteria criteria = example.createCriteria();
            criteria.andDidEqualTo(id);
            criteria.andCreateTimeEqualTo(createTime);
            List<HistoryRecord> historyRecords = historyRecordMapper.selectByExample(example);
            List<Integer> list = new ArrayList<>();

            int oneCount = 0;
            int twoConut = 0;
            int threeCount = 0;
            int fourCount = 0;
            int fiveCount = 0;
            for(HistoryRecord historyRecord : historyRecords){
                switch (historyRecord.getCurrLevel()){
                    case 1:
                        oneCount += 1;
                        break;
                    case 2:
                        twoConut += 1;
                        break;
                    case 3:
                        threeCount += 1;
                        break;
                    case 4:
                        fourCount += 1;
                        break;
                    case 5:
                        fiveCount += 1;
                        break;
                }
            }
            list.add(oneCount);
            list.add(twoConut);
            list.add(threeCount);
            list.add(fourCount);
            list.add(fiveCount);

            map.put(name,list);

        }

        return map;
    }

    public List<Waterdata> getWaterdataByEid(String eid){
        WaterdataExample waterdataExample = new WaterdataExample();
        WaterdataExample.Criteria criteria = waterdataExample.createCriteria();
        criteria.andEidEqualTo(eid);
        List<Waterdata> waterdata = waterdataMapper.selectByExample(waterdataExample);
        return waterdata;
    }

    public Station getStationById(String sid){
        StationExample stationExample = new StationExample();
        StationExample.Criteria criteria = stationExample.createCriteria();
        criteria.andIdEqualTo(sid);
        List<Station> stations = stationMapper.selectByExample(stationExample);
        Station station = null;
        if (stations.size() != 0 && stations != null){
             station = stations.get(0);
        }

        return station;
    }

    public String getEidBySid(String sid){
        EquipStaExample equipStaExample = new EquipStaExample();
        EquipStaExample.Criteria criteria = equipStaExample.createCriteria();
        criteria.andSidEqualTo(sid);
        List<EquipSta> equipStas = equipStaMapper.selectByExample(equipStaExample);
        String eid = null;
        if(equipStas.size() != 0 && equipStas != null){
            eid = equipStas.get(0).getEid();
        }

        return eid;
    }

    public int update_alert(int isAlert,String stationId){
        StationExample stationExample = new StationExample();
        StationExample.Criteria criteria = stationExample.createCriteria();
        criteria.andIdEqualTo(stationId);
        List<Station> stations = stationMapper.selectByExample(stationExample);
        Station station = stations.get(0);
        if(isAlert == 0){
            station.setIsAlert(1);
        }
        else {
            station.setIsAlert(0);
        }

        int i = stationMapper.updateByPrimaryKey(station);
        return i;
    }
}
