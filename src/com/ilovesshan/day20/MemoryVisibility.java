package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/17
 * @description: 内存可见性
 */
public class MemoryVisibility {
    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!flag) {
            }
            System.out.println("t1----");
        }).start();


        Thread.sleep(2000);
        flag = true;
    }
}
