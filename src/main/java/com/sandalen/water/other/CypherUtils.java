package com.sandalen.water.other;

import org.springframework.stereotype.Component;


@Component
public class CypherUtils {


    public static String createSingle(String entity,String label){
        return "merge (m:"+label+":Water{name:\""+entity+"\"}) return m";
    }

    public static String createRelationByTwoNodes(String entityFrom,String startLabel,String relation,String entityTo,String endLabel){
        return "match(m:"+startLabel+":Water{name:\""+entityFrom+"\"}),(n:"+endLabel    +"{name:\""+entityTo+"\"}) merge (m)-[r:"+relation+"]->(n) return m,n,r";
    }

    public static String searchAll(String entityName){
        if(entityName == "" || entityName == null){
            return "match (m:Water)-[edge]->(n:Water) return m,edge,n";
        }

        return "match (m:Water)-[edge]-(n:Water) where n.name='" + entityName + "' return m,edge,n";
    }


}
