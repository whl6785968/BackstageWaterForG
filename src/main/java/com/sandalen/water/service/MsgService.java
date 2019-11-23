package com.sandalen.water.service;

import com.sandalen.water.bean.Msg;
import com.sandalen.water.bean.MsgExample;
import com.sandalen.water.bean.MsgUser;
import com.sandalen.water.bean.MsgUserExample;
import com.sandalen.water.dao.MsgMapper;
import com.sandalen.water.dao.MsgUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;

    @Autowired
    private MsgUserMapper msgUserMapper;

    public int posting(Msg msg){
        int insert = msgMapper.insert(msg);
        return insert;
    }

    public List<Msg> getUnReviewMsg(){
        List<Msg> unReviewMsg = msgMapper.getUnReviewMsg();
        return unReviewMsg;
    }

    public Msg getUnReviewMsgDetail(String postId){
        Msg msg = msgMapper.getUnReviewMsgDetail(postId);
        return msg;
    }

    public int passPost(String postId){
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

    public List<Msg> getReadableMsg(){
        List<Msg> readableMsg = msgMapper.getReadableMsg();
        return readableMsg;
    }

    public Msg getReadableMsgDetail(int postId){
        Msg msg = msgMapper.getReadableMsgDetail(postId);
        return msg;
    }

    public void insertMsgUser(MsgUser msgUser){
        msgUserMapper.insert(msgUser);
    }
}
