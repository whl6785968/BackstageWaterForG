package com.sandalen.water.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sandalen.water.bean.*;
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
    public RespBean getAllStation(int page,int pageSize){
        System.out.println(page);
        System.out.println(pageSize);
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(page,pageSize);
        List<Station> allInfoForStation = dataRelatedService.getAllInfoForStation(map);

        PageInfo<Station> stationPageInfo = new PageInfo<>(allInfoForStation);

        if(allInfoForStation != null){
            return RespBean.ok("获取数据成功",stationPageInfo);
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


    @RequestMapping("/addDistrict")
    public RespBean addDistrict(@RequestBody District district){
        int i = dataRelatedService.addDistrict(district);
        if(i != 0){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping("/getAllEquip")
    public RespBean getAllEquip(){
        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);
        return RespBean.ok("获取数据成功",equipAndStation);
    }

    @RequestMapping("/addEquip")
    public RespBean addEquip(@RequestBody Equipment equipment){
        int i = dataRelatedService.addEquip(equipment);
        if(i != 0){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
