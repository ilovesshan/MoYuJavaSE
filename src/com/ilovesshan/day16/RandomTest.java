package com.ilovesshan.day16;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class RandomTest {
    public static void main(String[] args) {
        // 产生一个随机数
        Random random = new Random();

        // 生成随机boolean值
        boolean aBoolean = random.nextBoolean();

        //  生成随机 bytes
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);

        //  生成随机 int
        int anInt = random.nextInt(10);

        //  生成随机 double
        double aDouble = random.nextDouble();


        System.out.println("*************不带参数构造*************");
        for (int i = 0; i < 5; i++) {
            Random r1 = new Random();
            for (int j = 0; j < 5; j++) {
                System.out.print(r1.nextInt(100) + ", ");
            }
            System.out.println();
        }

        System.out.println("*************带参数构造*************");
        for (int i = 0; i < 5; i++) {
            Random r2 = new Random(100);
            for (int j = 0; j < 5; j++) {
                System.out.print(r2.nextInt(100) + ", ");
            }
            System.out.println();
        }
    }
}
