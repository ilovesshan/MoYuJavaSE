package com.ilovesshan.day15.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class DateTimeUtils {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:hh";

    public static String nowStr() {
        return nowStr(DEFAULT_PATTERN);
    }

    public static String nowStr(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }


    public static Date now() {
        return now(nowStr(), DEFAULT_PATTERN);
    }

    public static Date now(String dateText) {
        return now(dateText, DEFAULT_PATTERN);
    }

    public static Date now(String dateText, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtils.nowStr()); // 2022-07-02 11:31:11
        System.out.println(DateTimeUtils.nowStr("yyyy年MM月dd HH时mm分hh秒")); // 2022年07月02 11时31分11秒


        System.out.println(DateTimeUtils.now()); // Sat Jul 02 11:32:27 CST 2022
        System.out.println(DateTimeUtils.now("2022-07-02 11:31:11")); // Sat Jul 02 11:31:00 CST 2022
        System.out.println(DateTimeUtils.now("2022年07月02 11时31分11秒", "yyyy年MM月dd HH时mm分hh秒"));// Sat Jul 02 11:31:00 CST 2022

    }
}
