package com.ilovesshan.day15._local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class MyDateTimeFormatter {
    public static void main(String[] args) {
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH时mm分ss秒");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        // 格式化 format
        String s1 = localDate.format(formatter1);
        String s2 = localTime.format(formatter2);
        String s3 = localDateTime.format(formatter3);

        System.out.println("s1 = " + s1); // 2022年07月02日
        System.out.println("s2 = " + s2); // 09时24分51秒
        System.out.println("s3 = " + s3); // 2022年07月02日 09时24分51秒

        // 解析 parse 需要按照规则解析
        System.out.println(LocalDate.parse("2022年07月02日", formatter1)); // 2022-07-02
        System.out.println(LocalTime.parse("09时24分51秒", formatter2)); // 09:24:51
        System.out.println(LocalDateTime.parse("2022年07月02日 09时24分51秒", formatter3)); //2022-07-02T09:24:51
    }
}
