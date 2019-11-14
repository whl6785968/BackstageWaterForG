package com.sandalen.water.util;

import com.alibaba.fastjson.JSON;
import com.sandalen.water.bean.RespBean;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ResponseUtils {
    public static void out(ServletResponse response,RespBean respBean){
        PrintWriter printWriter = null;
        try{
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            printWriter = response.getWriter();
            printWriter.println(JSON.toJSONString(respBean));
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            printWriter.close();
        }
    }

    public static void getResponse(HttpServletResponse httpServletResponse, String msg, Integer status){
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(JSON.toJSONString(RespBean.unStatus(msg,status)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

}
