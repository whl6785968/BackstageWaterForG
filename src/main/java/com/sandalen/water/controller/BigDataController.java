package com.sandalen.water.controller;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.Station;
import com.sandalen.water.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/bd/basic/")
@RestController
public class BigDataController {
    @Autowired
    private DataService dataService;


    @RequestMapping("/getErrStation")
    public RespBean getErrStation(){
        List<Station> errStation = dataService.getErrStation();
        return RespBean.ok("success get data",errStation);
    }

    @RequestMapping("/getErrStationAndRecord")
    public RespBean getErrStationAndRecord(){
        List<Station> errStationAndRecord = dataService.getErrStationAndRecord();
        return RespBean.ok("success get data",errStationAndRecord);
    }
}
