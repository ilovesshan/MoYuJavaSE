package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/17
 * @description: 线程争抢
 */
public class ThreadFor {

    public static int count = 0;

   synchronized static void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ThreadFor.increment();
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ThreadFor.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);

    }
}
