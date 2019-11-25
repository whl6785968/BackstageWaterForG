package com.sandalen.water.bean;

import java.util.Date;

public class Msg {
    private Integer id;

    private String postid;

    private String title;

    private String content;

    private String imglist;

    private Integer isemergency;

    private Integer isreviewd;

    private Date posttime;

    private String type;

    private String uid;

    private Userinfo userinfo;

    private int isRead;

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid == null ? null : postid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImglist() {
        return imglist;
    }

    public void setImglist(String imglist) {
        this.imglist = imglist == null ? null : imglist.trim();
    }

    public Integer getIsemergency() {
        return isemergency;
    }

    public void setIsemergency(Integer isemergency) {
        this.isemergency = isemergency;
    }

    public Integer getIsreviewd() {
        return isreviewd;
    }

    public void setIsreviewd(Integer isreviewd) {
        this.isreviewd = isreviewd;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}