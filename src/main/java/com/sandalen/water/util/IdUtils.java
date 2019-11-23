package com.sandalen.water.util;

import java.util.UUID;

public class IdUtils {
    public static String getId(){
        long l = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid + l;
    }
}
