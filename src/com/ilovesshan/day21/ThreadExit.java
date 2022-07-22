package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/22
 * @description:
 */
public class ThreadExit {
    public static volatile boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            while (flag) {
            }
            System.out.println(Thread.currentThread().getName() + "   todo...");
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;

    }
}
