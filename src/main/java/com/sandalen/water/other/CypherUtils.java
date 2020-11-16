package com.sandalen.water.other;

import com.sandalen.water.util.CheckCollectionUtils;
import org.springframework.stereotype.Component;


@Component
public class CypherUtils {


    public static String createSingle(String entity,String label,String ambiguous,String link){
        return "merge (m:"+label+":Water{name:\""+entity+"\",ambiguous:\""+ ambiguous +"\",link:\""+link+"\",create_time:timestamp()}) return m";
    }

    public static String createRelationByTwoNodes(String entityFrom,String entityAmbiguous,String startLabel,
                                                  String relation,String des,
                                                  String entityTo,String valueAmbiguous,String endLabel){
        return "match(m:"+startLabel+":Water{name:\""+entityFrom+"\",ambiguous:'"+ entityAmbiguous +"'})," +
                "(n:"+endLabel+"{name:\""+entityTo+"\",ambiguous:'"+valueAmbiguous+"',}) " +
                "merge (m)-[r:关系{des:'"+ des +"',real_relation:'"+relation+"',create_time:timestamp()}]->(n) " +
                "return m,n,r";
    }

    public static String searchAll(String entityName){
        if(entityName == "" || entityName == null){
            return "match (m:Water)-[edge]->(n:Water) return m,edge,n";
        }

        return "match (m:Water)-[edge]->(n:Water) where n.name='" + entityName + "'or m.name='" + entityName +"' return m,edge,n";
    }

    public static String search(String entityName,String entityId){
        String pageCondition = " skip 0 limit 50";
        if((entityName == "" || entityName == null)  && (entityId == "" || entityId == null)){
            return "match (m:Water)-[r]->(n:Water) return m,r,n"+pageCondition;
        }
        else if((entityId != "" && entityId != null)   && (entityName != "" && entityName != null)){
            return "match (m:Water)-[r]->(n:Water) where m.name =~'.*"+ entityName +".*' and id(m)="+entityId+" or n.name =~ '.*" + entityName +".*' and id(n)="+entityId+" return m,r,n"+pageCondition;
        }
        else if(CheckCollectionUtils.andEmpty(entityName) && CheckCollectionUtils.orEmpty(entityId)){
            return "match (m:Water)-[r]->(n:Water) where m.name =~'.*"+ entityName +".*' or n.name =~ '.*" + entityName +".*' return m,r,n"+pageCondition;
        }
        else {
            return "match (m:Water)-[r]->(n:Water) where id(m)="+entityId+" or id(n)="+entityId+" return m,r,n"+pageCondition;
        }

    }

    public static String searchByAmbiguous(String entityName,String entityAmbiguous){
        return "match (m:Water)-[r]->(n:Water) where m.name ='"+ entityName +"' or n.name ='" + entityName +"' and " +
                "m.ambiguous ='"+entityAmbiguous+"' return m,r,n";
    }

    public static String setAttribute(String entityName,String entityAmbiguous,String entityLink){
        return "match (m:Water{name:\""+entityName+"\",ambiguous:'"+ entityAmbiguous +"'}) set m.ambiguous=\""+entityAmbiguous + "\",m.link=\""+entityLink+"\" return m";
    }

    public static String searchNode(String entityName,String entityAmbiguous){
        return "match (m:Water{name:'"+ entityName+"',ambiguous:'"+entityAmbiguous+"'}) return m";
    }

    public static String getEntity(String entityName,String ambiguous){
        String cql_header = "match (m:Water) ";
        String cql_tail = "return m";
        if((entityName != "" && entityName != null) && (ambiguous != "" && ambiguous != null)){
            return cql_header+"where m.name =~'.*"+entityName+".*' and m.ambiguous =~ '.*"+ambiguous+".*'"+cql_tail;
        }
        else if((entityName != "" && entityName != null) && (ambiguous == "" || ambiguous == null)){
            return cql_header+"where m.name =~'.*"+entityName+".*'" + cql_tail;
        }
        else if((ambiguous != "" && ambiguous != null) && (entityName == "" || entityName == null)){
            return cql_header+"where m.ambiguous =~'.*"+ambiguous+".*'" + cql_tail;
        }
        else {
            return cql_header + cql_tail;
        }
    }

    public static String getRelationById(String entityId){
        return "match (m:Water)-[r]->(n:Water) where id(m)="+entityId+" or id(n)="+entityId+" return m,r,n";
    }

    public static String createStationEntity(String sid,String name,int level,int status,String ambiguous){
        return "merge (m:Station:Water{sid:'"+sid+"',name:'"+name+"',level:'"+level+"',status:'"+status+
                "',ambiguous:'"+ambiguous+"',create_time:date(),update_time:date()}) return m";
    }

