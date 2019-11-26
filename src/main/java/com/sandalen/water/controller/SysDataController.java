package com.sandalen.water.controller;

import com.sandalen.water.bean.District;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.Station;
import com.sandalen.water.bean.Userinfo;
import com.sandalen.water.service.DataRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/sys/data/")
@RestController
public class SysDataController {
    @Autowired
    private DataRelatedService dataRelatedService;

    @RequestMapping("/getAllStation")
    public RespBean getAllStation(){
        HashMap<String, Object> map = new HashMap<>();
        List<Station> allInfoForStation = dataRelatedService.getAllInfoForStation(map);
        if(allInfoForStation != null){
            return RespBean.ok("获取数据成功",allInfoForStation);
        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getAllUser")
    public RespBean getAllPerson(){
        List<Userinfo> allUser = dataRelatedService.getAllUser();
        return RespBean.ok("获取数据成功",allUser);

    }

    @RequestMapping("/getAllDistrict")
    public RespBean getAllDistrict(){
        List<District> allDistrict = dataRelatedService.getAllDistrict();
        return RespBean.ok("获取数据成功",allDistrict);
    }

    @RequestMapping("/addStation")
    public RespBean addStation(@RequestBody Station station){
//        System.out.println(station.toString());
        int i = dataRelatedService.addStation(station);
        if(i > 0){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
