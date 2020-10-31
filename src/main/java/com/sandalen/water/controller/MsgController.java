package com.sandalen.water.controller;

import com.sandalen.water.bean.*;
import com.sandalen.water.service.MsgService;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
        String uid = msg.getUid();
        int posting = msgService.posting(msg);

        if(posting != 0){
            List<User> adminUser = userService.getAdminUser();
            for(User user:adminUser){
                if(!user.getUserid().equals(uid)){
                    MsgUser msgUser = new MsgUser();
                    msgUser.setMid(postId);
                    msgUser.setUid(user.getUserid());
                    msgUser.setIsRead(0);
                    msgService.insertMsgUser(msgUser);
                }
                else{
                    MsgUser msgUser = new MsgUser();
                    msgUser.setMid(postId);
                    msgUser.setUid(user.getUserid());
                    msgUser.setIsRead(1);
                    msgService.insertMsgUser(msgUser);
                }

            }

            return RespBean.ok("发布成功");
        }
        return RespBean.error("发布失败");
    }

    @MessageMapping("/getMsgCount")
    @SendTo("/topic/pullMsg")
    public RespBean getMsgCount(){
        System.out.println("服务端接收到新消息了");
        return RespBean.ok("有新消息了");
    }

    @RequestMapping("/getReadableMsg")
    public RespBean getReadableMsg(String userId){
        List<Msg> readableMsg = msgService.getReadableMsg(userId);
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

    @RequestMapping("/getUnReadMsgCountByUser")
    public RespBean getUnReadMsgCountByUser(String userId){
        System.out.println("userId is " + userId    );
        int unReadMsgCount = msgService.getUnReadMsgCount(userId);
        return RespBean.ok("获取成功",unReadMsgCount);
    }

    @RequestMapping("/hasRead")
    public RespBean hasRead(String postId,String userId){
        int i = msgService.hasRead(postId, userId);
        if(i == 0){
            return RespBean.error("修改失败");
        }
        return RespBean.ok("修改成功");
    }

    @RequestMapping("/deletePost")
    public RespBean deletePost(String postId,String userId){
        int i = msgService.deletePost(postId, userId);
        if(i == 0){
            return RespBean.error("删除失败");
        }
        return RespBean.ok("修改成功");
    }

    @RequestMapping("/reply")
    public RespBean reply(String post_id,String user_id,String content){
        Reply reply = new Reply();
        reply.setReplyId(IdUtils.getId());
        reply.setReplyTime(new Date(System.currentTimeMillis()));
        reply.setContent(content);
        reply.setUid(user_id);
        reply.setPostId(post_id);
        int i = msgService.reply(reply);
        if(i == 0){
            return RespBean.error("回复失败");
        }
        return RespBean.ok("回复成功");
    }

    @RequestMapping("/getReply")
    public RespBean getReply(String post_id){
        List<Reply> replies = msgService.getReply(post_id);
        return RespBean.ok("获取数据成功",replies);
    }
}
