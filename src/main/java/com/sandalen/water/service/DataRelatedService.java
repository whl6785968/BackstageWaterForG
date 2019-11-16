package com.sandalen.water.service;


import com.sandalen.water.bean.Equipment;
import com.sandalen.water.bean.SearchCondition;
import com.sandalen.water.dao.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRelatedService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    public List<Equipment> getEquipAndStation(SearchCondition searchCondition){
        List<Equipment> equipAndStation = equipmentMapper.getEquipAndStation(searchCondition);
        return equipAndStation;
    }

//    public List<String> getEquipModel(){
//
//    }
}
