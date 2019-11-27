package com.sandalen.water.service;


import com.github.pagehelper.PageHelper;
import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Object> getCountByLevel(){
        List<Station> stations = stationMapper.getCountByLevel();

        int oneCount = 0;
        int twoConut = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int preOneCount = 0;
        int preTwoCount = 0;
        int preThreeCount = 0;
        int preFourCount = 0;
        int preFiveCount = 0;
        for(Station station:stations){
            switch (station.getCurrlevel()){
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

        for(Station station:stations){
            switch (station.getPrelevel()){
                case 1:
                    preOneCount += 1;
                    break;
                case 2:
                    preTwoCount += 1;
                    break;
                case 3:
                    preThreeCount += 1;
                    break;
                case 4:
                    preFourCount += 1;
                    break;
                case 5:
                    preFiveCount += 1;
                    break;
            }
        }

        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(oneCount);
        curr.add(twoConut);
        curr.add(threeCount);
        curr.add(fourCount);
        curr.add(fiveCount);

        ArrayList<Integer> pre = new ArrayList<>();
        pre.add(preOneCount);
        pre.add(preTwoCount);
        pre.add(preThreeCount);
        pre.add(preFourCount);
        pre.add(preFiveCount);

        Map<String,Object> map = new HashMap<>();
        map.put("curr",curr);
        map.put("pre",pre);
        return map;
    }

    public List<Equipment> getBreakDownEquip(){
        List<Equipment> breakDownEquip = equipmentMapper.getBreakDownEquip();
        return breakDownEquip;
    }
}
