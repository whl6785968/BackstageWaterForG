package com.sandalen.water.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date formatDate(Date date){
        if(date != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            format.format(date);
            return date;
        }
        return null;
    }
}
