package com.sandalen.water.util;


import com.sandalen.water.bean.Entity4Neo;
import com.sandalen.water.bean.SingleEntity;
import com.sandalen.water.other.CypherUtils;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.Entity;
import org.neo4j.driver.v1.types.Node;
import org.neo4j.driver.v1.types.Relationship;
import org.neo4j.driver.v1.types.Type;
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

    public static  boolean createEntitiy(String entityName,String entityAmbiguous,String entityLink,String label){
        StatementResult result = session.run(CypherUtils.createSingle(entityName, label, entityAmbiguous, entityLink));
        List<Record> list = result.list();

        if (CheckCollectionUtils.isEmpty(list)){
            return true;
        }
        return false;
    }

    public static boolean create(String entity,String entityAmbiguous,String entityLink,String startLabel,
                                 String relation,String des,String value,String valueAmbiguous,
                                 String valueLink,String endLabel){
//        try {
            List<Record> entityList = searchNode(entity,entityAmbiguous);
            if(entityList != null && entityList.size() > 0){
                session.run(CypherUtils.setAttribute(entity,entityAmbiguous,entityAmbiguous));
            }
            else {
                session.run(CypherUtils.createSingle(entity,startLabel,entityAmbiguous,entityLink));
            }

            List<Record> valueList = searchNode(value,valueAmbiguous);
            if(valueList != null && valueList.size() > 0){
                session.run(CypherUtils.setAttribute(value,valueAmbiguous,valueLink));
            }
            else
           {
                session.run(CypherUtils.createSingle(value,endLabel,valueAmbiguous,valueLink));
            }

            StatementResult result = session.run(CypherUtils.createRelationByTwoNodes(entity,entityAmbiguous,startLabel,relation,des,value,valueAmbiguous,endLabel));
            return true;
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }

    }

    public static Map<String,Object> searchAll(String entityName){
        StatementResult result = session.run(CypherUtils.searchAll(entityName));
        List<Record> list = result.list();

        Map<String,Object> resultMap = new HashMap<>();

        Set<String> nodes = new HashSet<>();
        List<String> relationships = new ArrayList<>();
        List<List<String>> labels = new ArrayList<>();
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

    public static List<Entity4Neo> search(String entityName2,String entity_id){
        StatementResult result = session.run(CypherUtils.search(entityName2,entity_id));
        List<Record> recordList = result.list();

        List<Entity4Neo> entity4NeoList = parseNeoEntityList(recordList);
        return entity4NeoList;
    }

    public static List<Entity4Neo> parseNeoEntityList(List<Record> recordList){
        List<Entity4Neo> entity4NeoList = new ArrayList<>();
        for (Record r : recordList){
//            int entityId = Integer.parseInt(r.get("m").get("id").toString().replace("/",""));

            Iterable<String> labels = r.get("m").asNode().labels();
            ArrayList entityLabels = new ArrayList<String>();
            for (String label : labels){
                entityLabels.add(label);
            }
            long entityId = r.get("m").asEntity().id();
            String entityName = r.get("m").get("name").toString().replace("\\","");
//            System.out.println(entityName);
            String entityLink = r.get("m").get("link").toString().replace("\\\"","");
//            System.out.println(entityLink);
            String entityAmbiguous = r.get("m").get("ambiguous").toString();

            Iterable<String> nlabels = r.get("n").asNode().labels();
            ArrayList valueLabels = new ArrayList<String>();
            for (String label : nlabels){
                valueLabels.add(label);
            }
            long relationId = r.get("r").asEntity().id();
//            String relation = r.get("r").asRelationship().type().replace("/","");
            String relation = r.get("r").asRelationship().get("real_relation").toString().replace("/","");
            String desc = r.get("r").asRelationship().get("des").toString().replace("/","");

            long valueId = r.get("n").asEntity().id();
            String valueName = r.get("n").get("name").toString().replace("/","");
            String valueLink = r.get("n").get("link").toString().replace("/","");
            String valueAmbiguous = r.get("n").get("ambiguous").toString().replace("/","");

            Entity4Neo entity4Neo = new Entity4Neo();
            entity4Neo.setEntityId(entityId);
            entity4Neo.setEntity(entityName);
            entity4Neo.setEntity_label(entityLabels);
            entity4Neo.setEntityLink(entityLink);
            entity4Neo.setEntityAmbiguous(entityAmbiguous);
            entity4Neo.setRelationId(relationId);
            entity4Neo.setRelation(relation);
            entity4Neo.setDesc(desc);
            entity4Neo.setValueId(valueId);
            entity4Neo.setValue(valueName);
            entity4Neo.setEntity_label(entityLabels);
            entity4Neo.setValueLink(valueLink);
            entity4Neo.setValueAmbiguous(valueAmbiguous);

            entity4NeoList.add(entity4Neo);

        }

        return entity4NeoList;
    }

    public static List<SingleEntity> getSingleEntity(String entityName,String ambiguous){
        StatementResult result = session.run(CypherUtils.getEntity(entityName,ambiguous));
        List<Record> recordList = result.list();
        List<SingleEntity> entityList = new ArrayList<>();

        for(Record r : recordList){
            Iterable<String> labels = r.get("m").asNode().labels();
            ArrayList entityLabels = new ArrayList<String>();
            for (String label : labels){
                entityLabels.add(label);
            }
            long entityId = r.get("m").asEntity().id();
            String name = r.get("m").get("name").toString().replace("\\","");
//            System.out.println(entityName);
            String entityLink = r.get("m").get("link").toString().replace("\\\"","");
//            System.out.println(entityLink);
            String entityAmbiguous = r.get("m").get("ambiguous").toString();

            SingleEntity singleEntity = new SingleEntity();
            singleEntity.setEntityId(entityId);
            singleEntity.setEntityName(name);
            singleEntity.setEntity_label(entityLabels);
            singleEntity.setEntityAmbiguous(entityAmbiguous);
            singleEntity.setEntityLink(entityLink);

            entityList.add(singleEntity);
        }

        return entityList;
    }

    public static List<Record> searchByAmbiguous(String entityName,String ambiguous){
        StatementResult result = session.run(CypherUtils.searchByAmbiguous(entityName, ambiguous));
        List<Record> list = result.list();
        return list;
    }

    public static List<Record> searchNode(String entityName,String ambiguous){
        StatementResult result = session.run(CypherUtils.searchNode(entityName, ambiguous));
        return result.list();
    }

    public static List<Entity4Neo> getRelationById(String entityId){
        StatementResult result = session.run(CypherUtils.getRelationById(entityId));
        List<Record> recordList = result.list();
        List<Entity4Neo> entity4NeoList = parseNeoEntityList(recordList);
        return entity4NeoList;
    }

    public static boolean createStation(String name,String sid,int level,int status,String ambiguous,
                                       String upstreamId,String downstreamId){
        try{
            StatementResult result = session.run(CypherUtils.createStationEntity(sid, name, level, status, ambiguous));

            if(!ObjectUtils.isEmpty(upstreamId)){
                session.run(CypherUtils.createRelationshipForStation(upstreamId,sid));
            }

            if(!ObjectUtils.isEmpty(downstreamId)){
                session.run(CypherUtils.createRelationshipForStation(sid,downstreamId));
            }

            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteEntity(String sid){
        try{
            session.run(CypherUtils.deleteEntity(sid));
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> getRelBySid(String sid){
        StatementResult res = session.run(CypherUtils.getRelBySid(sid));
        List<Record> recordList = res.list();
        Set<String> nodes = new HashSet<>();

        Map<Long,String> idAndNode = new HashMap<>();
        for(Record r:recordList){
            Node source = r.get("n").asNode();
            String sourceName = source.get("name").toString().replace("\"","");
            if(!idAndNode.containsKey(source.id())){
                idAndNode.put(source.id(),sourceName);
            }

            Node target = r.get("m").asNode();
            String targetName = target.get("name").toString().replace("\"","");
            if(!idAndNode.containsKey(target.id())){
                idAndNode.put(target.id(),targetName);
            }

            Value value = r.get("r");
            for(int i = 0;i < value.size();i++){
                Relationship relationship = value.get(i).asRelationship();
                String tmp = idAndNode.get(relationship.startNodeId()) + "@" + relationship.type() + "@"
                        + idAndNode.get(relationship.endNodeId());

                nodes.add(tmp);
            }
        }

        List<String> result = new ArrayList<>(nodes);
        return result;

    }

    public static void updateStation(String sid,String name,int level,int status){
        StatementResult result = session.run(CypherUtils.updateStation(sid, name, level, status));
    }

    public static void createRelWithStationAndCharger(String stationId,String chargerId){
        session.run(CypherUtils.createRelWithStationAndCharger(stationId, chargerId));
    }

    public static void deleteRel(String sid1,String sid2){
        session.run(CypherUtils.deleteRel(sid1,sid2));
    }

}
