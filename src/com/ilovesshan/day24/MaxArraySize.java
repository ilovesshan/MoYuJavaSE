package com.ilovesshan.day24;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/29
 * @description:
 */
public class MaxArraySize {
    public static void main(String[] args) {
        int oldCapacity = Integer.MAX_VALUE - 8;
        int newCapacity = oldCapacity + 500;

        System.out.println("oldCapacity = " + oldCapacity); // 2147483639
        // 超出int的范围了，直接变成负数
        System.out.println("newCapacity = " + newCapacity);  // -2147483157

        System.out.println(newCapacity - 1000);  // 2147483139

        // 两种写法 得到了两种不同结果
        System.out.println(newCapacity - 1000 > 0); // true
        System.out.println(newCapacity > 1000); //false

    }
}
