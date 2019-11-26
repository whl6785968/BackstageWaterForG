package com.sandalen.water.service;


import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
}
