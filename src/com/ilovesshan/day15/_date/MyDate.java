package com.ilovesshan.day15._date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/1
 * @description:
 */
public class MyDate {
    public static void main(String[] args) throws InterruptedException {
        // 创建时间对象
        Date date = new Date();
        System.out.println(date); // Fri Jul 01 21:19:56 CST 2022

        // 获取时间戳
        long time = date.getTime();
        System.out.println(time); // 1656681653020

        // 主线程 睡1s
        Thread.sleep(1000);

        Date date1 = new Date();

        // a.compareTo(b)
        // a 大于b 1
        // a 小于b -1
        // a 等于b 0
        int compareTo = date1.compareTo(date1);
        System.out.println(compareTo);

        // a.after(b) a时间发是否在b时间之后
        System.out.println(date.after(date1)); // false
        System.out.println(date1.after(date)); // true

        // 时间格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(dateFormat.format(date)); // 2022-07-01 09:28:09
        System.out.println(dateFormat.format(date1)); // 2022-07-01 09:28:10
    }
}
