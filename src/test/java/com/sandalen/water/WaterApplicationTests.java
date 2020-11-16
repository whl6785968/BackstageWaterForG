package com.sandalen.water;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.structure.Graph;
import com.sandalen.water.util.HttpClientUtils;
import com.sandalen.water.util.Neo4jUtils;
import org.junit.jupiter.api.Test;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;;
import java.util.*;


@SpringBootTest
class WaterApplicationTests {

    @Test
    public void testErrJudge() throws IOException {
//        String uri = "http://127.0.0.1:5000/neo4j/";
//        String response = HttpClientUtils.getRequest(uri);
//        JSONObject jsonObject = JSON.parseObject(response);
//        Object o = JSON.parseObject(jsonObject.getString("data")).get("result");
//        String s = o.toString();
//
//        System.out.println(s);


        List<Record> records = Neo4jUtils.getFactorOrigin("溶解氧");
        Record record = records.get(0);
        System.out.println(record.values().get(0).toString().replace("\"",""));


    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testDate() throws ParseException {
//        Date date = new Date();
//        System.out.println(date);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formatDate = format.format(date);
        String uuid = UUID.randomUUID().toString().replace("-","");
        long l = System.currentTimeMillis();
        System.out.println(uuid);
        System.out.println(uuid + l);

    }
}
