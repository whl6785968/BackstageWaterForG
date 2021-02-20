package com.sandalen.water.service;

import com.sandalen.water.bean.Baike;
import com.sandalen.water.bean.ComplexKg;
import com.sandalen.water.bean.ComplexKgExample;
import com.sandalen.water.dao.ComplexKgMapper;
import com.sandalen.water.util.HttpClientUtils;
import com.sandalen.water.util.IdUtils;
import com.sandalen.water.util.Neo4jUtils;
import org.neo4j.driver.v1.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Service
public class KgService {

    @Autowired
    private ComplexKgMapper complexKgMapper;

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

    public Map<String,Integer> isInNeo4j(List<String> entities){
        Map<String,Integer> map = new HashMap<>();
        for(String entity : entities){
            List<Record> records = Neo4jUtils.searchByNameAndSpecialAmbiguous(entity);
            if(records != null && records.size() != 0){
                map.put(entity,1);
            }
            else{
                map.put(entity,0);
            }
        }

        return map;
    }

    public List<Baike>getEntityInfo(String entityName){
        List<Record> records = Neo4jUtils.searchBySpecialAmbiguous(entityName);
        Record record = records.get(0);
        String define = record.get("n").get("define").toString().replace("\"","");

        List<Baike> baikes = new ArrayList<>();
        Baike baike = new Baike();
        baike.setAttr("define");
        baike.setValue(define);
        baikes.add(baike);

        for(Record r : records){
            String relationship = r.get("r").get("real_relation").toString().replace("\"","");
            String value = r.get("m").get("name").toString().replace("\"","");

            Baike baike1 = new Baike();
            baike1.setAttr(relationship);
            baike1.setValue(value);

            baikes.add(baike1);
        }

        return baikes;
    }

    public List<ComplexKg> getComplexKgByEntity(String entityName){
        ComplexKgExample complexKgExample = new ComplexKgExample();
        complexKgExample.createCriteria().andEntityEqualTo(entityName);

        List<ComplexKg> complexKgs = complexKgMapper.selectByExample(complexKgExample);

        return complexKgs;
    }

    @Transactional
    public int addAttrByEntity(String entityName,String relation,String content){
        ComplexKg complexKg = new ComplexKg();
        complexKg.setKgId(IdUtils.getId());
        complexKg.setEntity(entityName);
        complexKg.setRealtion(relation);
        complexKg.setContent(content);
        complexKg.setCreateTime(new Date());
        complexKg.setUpdateTime(new Date());

        int insert = complexKgMapper.insert(complexKg);
        return insert;
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
