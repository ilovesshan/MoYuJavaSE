package com.ilovesshan.day04;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/15
 * @description:
 */
public class GuessNumber {
    public static void main(String[] args) {
        // 定义一个1 ~ 100 之间的整数。
        int guessNumber = (int) ((Math.random() * 100) + 1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你想的数字: ");
            int n = scanner.nextInt();
            if (n < guessNumber) {
                System.out.println("猜小了..");
            } else if (n > guessNumber) {
                System.out.println("猜大了..");
            } else {
                System.out.println("猜对了,答案是: " + guessNumber);
                break;
            }
        }
    }
}
