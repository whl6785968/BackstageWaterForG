package com.sandalen.water.bean;

public class RespBean {
    private Integer status;
    private String msg;
    private Object obj;

    private RespBean(){}

    public RespBean(Integer status,String msg,Object obj){
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean build(){
        return new RespBean();
    }

    public static RespBean ok(String msg,Object obj){
        return new RespBean(200,msg, obj);
    }

    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }

    public static RespBean error(String msg,Object obj){
        return new RespBean(500,msg,obj);
    }

    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }

    public static RespBean unStatus(String msg,int status){
        return new RespBean(status,msg,null);
    }

    public static RespBean unStatus(String msg,int status,Object obj){
        return new RespBean(status,msg,obj);
    }

    public static RespBean expired(String msg){
        return new RespBean(401,msg,null);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
