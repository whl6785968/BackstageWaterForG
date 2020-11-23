package com.sandalen.water.service;

import com.sandalen.water.util.HttpClientUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class KgService {
    public List<String> ner(String sentence) throws IOException {
        String params = "sentence=" + URLEncoder.encode(sentence,"utf-8");
        String uri = "http://localhost:5000/ner/?";
        uri = uri + params;
        String response = HttpClientUtils.getRequest(uri);

        if(response.startsWith("request fail")){
            System.out.println("发生异常");
            return null;
        }

        Object o = HttpClientUtils.parseResponse(response);
        String s = o.toString();
        s = s.replace("[","").replace("'","").replace("]","");

        List<String> res = new ArrayList<>();
        String[] strings = s.split(",");
        for(String ss : strings){
            res.add(ss);
        }

        return res;
    }

    public List<String> qa(String question) throws Exception {
        String params = "question=" + URLEncoder.encode(question,"utf-8");
        String uri = "http://localhost:5000/qa/?";
        uri = uri + params;

        String response = HttpClientUtils.getRequest(uri);

        if(response.startsWith("request fail")){
            System.out.println("发生异常");
            return null;
        }

        Object o = HttpClientUtils.parseResponse(response);
        String s = o.toString();
        s = s.replace("[","").replace("'","").replace("]","");
        List<String> res = new ArrayList<>();
        String[] strings = s.split(",");
        for(String ss : strings){
            res.add(ss);
        }

        return res;
    }
}
