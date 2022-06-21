package com.ilovesshan.day08.com.ilovesshan.string_;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class StringMethods {
    public static void main(String[] args) {
        String s = new String("hello world, good good learn java~");

        // 长度 length()
        System.out.println(s.length());

        //  分割成字符串数组 split(分隔符)
        String[] strings = s.split(" ");
        for (String string : strings) {
            System.out.print(string + "\t");
        }
        System.out.println();

        // 小写 toLowerCase()
        System.out.println(s.toLowerCase());

        // 大写 toUpperCase()
        System.out.println(s.toUpperCase());

        // 截取 substring(开始索引, 结束索引)
        System.out.println(s.substring(12));

        // 替换 replace(规则, 替换值)
        System.out.println(s.replace("java", "JAVA"));


    }
}
