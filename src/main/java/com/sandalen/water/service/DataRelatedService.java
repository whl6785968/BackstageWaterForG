package com.sandalen.water.service;


import com.sandalen.water.bean.*;
import com.sandalen.water.dao.EquipmentMapper;
import com.sandalen.water.dao.StationMapper;
import com.sandalen.water.dao.WaterdataMapper;
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
}
