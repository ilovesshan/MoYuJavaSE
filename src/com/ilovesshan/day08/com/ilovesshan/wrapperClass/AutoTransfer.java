package com.ilovesshan.day08.com.ilovesshan.wrapperClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class AutoTransfer {
    public static void main(String[] args) {
        // 左边是基本类型  右边是包装类型 称之为 自动装箱
        int i1 = new Integer(10);
        long l1 = new Long(10L);


        // 左边是包装类型  右边是基本类型 称之为 自动拆箱
        Integer i2 = 10;
        Long l2 = 10L;
    }
}
