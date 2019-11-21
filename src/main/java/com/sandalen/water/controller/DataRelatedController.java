package com.sandalen.water.controller;

import com.sandalen.water.bean.*;
import com.sandalen.water.service.DataRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/data/basic/")
@RestController
public class DataRelatedController {

    @Autowired
    private DataRelatedService dataRelatedService;

    @RequestMapping("/getEquipAndStation")
    public RespBean getEquipAndStation(@RequestBody SearchCondition searchCondition){
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);
        if(!StringUtils.isEmpty(equipAndStation)){
            return RespBean.ok("获取数据成功",equipAndStation);
        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getWaterData")
    public RespBean getWaterData(String eid){
        List<Waterdata> formatWaterData = new ArrayList<>();
        List<Waterdata> waterDatas = dataRelatedService.getWaterData(eid);
        if(!StringUtils.isEmpty(waterDatas)){
//            for(Waterdata waterdata:waterDatas){
//
//            }
            return RespBean.ok("获取数据成功",waterDatas);

        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getStationForMap")
    public RespBean getStationForMap(){
        List<Station> stationForMap = dataRelatedService.getStationForMap();
        if(!StringUtils.isEmpty(stationForMap)){
            return RespBean.ok("获取数据成功",stationForMap);
        }
        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getAllInfoForStation")
    public RespBean getAllInfoForStation(String district,String responsible,String level){
        System.out.println(district + ":" + ":" + responsible + ":" + level);
        HashMap<String, Object> map = new HashMap<>();
        map.put("district",district);
        map.put("responsible",responsible);
        if(level != null && level != ""){
            map.put("nlevel",Integer.parseInt(level));
        }
        map.put("nlevel",level);

        List<Station> stations = dataRelatedService.getAllInfoForStation(map);
        if(!StringUtils.isEmpty(stations)){
            return RespBean.ok("获取数据成功",stations);
        }
        return RespBean.error("获取数据失败");
    }

}
