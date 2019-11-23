package com.sandalen.water.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static String formatDate(Date date){
        if(date != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = format.format(date);
            return formatDate;
        }
        return null;
    }
}
