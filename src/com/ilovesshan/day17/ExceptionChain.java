package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */
public class ExceptionChain {

    public static void f3() {
        throw new UserNameErrorException("用户名错啦！！！");
    }

    public static void f2() {
        f3();
    }


    public static void f1() {
        f2();
    }


    public static void main(String[] args) {
        try {
            f1();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
