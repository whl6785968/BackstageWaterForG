package com.sandalen.water.controller;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.Waterdata;
import com.sandalen.water.service.AlgoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/algo/basic/")
public class AlgoController {
    @Autowired
    private AlgoService algoService;

    @RequestMapping("/trainIsoForest")
    public RespBean trainIsoForest() throws IOException {
        algoService.trainIsoForest();
        return RespBean.ok("训练成功");
    }

    @RequestMapping("/errCheck")
    public RespBean errCheck() throws IOException {
        List<Map<String, Object>> errInfo = algoService.isoForest();
        return RespBean.ok("操作成功",errInfo);
    }

    @RequestMapping("/isError")
    public RespBean isError(@RequestBody Waterdata waterdata) throws IOException {
        int error = algoService.isError(waterdata);

        return RespBean.ok("预测成功",error);
    }
}
