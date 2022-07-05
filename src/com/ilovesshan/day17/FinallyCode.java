package com.ilovesshan.day17;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */
public class FinallyCode {
    public static void main(String[] args) {
        try {
            extracted();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 总是会执行的");
        }
    }

    private static void extracted() {
        double aDouble = new Random().nextDouble();
        System.out.println("aDouble = " + aDouble);
        if (aDouble > 0.5) {
            throw new UserNameErrorException("用户名错误~~~");
        }
    }
}
