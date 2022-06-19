package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class Recursive {
    public static void main(String[] args) {
        // 方法递归调用
        todo();
    }

    public static void todo() {
        // 不断的调用自己，没有设置一个结束时机 最终会导致栈溢出 StackOverflowError
        todo();
        System.out.println("todo...");
    }

}
