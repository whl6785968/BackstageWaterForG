package com.sandalen.water.service;

import com.sandalen.water.bean.Msg;
import com.sandalen.water.dao.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgService {
    @Autowired
    private MsgMapper msgMapper;

    public int posting(Msg msg){
        int insert = msgMapper.insert(msg);
        return insert;
    }

    public List<Msg> getUnReviewMsg(int isReviewed){
        List<Msg> unReviewMsg = msgMapper.getUnReviewMsg(isReviewed);
        return unReviewMsg;
    }

    public Msg getUnReviewMsgDetail(int postId){
        Msg msg = msgMapper.getUnReviewMsgDetail(postId);
        return msg;
    }

    public int passPost(int postId){
        Msg msg = msgMapper.selectByPrimaryKey(postId);
        if(msg == null){
            return 0;
        }
        msg.setIsreviewd(1);

        int i = msgMapper.updateByPrimaryKey(msg);
        return i;
    }

    public int notPass(int postId){
        int i = msgMapper.deleteByPrimaryKey(postId);
        return i;
    }
}
