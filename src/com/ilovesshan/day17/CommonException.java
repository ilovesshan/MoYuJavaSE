package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/5
 * @description:
 */
public class CommonException {
    public static void foo() {
        // 无限自己调用自己 必定造成内存溢出
        foo();
    }

    public static void main(String[] args) {
        CommonException.foo();
    }
}
