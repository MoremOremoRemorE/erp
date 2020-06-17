package com.erp.util;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换工具类
 */
public class DateUtil {

    /**
     * 将Date转换成String

     */
    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 将str转换成Date
     * @param str
     * @return
     */
    public static Date stringParse(String str) {
        if (str != null && !str.equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date;
        }else{
            return null;
        }
    }


}
