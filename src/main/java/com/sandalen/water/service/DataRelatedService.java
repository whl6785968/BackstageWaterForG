package com.sandalen.water.service;


import com.github.pagehelper.PageHelper;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<Equipment> getEquipAndStation(SearchCondition searchCondition){
        List<Equipment> equipAndStation = equipmentMapper.getEquipAndStation(searchCondition);
        return equipAndStation;
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

    public int addStation(Station station){
        int insert = stationMapper.insert(station);
        StationDistrict stationDistrict = new StationDistrict();
        stationDistrict.setSid(station.getId());
        stationDistrict.setDid(station.getDistrict().getId());
        int insert1 = stationDistrictMapper.insert(stationDistrict);

        if(insert1 !=0 && insert != 0){
            return 1;
        }

        return 0;
    }

    public int addDistrict(District district){
        int insert = districtMapper.insert(district);
        return insert;
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