    public static String createRelationshipForStation(String from,String to){
        return "match (n{sid:'"+from+"'}),(m{sid:'"+to+"'}) merge (n)-[r:流入]->(m) return n,r,m";
    }

    public static String deleteEntity(String sid){
        return "match (n{sid:'"+sid+"'}) detach delete n";
    }

    public static String getRelBySid(String sid){
        return "match (n:Station:Water{sid:'"+sid+"'})-[r:流入*..2]-(m:Station:Water) return n,r,m";
    }

    public static String updateStation(String sid,String name,int level,int status){
        return "match (n{sid:'"+sid+"'}) set n.level = "+level+",n.name='"+name+"',n.status="+status+",n.update_time=date() return n";
    }

    public static String createRelWithStationAndCharger(String stationId,String chargerId){
        return "match (n:Station:Water{sid:'"+stationId+"'}),(m:Charger:Water{sid:'"+chargerId+"'}) merge (m)-[r:负责]->(n) return m,r,n";
    }

    public static String deleteRel(String sid1,String sid2){
        return "match (n:Water{sid:'"+sid1+"'})-[r]->(m:Water{sid:'"+sid2+"'}) delete r";
    }

    public static String createRelBetweenStationAndProvince(String stationId,String provinceId){
        return "match (n:Station:Water{sid:'"+ stationId +"'}),(m:Province:Water{sid:'"+ provinceId +"'}) " +
                "merge (n)-[r:属于{create_time:date(),update_time:date()}]->(m) return n,r,m";
    }

    public static String createRelBetweenStationAndBasin(String stationId,String basinId){
        return "match (n:Station:Water{sid:'"+ stationId +"'}),(m:Basin:Water{sid:'"+ basinId +"'}) " +
                "merge (n)-[r:属于{create_time:date(),update_time:date()}]->(m) return n,r,m";
    }

    public static String createEnterprise(int eid,String name,String contacts,String contacts_num,String main_pollution
    ,double pollution_num,int is_exceed,String exceed_factor){
        return "merge (n:Enterprise:Water{name:'"+name+"',sid:'"+eid+"',contacts:'"+contacts+"'," +
                "contacts_num:'"+contacts_num+"',main_pollution:'"+main_pollution+"',pollution_num:'"+pollution_num+"'," +
                "is_exceed:'"+is_exceed+"',exceed_factor:'"+exceed_factor+"',create_time:date(),update_time:date()}) return n";
    }

    public static String createRelBetweenEnterPriseAndStation(int eid,String sid){
        return "match (n:Enterprise:Water{sid:'"+ eid +"'}),(m:Station:Water{sid:'"+ sid +"'}) " +
                "merge (n)-[r:临近{create_time:date(),update_time:date()}]->(m) return n,r,m";
    }

    public static String updateEnterprise(int eid,String name,String contacts,String contacts_num,String main_pollution,
                                          double pollution_num,int is_exceed,String exceed_factor){
        return "match (n:Enterprise:Water{sid:'"+eid+"'}) set n.name='"+name+"',n.contacts='"+contacts+"'," +
                "n.contacts_num='"+contacts_num+"',n.main_pollution='"+main_pollution+"',n.pollution_num='"+pollution_num+"'," +
                "n.is_exceed='"+is_exceed+"',n.exceed_factor='"+exceed_factor+"',n.update_time=date() return  n";
    }

    public static String warningStation(String sid,String factors){
        return "match (n:Station:Water{sid:'"+ sid +"'}) set n.status = 1,n.excessed = '"+ factors +"'," +
                "n.update_time = date() return n";
    }

    public static String searchErrOrigin(String sid){
        return "match (n{sid:'"+ sid +"'})-[r*..2]-(m) where (m.is_exceed = '1' or m.status = 1) and (n.excessed = m.exceed_factor or n.excessed = m.excessed) return n,r,m";
    }

    public static String searchBasin(String sid){
        return "match (n{sid:'"+ sid +"'})-[r:`流入`]-(m)  where m.status = 1 and n.excessed = m.excessed return n,r,m";
    }

    public static String searchEnterprise(String sid){
        return "match (n{sid:'"+ sid +"'})-[r:`临近`*..2]-(m) where m.is_exceed = '1' and n.excessed = m.exceed_factor return m";
    }

    public static String searchDemo(String sid){
        return "match (m{sid:'"+ sid +"'})-[r:`流入`*..2]-(n) return n,m,r";
    }

    public static String getFactorOrigin(String factor){
        return "match (n{name:'"+ factor +"'})-[r{real_relation:'异常原因'}]->(m) return m.name";
    }

    public static String getFactorSolution(String factor){
        return "match (n{name:'"+ factor +"'})-[r{real_relation:'解决方法'}]->(m) return m.name";
    }

}
