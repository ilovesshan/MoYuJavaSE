package com.ilovesshan.day08.com.ilovesshan.wrapperClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class Work {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2); // true 原理同String


        Integer i3 = new Integer(127);
        Integer i4 = new Integer(127);
        System.out.println(i3 == i4); // false 原理同String


        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5 == i6); // false
        // Integer 内部有一个缓存类IntegerCache 缓存了 -128 - 127的数字
        // 在这个范围之间直接从内存取、不在这个范围之间就需构建

    }
}
