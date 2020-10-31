package com.sandalen.water.controller;

import com.alibaba.fastjson.JSON;
import com.sandalen.water.bean.*;
import com.sandalen.water.service.DataRelatedService;
import edu.princeton.cs.algs4.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/report/basic/")
@RestController
public class ReportController {
    @Autowired
    private DataRelatedService dataRelatedService;

    @RequestMapping("/getHistoryList")
    public RespBean getHistoryList(){
        List<HistoryList> historyList = dataRelatedService.getHistoryList();
        return RespBean.ok("获取数据成功",historyList);
    }

    @RequestMapping("/getHistoryDetails")
    public RespBean getHistoryDetails(String createTime){
        List<HistoryRecord> historyDetails = dataRelatedService.getHistoryDetails(createTime);
        return RespBean.ok("获取数据成功",historyDetails);
    }

    @RequestMapping("/getHistoryByDistrict")
    public RespBean getHistoryByDistrict(String createTime){
        Map<String, List<Integer>> historyByDistrict = dataRelatedService.getHistoryByDistrict(createTime);
        return RespBean.ok("获取数据成功",historyByDistrict);
    }

    @RequestMapping("/getBreakDownEquip")
    public RespBean getBreakDownEquip(){
        List<Equipment> breakDownEquip = dataRelatedService.getBreakDownEquip();
        return RespBean.ok("获取数据成功",breakDownEquip);
    }

    @RequestMapping("/getNewestData")
    public RespBean getNewestData(){
        List<NewestWaterData> newestData = dataRelatedService.getNewestData();
        return RespBean.ok("success",newestData);
    }



}
