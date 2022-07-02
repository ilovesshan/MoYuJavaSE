package com.ilovesshan.day15._local;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class MyLocalDate {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        // localDate = 2022-07-02
        System.out.println("localDate = " + localDate);

        // 当前时间基础上 加10年
        LocalDate localDate1 = localDate.plus(Period.ofYears(10));
        // 当前时间基础上 减10年
        LocalDate localDate2 = localDate.minus(Period.ofYears(10));

        //localDate1 = 2032-07-02
        System.out.println("localDate1 = " + localDate1);
        // localDate2 = 2012-07-02
        System.out.println("localDate2 = " + localDate2);

        // LocalDate.of() 返回一个LocalDate 对象
        LocalDate date = LocalDate.of(2022, 7, 2);
        // date = 2022-07-02
        System.out.println("date = " + date);

        // 获取 年月日
        System.out.println(date.getYear());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfMonth());


    }
}
