package com.sandalen.water.controller;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.service.KgService;
import com.sandalen.water.util.Neo4jUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/kg")
@RestController
public class KgController {
    @Autowired
    private KgService kgService;

    @RequestMapping("/saveEntity")
    public RespBean saveEntity(String entityFrom,String startLabel,String relation,String entityTo,String endLabel){
        boolean isCreated = Neo4jUtils.create(entityFrom,startLabel, relation, entityTo, endLabel);
        if(isCreated){
            return RespBean.ok("创建数据成功");
        }

        return RespBean.error("创建失败");

    }

    @RequestMapping("/search")
    public RespBean searchAll(String entityName){
        Map<String, Object> map = Neo4jUtils.searchAll(entityName);
        return RespBean.ok("获取数据成功",map);
    }

}
