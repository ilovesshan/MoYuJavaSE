package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class FactorialNumber {
    public static void main(String[] args) {
        // 数的阶乘 1*2*3*4*5*n
        long number = factorialNumber(10);
        System.out.println(number);
    }

    public static long factorialNumber(int number) {
        if (number > 1) {
            return number * factorialNumber(number - 1);
        } else return 1;
    }
}
