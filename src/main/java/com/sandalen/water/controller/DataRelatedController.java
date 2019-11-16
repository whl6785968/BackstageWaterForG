package com.sandalen.water.controller;

import com.sandalen.water.bean.Equipment;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.SearchCondition;
import com.sandalen.water.service.DataRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
