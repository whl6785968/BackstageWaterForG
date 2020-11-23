package com.sandalen.water.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sandalen.water.bean.CustomPage;
import com.sandalen.water.bean.Entity4Neo;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.SingleEntity;
import com.sandalen.water.service.KgService;
import com.sandalen.water.util.Neo4jUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequestMapping("/kg")
@RestController
public class KgController {
    @Autowired
    private KgService kgService;

    @RequestMapping("/saveEntity")
        public RespBean saveEntity(String entity,String entityAmbiguous,String entityLink,String startLabel,
                               String relation,String des,String value,String valueAmbiguous,
                               String valueLink,String endLabel){
        boolean isCreated = Neo4jUtils.create(entity,entityAmbiguous,entityLink,startLabel,relation,des,
                value,valueAmbiguous,valueLink,endLabel);
        if(isCreated){
            return RespBean.ok("创建数据成功");
        }

        return RespBean.error("创建失败");

    }

    @RequestMapping("/search")
    public RespBean searchAll(String entityName){
        Map<String, Object> map = Neo4jUtils.searchAll(entityName);
        return RespBean.ok("获取数据成功",map);
    }

    @RequestMapping("/search2")
    public RespBean search2(String entityName,String entityId){
        List<Entity4Neo> search = Neo4jUtils.search(entityName,entityId);
        return RespBean.ok("success",search);
    }

    @RequestMapping("/getEntities")
    public RespBean getEntities(String entityName,String entityAmbiguous,int page,int pageSize){
        List<SingleEntity> singleEntity = Neo4jUtils.getSingleEntity(entityName, entityAmbiguous);
        int totalCount = singleEntity.size();

        CustomPage customPage = new CustomPage(page, pageSize,totalCount);
        customPage.setList(singleEntity);
//        PageInfo<SingleEntity> pageInfo = new PageInfo<>(singleEntity);

        return RespBean.ok("获取数据成功",customPage);
    }

    @RequestMapping("/getRelation")
    public RespBean getRelation(String entityId){
        List<Entity4Neo> entity4NeoList = Neo4jUtils.getRelationById(entityId);
        return RespBean.ok("获取数据成功",entity4NeoList);
    }

    @RequestMapping("/createEntitiy")
    public RespBean createEntitiy(String entityName,String entityAmbiguous,String entityLink,String label){
        boolean b = Neo4jUtils.createEntitiy(entityName, entityAmbiguous, entityLink, label);
        if(b){
            return RespBean.ok("创建实体成功");
        }
        return RespBean.error("实体可能已经存在，创建失败");
    }

    @RequestMapping("/tstPython")
    public RespBean tstPython() throws IOException {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod("http://127.0.0.1:5000/second/");
        getMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");

        int statusCode = httpClient.executeMethod(getMethod);
        if (statusCode != HttpStatus.SC_OK) {// 打印服务器返回的状态
            System.out.println("Method failed: " + getMethod.getStatusLine());
            return RespBean.error("failed");
        }

        byte[] responseBody = getMethod.getResponseBodyAsString().getBytes(getMethod.getResponseCharSet());

        String response = new String(responseBody, "utf-8");
        return RespBean.ok("success",response);

    }

    @RequestMapping("/ner")
    public RespBean ner(String sentence) throws IOException {
        List<String> ner = kgService.ner(sentence);
        return RespBean.ok("success",ner);
    }

    @RequestMapping("/qa")
    public RespBean qa(String question) throws Exception {
        List<String> qa = kgService.qa(question);
        return RespBean.ok("success",qa);
    }

}
