package com.ilovesshan.day04;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/15
 * @description:
 */
public class SwitchCase {
    public static void main(String[] args) {
        // 输入1、2、3、4、5、5、6、7 则打出对应星期几,
        //  哈哈哈 很简单吧..., 用if 不是分分钟搞定!

        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.println("星期1");
                break;
            case 2:
                System.out.println("星期2");
                break;
            case 3:
                System.out.println("星期3");
                break;
            case 4:
                System.out.println("星期4");
                break;
            case 5:
                System.out.println("星期5");
                break;
            case 6:
                System.out.println("星期6");
                break;
            default:
                System.out.println("星期7");
        }
    }
}
