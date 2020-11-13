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
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(page,pageSize);
        List<Station> allInfoForStation = dataRelatedService.getAllInfoForStation(map);

        PageInfo<Station> stationPageInfo = new PageInfo<>(allInfoForStation);


        if(allInfoForStation != null){
            return RespBean.ok("获取数据成功",stationPageInfo);
        }

        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getBasinStructure")
    public RespBean getBasinStructure(String stationId){
        List<String> list = dataRelatedService.getRelBySid(stationId);
        return RespBean.ok("success",list);
    }

    @RequestMapping("/getAllUser")
    public RespBean getAllPerson(){
        List<Userinfo> allUser = dataRelatedService.getAllUser();
        return RespBean.ok("获取数据成功",allUser);

    }

    @RequestMapping("/getAllDistrict")
    public RespBean getAllDistrict(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<District> allDistrict = dataRelatedService.getAllDistrict();
        PageInfo<District> pageInfo = new PageInfo<>(allDistrict);
        return RespBean.ok("获取数据成功",pageInfo);
    }

    @RequestMapping("/getAllProvince")
    public RespBean  getAllProvince(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<Province> province = dataRelatedService.getAllProvince();
        PageInfo<Province> pageInfo = new PageInfo<>(province);
        return RespBean.ok("获取数据成功",pageInfo);
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

    @RequestMapping("/modifyStation")
    public RespBean modifyStation(@RequestBody Station station){
        int i = dataRelatedService.modifyStation(station);
        if(i != 0){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }


    @RequestMapping("/deleteStation")
    public RespBean deleteStation(String stationId){
        int i = dataRelatedService.deleteStation(stationId);

        if(i != 0){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }


    @RequestMapping("/addDistrict")
    public RespBean addDistrict(@RequestBody District district){
        int i = dataRelatedService.addDistrict(district);
        if(i != 0){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping("/modifyDistrict")
    public RespBean modifyDistrict(@RequestBody District district){
        int i = dataRelatedService.modifyDistrict(district);
        if(i > 0){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @RequestMapping("/deleteDistrict")
    public RespBean deleteDistrict(String id){
        int i = dataRelatedService.deleteDistrict(id);
        if(i > 0){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");

    }

    @RequestMapping("/getAllEquip")
    public RespBean getAllEquip(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        SearchCondition searchCondition = new SearchCondition();
        List<Equipment> equipAndStation = dataRelatedService.getEquipAndStation(searchCondition);
        PageInfo<Equipment> pageInfo = new PageInfo<>(equipAndStation);
        return RespBean.ok("获取数据成功",pageInfo);
    }

    @RequestMapping("/addEquip")
    public RespBean addEquip(@RequestBody Equipment equipment){
        int i = dataRelatedService.addEquip(equipment);
        if(i != 0){
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @RequestMapping("/modifyEquip")
    public RespBean modifyEquip(@RequestBody Equipment equipment){
        int i = dataRelatedService.modifyEquip(equipment);
        if(i != 0){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @RequestMapping("/getAllEnterprise")
    public RespBean getAllEnterprise(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<Enp> allEnterprise = dataRelatedService.getAllEnterprise();
        PageInfo<Enp> pageInfo = new PageInfo<>(allEnterprise);
        return RespBean.ok("获取数据成功",pageInfo);
    }

    @RequestMapping("/addEnterprise")
    public RespBean addEnterprise(@RequestBody Enp enp){
        int i = dataRelatedService.addEnterprise(enp);

        if(i != 0){
            return RespBean.ok("添加成功");
        }

        return RespBean.error("添加失败");
    }

    @RequestMapping("/updateEnterprise")
    public RespBean updateEnterprise(@RequestBody Enp enp){
        int i = dataRelatedService.updateEnterprise(enp);

        if(i != 0){
            return RespBean.ok("添加成功");
        }

        return RespBean.error("添加失败");
    }

    @RequestMapping("/deleteEnterprise")
    public RespBean deleteEnterprise(int id){
        int i = dataRelatedService.deleteEnterprise(id);

        if(i != 0){
            return RespBean.ok("添加成功");
        }

        return RespBean.error("添加失败");
    }
}
