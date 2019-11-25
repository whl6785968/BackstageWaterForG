package com.sandalen.water.controller;


import com.sandalen.water.bean.Msg;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/sys/msg")
@RestController
public class SysMsgController {
    @Autowired
    private MsgService msgService;

    @RequestMapping("/getUnReviewMsg")
    public RespBean getUnReviewMsg(){
        List<Msg> unReviewMsg = msgService.getUnReviewMsg();
        return RespBean.ok("获取数据成功",unReviewMsg);
    }

    @RequestMapping("/passPost")
    public RespBean passPost(String postId,String userId){
        int i = msgService.passPost(postId,userId);

        if(i == 0){
            return RespBean.error("帖子不存在或者操作失败");
        }

        return RespBean.ok("审核通过");
    }


    @RequestMapping("/notPass")
    public RespBean notPass(String postId){
        int i = msgService.notPass(postId);

        if(i == 0){
            return RespBean.error("操作失败");
        }

        return RespBean.ok("操作成功");
    }
}
