package com.ilovesshan.day15._calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/1
 * @description:
 */
public class MyCalendar {
    public static void main(String[] args) {

        // getInstance() 不传参数、默认会根据当前的环境来选择合适的时区格式
        // Calendar calendar = Calendar.getInstance();

        // 也可以指定参数
        // 时区ID: Asia/Macau  澳门
        // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Macau"));

        // America/New_York 美国纽约
        // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));

        // TimeZone表示时区  Asia/Shanghai 上海
        // Locale 表示地区。每一个Locale对象都代表了一个特定的地理、政治和文化地区。
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"), Locale.ENGLISH);
        System.out.println(calendar);

        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"), Locale.CHINA);
        System.out.println(calendar1);

        // calendar.getTime() 返回一个 Date对象
        //  calendar.setTime() 接收以一个 Date对象
        Date date = calendar.getTime();
        calendar.setTime(date);

        /**
         * java.util.GregorianCalendar[
         *      time=1656682396309,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
         *      zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,
         *      transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=6,
         *      WEEK_OF_YEAR=27,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=182,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=1,
         *      AM_PM=1,HOUR=9,HOUR_OF_DAY=21,MINUTE=33,SECOND=16,MILLISECOND=309,ZONE_OFFSET=28800000,DST_OFFSET=0
         * ]
         */
        System.out.println(calendar);


        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月 月份默认从0开始计算 需要+1
        int mouth = calendar.get(Calendar.MONTH) + 1;

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // 获取时 HOUR_OF_DAY 24小时制   HOUR 12小时制
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 获取分
        int minute = calendar.get(Calendar.MINUTE);

        // 获取秒
        int second = calendar.get(Calendar.SECOND);

        // 2022年7月1日 9时40分16秒
        System.out.println(year + "年" + mouth + "月" + day + "日 " + hour + "时" + minute + "分" + second + "秒");

    }
}
