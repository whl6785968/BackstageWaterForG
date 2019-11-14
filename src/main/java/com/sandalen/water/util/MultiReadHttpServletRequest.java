package com.sandalen.water.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MultiReadHttpServletRequest extends HttpServletRequestWrapper {

    private final byte[] body;

    public MultiReadHttpServletRequest(HttpServletRequest request) {
        super(request);
        body = getBodyString(request).getBytes(Charset.forName("UTF-8"));

    }


    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        //从请求体从获取流
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);

        return new ServletInputStream(){

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }
        };
    }

    private String getBodyString(ServletRequest request){
        StringBuilder sb = new StringBuilder();
        InputStream in = null;
        BufferedReader reader = null;
        try {
            in = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }

    public String getBodyFromForm(ServletRequest request){
        Map<Object, Object> map = new HashMap<>(16);
        String paraName = null;
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()){
            paraName = e.nextElement();
            map.put(paraName,request.getParameter(paraName));
        }

        return JSON.toJSONString(map);
    }

    public String getBodyStringByJson(ServletRequest request){
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null){
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();

    }
}
