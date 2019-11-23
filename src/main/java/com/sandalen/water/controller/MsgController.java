package com.sandalen.water.controller;

import com.sandalen.water.bean.Msg;
import com.sandalen.water.bean.MsgUser;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.User;
import com.sandalen.water.service.MsgService;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@RequestMapping("/msg/basic")
@RestController
public class MsgController {
    @Autowired
    private MsgService msgService;

    @Autowired
    private UserService userService;

    @RequestMapping("/posting")
    public RespBean posting(@RequestBody Msg msg){
        msg.setIsreviewd(0);
        msg.setPosttime(new Date());
        String postId = IdUtils.getId();
        msg.setPostid(postId);
        int posting = msgService.posting(msg);

        if(posting != 0){
            List<User> adminUser = userService.getAdminUser();
            for(User user:adminUser){
                MsgUser msgUser = new MsgUser();
                msgUser.setMid(postId);
                msgUser.setUid(user.getUserid());
                msgUser.setIsRead(0);
                msgService.insertMsgUser(msgUser);
            }

            return RespBean.ok("发布成功");
        }
        return RespBean.error("发布失败");
    }



    @RequestMapping("/getReadableMsg")
    public RespBean getReadableMsg(){
        List<Msg> readableMsg = msgService.getReadableMsg();
        return RespBean.ok("获取数据成功",readableMsg);
    }

    @RequestMapping("/getMsgDetail")
    public RespBean getUnReviewMsgDetail(String postId){
        Msg msg = msgService.getUnReviewMsgDetail(postId);

        if(!StringUtils.isEmpty(msg)){
            return RespBean.ok("获取成功",msg);
        }

        return RespBean.error("帖子不存在或者获取数据失败");
    }


    @RequestMapping("/getReadableMsgDetail")
    public RespBean getReadableMsgDetail(int postId){
        Msg msg = msgService.getReadableMsgDetail(postId);

        if(!StringUtils.isEmpty(msg)){
            return RespBean.ok("获取成功",msg);
        }

        return RespBean.error("帖子不存在或者获取数据失败");
    }
}
