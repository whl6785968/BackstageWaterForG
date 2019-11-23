package com.sandalen.water;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;


import java.text.ParseException;
import java.text.SimpleDateFormat;;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;


@SpringBootTest
class WaterApplicationTests {

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
