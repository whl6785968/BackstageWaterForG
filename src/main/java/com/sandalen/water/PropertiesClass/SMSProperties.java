package com.sandalen.water.PropertiesClass;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:SMS.properties")
@Component
@ConfigurationProperties(prefix = "sms")
public class SMSProperties {
    private String Uid;
    private String Key;

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
