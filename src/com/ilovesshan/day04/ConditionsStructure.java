package com.ilovesshan.day04;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/15
 * @description:
 */
public class ConditionsStructure {
    public static void main(String[] args) {
        // 单分支
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        // if (score >= 60) {
        //     System.out.println("及格了,牛批...");
        // }
        // System.out.println("没及格,继续努力吧...");

        // 多分支
        if (score >= 60) {
            System.out.println("及格了,牛批...");
        } else {
            System.out.println("没及格,继续努力吧...");
        }


        // 嵌套分支

        // 动物园买门票 儿童免票、学生打五折、老人打三折。
        // 旺季门票价格: 票价80
        // 淡季门票价格: 票价50
        // 编写程序 根据输入季节和年龄 来计算票价


        System.out.print("请输入季节:(旺季/1 淡季/2)");
        int reason = scanner.nextInt();
        if (reason == 1) {
            // 旺季
            double price = 80;
            System.out.print("请输入年龄:");
            int age = scanner.nextInt();
            if (age >= 0 && age <= 6) {
                price = 0;
            } else if (age >= 6 && age <= 22) {
                price = price * 0.5;
            } else if (age >= 60 && age <= 150) {
                price = price * 0.3;
            }
            System.out.println("您的年龄是: " + age + ", 对应票价是: " + price);

        } else if (reason == 2) {
            // 淡季
            double price = 50;
            System.out.print("请输入年龄:");
            int age = scanner.nextInt();
            if (age >= 0 && age <= 6) {
                price = 0;
            } else if (age >= 6 && age <= 22) {
                price = price * 0.5;
            } else if (age >= 60 && age <= 150) {
                price = price * 0.3;
            }
            System.out.println("您的年龄是: " + age + ", 对应票价是: " + price);
        } else {
            System.out.println("错误季节...");
        }

    }
}
