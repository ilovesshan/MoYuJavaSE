package com.ilovesshan.day16;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class SystemTest {
    public static void main(String[] args) {
        // 打印/输出 数据
        System.out.println();

        // 当前时间的毫秒数
        System.currentTimeMillis();

        // 打系统属性
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.class.version"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.home"));

        // 打印系统环境的一些信息
        Map<String, String> map = System.getenv();
        System.out.println(map.toString());
    }
}
