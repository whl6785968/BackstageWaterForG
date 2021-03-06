package com.sandalen.water.service;

import com.sandalen.water.bean.*;
import com.sandalen.water.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;

    @Autowired
    private MsgUserMapper msgUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReplyMapper replyMapper;



    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public int star(String userId,String postId){
        MsgUserExample msgUserExample = new MsgUserExample();
        msgUserExample.createCriteria().andMidEqualTo(postId).andUidEqualTo(userId);

        List<MsgUser> msgUsers = msgUserMapper.selectByExample(msgUserExample);

        MsgUser msgUser = msgUsers.get(0);

        if(msgUser.getIsStar() == 0){
            msgUser.setIsStar(1);
        }
        else{
            msgUser.setIsStar(0);
        }

        int i = msgUserMapper.updateByPrimaryKey(msgUser);

        return i;
    }

    public int posting(Msg msg){
        int insert = msgMapper.insert(msg);
        return insert;
    }

    public List<Msg> getStarMsg(String userId){
        List<Msg> starMsg = msgMapper.getStarMsg(userId);
        return starMsg;
    }

    public List<Msg> getUnReviewMsg(){
        List<Msg> unReviewMsg = msgMapper.getUnReviewMsg();
        return unReviewMsg;
    }

    public Msg getUnReviewMsgDetail(String postId){
        Msg msg = msgMapper.getUnReviewMsgDetail(postId);
        return msg;
    }

    public int passPost(String postId,String userId){
        List<String> normalUser = userMapper.getNormalUser();
        MsgUser msgUser;
        for (String user : normalUser){
            if(user.equals(userId)){
                msgUser = new MsgUser();
                msgUser.setMid(postId);
                msgUser.setUid(user);
                msgUser.setIsRead(1);
                msgUserMapper.insert(msgUser);
            }
            else {
                msgUser = new MsgUser();
                msgUser.setMid(postId);
                msgUser.setUid(user);
                msgUser.setIsRead(0);
                msgUserMapper.insert(msgUser);
            }
        }

        MsgExample msgExample = new MsgExample();
        MsgExample.Criteria criteria = msgExample.createCriteria();
        criteria.andPostidEqualTo(postId);
        List<Msg> msgs = msgMapper.selectByExample(msgExample);
        if(msgs == null){
            return 0;
        }
        Msg msg = msgs.get(0);
        msg.setIsreviewd(1);

        int i = msgMapper.updateByPrimaryKey(msg);

        messagingTemplate.convertAndSend("/topic/pullMsg","有新消息啦");

        return i;
    }

    public int notPass(String postId){
        MsgExample msgExample = new MsgExample();
        MsgExample.Criteria criteria = msgExample.createCriteria();
        criteria.andPostidEqualTo(postId);
        List<Msg> msgs = msgMapper.selectByExample(msgExample);
        if(msgs == null){
            return 0;
        }

        MsgUserExample msgUserExample = new MsgUserExample();
        msgUserExample.createCriteria().andMidEqualTo(postId);
        int isDelete = msgUserMapper.deleteByExample(msgUserExample);


        int i = msgMapper.deleteByExample(msgExample);
        return i;
    }

    public List<Msg> getReadableMsg(String userId){
        List<Msg> readableMsg = msgMapper.getReadableMsg(userId);
        return readableMsg;
    }

    public Msg getReadableMsgDetail(int postId){
        Msg msg = msgMapper.getReadableMsgDetail(postId);
        return msg;
    }

    public void insertMsgUser(MsgUser msgUser){
        msgUserMapper.insert(msgUser);
    }

    public int getUnReadMsgCount(String userId){
        int unReadMsgCount = msgMapper.getUnReadMsgCount(userId);
        return unReadMsgCount;
    }

    public int hasRead(String postId,String userId){
        MsgUserExample example = new MsgUserExample();
        MsgUserExample.Criteria criteria = example.createCriteria();
        criteria.andMidEqualTo(postId);
        criteria.andUidEqualTo(userId);

        List<MsgUser> msgUsers = msgUserMapper.selectByExample(example);
        MsgUser msgUser = msgUsers.get(0);
        msgUser.setIsRead(1);

        int i = msgUserMapper.updateByPrimaryKey(msgUser);
        return i;
    }

    public int deletePost(String postId,String userId){
        MsgUserExample msgUserExample = new MsgUserExample();
        MsgUserExample.Criteria criteria = msgUserExample.createCriteria();
        criteria.andMidEqualTo(postId);
        criteria.andUidEqualTo(userId);

        int i = msgUserMapper.deleteByExample(msgUserExample);

        return i;
    }

    public int reply(Reply reply){
        int insert = replyMapper.insert(reply);
        return insert;
    }

    public List<Reply> getReply(String post_id){
        List<Reply> replies = replyMapper.getReply(post_id);
        return replies;
    }
}
