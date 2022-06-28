package com.ilovesshan.day13.staticMenber;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class Main {
    public static void main(String[] args) {

        // 调用静态常量
        System.out.println(Constants.SUCCESS_CODE);
        System.out.println(Constants.SUCCESS_MESSAGE);

        // 调用静态方法
        System.out.println(Utils.plus(10, 20));
        System.out.println(Utils.sub(10, 20));
    }
}
