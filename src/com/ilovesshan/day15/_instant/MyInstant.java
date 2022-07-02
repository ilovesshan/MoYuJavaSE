package com.ilovesshan.day15._instant;

import java.time.Duration;
import java.time.Instant;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class MyInstant {
    public static void main(String[] args) {

        Instant now = Instant.now();

        long milli = Instant.now().toEpochMilli();
        // 获取时间戳 1656722851963
        System.out.println("milli = " + milli);

        // now = 2022-07-02T00:40:33.317Z UTC时间 但是和标准的北京时间相差 8h
        System.out.println("now = " + now);

        // 加 8h
        Instant now1 = now.plusSeconds(60 * 60 * 8);
        // now1 = 2022-07-02T08:40:33.317Z  标准时间
        System.out.println("now1 = " + now1);

        // 加 8h
        Instant now2 = now.plus(Duration.ofHours(8));
        // now2 = 2022-07-02T08:40:33.317Z  标准时间
        System.out.println("now2 = " + now2);


        // 减 8h
        Instant now3 = now1.minus(Duration.ofHours(8));
        System.out.println("now3 = " + now3);


    }
}
