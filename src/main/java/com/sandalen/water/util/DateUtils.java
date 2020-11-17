package com.sandalen.water.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public static String formatDate(Date date){
        if(date != null){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = format.format(date);
            return formatDate;
        }
        return null;
    }

    public static String specialFormatDate(Date date) throws ParseException {
        long time = (date.getTime() - 8 * 60 * 60 * 1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(time);

        return s;
    }

    public static SimpleDateFormat format(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format;
    }
}
