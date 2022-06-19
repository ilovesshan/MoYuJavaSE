package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class FibonacciNumbers {
    public static void main(String[] args) {

        long numbers = fibonacciNumbers(10);
        System.out.println(numbers);
    }


    // 0、1、1、2、3、5、8、13、21、34 第三项开始、后一个数是前两个数之和
    public static long fibonacciNumbers(int number) {
        if (number == 1 || number == 0) {
            return number;
        } else {
            return fibonacciNumbers(number - 1) + fibonacciNumbers(number - 2);
        }
    }
}
