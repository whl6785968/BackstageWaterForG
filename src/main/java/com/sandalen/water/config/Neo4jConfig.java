package com.sandalen.water.config;

import com.sandalen.water.PropertiesClass.Neo4jProperties;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Neo4jConfig {
    @Autowired
    private Neo4jProperties neo4jProperties;

    @Bean(name="NeoSession")
    public Session initDriver(){
        Session session = null;
        try
        {
            Driver driver = GraphDatabase.driver(neo4jProperties.getURI(), AuthTokens.basic(neo4jProperties.getUsername(), neo4jProperties.getPassword()));
            session = driver.session();
            return session;
        }
        catch (Exception e){
            e.printStackTrace();
            return session;
        }

    }
}
