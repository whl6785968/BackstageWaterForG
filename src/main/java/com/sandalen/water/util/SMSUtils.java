package com.sandalen.water.util;


import com.alibaba.druid.util.HttpClientUtils;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.IOException;

public class SMSUtils {
    private static final String SMS_url = "http://sms.webchinese.cn/web_api/";

    public static Integer send(String Uid, String Key, String number, String desc) throws IOException {
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(SMS_url);
        postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");

        NameValuePair[] data = {
                new NameValuePair("Uid", Uid),
                new NameValuePair("Key", Key),
                new NameValuePair("smsMob", number),
                new NameValuePair("smsText", desc)
        };

        postMethod.setRequestBody(data);

        httpClient.executeMethod(postMethod);
        int statuCode = postMethod.getStatusCode();
        Header[] headers = postMethod.getRequestHeaders();

        String result = new String(postMethod.getResponseBodyAsString().getBytes("gbk"));
        postMethod.releaseConnection();

        System.out.println("statuCode"+statuCode);
        System.out.println("result"+result);
        return 1;
    }

    public static String getMessage(Integer code) {
        String message;
        if (code > 0) {
            message = "SMS-f发送成功！短信量还有" + code + "条";
        } else if (code == -1) {
            message = "SMS-没有该用户账户";
        } else if (code == -2) {
            message = "SMS-接口密钥不正确";
        } else if (code == -21) {
            message = "SMS-MD5接口密钥加密不正确";
        } else if (code == -3) {
            message = "SMS-短信数量不足";
        } else if (code == -11) {
            message = "SMS-该用户被禁用";
        } else if (code == -14) {
            message = "SMS-短信内容出现非法字符";
        } else if (code == -4) {
            message = "SMS-手机号格式不正确";
        } else if (code == -41) {
            message = "SMS-手机号码为空";
        } else if (code == -42) {
            message = "SMS-短信内容为空";
        } else if (code == -51) {
            message = "SMS-短信签名格式不正确接口签名格式为：【签名内容】";
        } else if (code == -6) {
            message = "SMS-IP限制";
        } else {
            message = "其他错误";
        }
        return message;
    }

    public static void main(String[] args) throws IOException {
        String descr = "测试通过";
        Integer send = send("whl6785968", "d41d8cd98f00b204e980", "18245803818", descr);
    }
}