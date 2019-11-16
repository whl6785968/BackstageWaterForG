package com.sandalen.water.other;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "sandalen",ignoreInvalidFields = false)
public class MyProperties {
    private final Auth auth = new Auth();

    @Data
    public static class Auth{
        private Integer loginTimesLimit;
        private Integer loginLockedTime;
    }

}
