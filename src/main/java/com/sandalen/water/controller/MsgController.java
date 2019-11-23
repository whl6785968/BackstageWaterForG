package com.sandalen.water.controller;

import com.sandalen.water.bean.Msg;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;

    @RequestMapping("/posting")
    public RespBean posting(@RequestBody Msg msg){
        msg.setIsreviewd(0);
        msg.setPosttime(new Date());

        int posting = msgService.posting(msg);
        if(posting  != 0){
            return RespBean.ok("发布成功");
        }
        return RespBean.error("发布失败");
    }

    @RequestMapping("/getUnReviewMsg")
    public RespBean getUnReviewMsg(int isReviewed){
        List<Msg> unReviewMsg = msgService.getUnReviewMsg(isReviewed);
        return RespBean.ok("获取数据成功",unReviewMsg);
    }

    @RequestMapping("/getUnReviewMsgDetail")
    public RespBean getUnReviewMsgDetail(int postId){
        Msg msg = msgService.getUnReviewMsgDetail(postId);

        if(!StringUtils.isEmpty(msg)){
            return RespBean.ok("获取成功",msg);
        }

        return RespBean.error("帖子不存在或者获取数据失败");
    }

    @RequestMapping("/passPost")
    public RespBean passPost(int postId){
        int i = msgService.passPost(postId);

        if(i == 0){
            return RespBean.error("帖子不存在或者操作失败");
        }

        return RespBean.ok("审核通过");
    }

    @RequestMapping("/notPass")
    public RespBean notPass(int postId){
        int i = msgService.notPass(postId);

        if(i == 0){
            return RespBean.error("操作失败");
        }

        return RespBean.ok("操作成功");
    }
}
