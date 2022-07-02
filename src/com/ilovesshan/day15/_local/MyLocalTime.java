package com.ilovesshan.day15._local;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class MyLocalTime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        // now = 09:09:46.339
        System.out.println("now = " + now);

        // 加 2h
        LocalTime plus = now.plus(2,ChronoUnit.HOURS);
        // 11:13:06.278
        System.out.println(plus);

        // 减 2h
        LocalTime minus = now.minus(2,ChronoUnit.HOURS);
        // 7:13:06.278
        System.out.println(minus);


        LocalTime time = LocalTime.of(12, 12, 12);
        // time = 12:12:12
        System.out.println("time = " + time);


        // 获取 时分秒
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());

    }
}
