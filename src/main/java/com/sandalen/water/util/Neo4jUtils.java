package com.sandalen.water.util;


import com.sandalen.water.other.CypherUtils;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Neo4jUtils {
    private static Session session;

    @Autowired
    public Neo4jUtils(Session NeoSession){
        Neo4jUtils.session= NeoSession;
    }

    public static boolean create(String entityFrom,String startLabel,String relation,String entityTo,String endLabel){
        try {
            StatementResult statementResult = session.run(CypherUtils.createSingle(entityFrom,startLabel));
            List<Record> entityFromlist = statementResult.list();

            StatementResult entityToResult = session.run(CypherUtils.createSingle(entityTo,endLabel));
            List<Record> entityToList = entityToResult.list();

            if(entityFromlist.size() == 0){
                session.run(CypherUtils.createSingle(entityFrom,startLabel));
            }

            if(entityToList.size() == 0){
                session.run(CypherUtils.createSingle(entityTo,endLabel));
            }

            StatementResult result = session.run(CypherUtils.createRelationByTwoNodes(entityFrom,startLabel, relation, entityTo, endLabel));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static Map<String,Object> searchAll(String entityName){
        StatementResult result = session.run(CypherUtils.searchAll(entityName));
        List<Record> list = result.list();

        Map<String,Object> resultMap = new HashMap<>();

        Set<String> nodes = new HashSet<>();
        List<String> relationships = new ArrayList<>();
        for (Record r : list){
            String start_node = r.get("m").get("name").toString().replace("\"","");
            String relationship = r.get("edge").asRelationship().type().replace("\"","");
            String end_node = r.get("n").get("name").toString().replace("\"","");

//            System.out.println(start_node + "-" + relationship + "->" + end_node );
            relationship = start_node + "-" + relationship + "-" + end_node;
            nodes.add(start_node);
            nodes.add(end_node);
            relationships.add(relationship);

        }


        resultMap.put("nodes",nodes);
        resultMap.put("relationships",relationships);

        return resultMap;
    }

}
