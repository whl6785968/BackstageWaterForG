package com.sandalen.water.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;

public class HttpClientUtils {
    public static String getRequest(String uri) throws IOException {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(uri);
        getMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
        int statusCode = httpClient.executeMethod(getMethod);

        if(statusCode != HttpStatus.SC_OK){
            return "request fail";
        }

        byte[] responseBody = getMethod.getResponseBodyAsString().getBytes(getMethod.getResponseCharSet());

        String response = new String(responseBody, "utf-8");

        return response;
    }
}
