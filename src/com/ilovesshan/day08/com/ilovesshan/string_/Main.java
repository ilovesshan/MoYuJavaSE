package com.ilovesshan.day08.com.ilovesshan.string_;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        // String 构造器很多 可以去查看源码

        String s1 = new String("abc");
        String s2 = new String(new char[]{'a', 'b', 'c'});
        String s3 = new String(new byte[]{97, 98, 99});
        String s4 = new String(new StringBuilder("abc"));
        String s5 = new String(new StringBuilder("abc"));
        // ...


        System.out.println(s1); // abc
        System.out.println(s2); // abc
        System.out.println(s3); // abc
        System.out.println(s4); // abc
        System.out.println(s5); // abc

    }
}
