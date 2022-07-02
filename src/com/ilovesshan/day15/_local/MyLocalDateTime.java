package com.ilovesshan.day15._local;

import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class MyLocalDateTime {
    public static void main(String[] args) {


        LocalDateTime localDateTime = LocalDateTime.now();
        // localDateTime = 2022-07-02T09:16:58.473
        System.out.println("localDateTime = " + localDateTime);


        // 加 10天
        LocalDateTime localDateTime1 = localDateTime.plusDays(10);
        // 2022-07-12T09:17:52.622
        System.out.println(localDateTime1);

        // 其他用法 和 LocalDate LocalTime 很类似
    }
}
