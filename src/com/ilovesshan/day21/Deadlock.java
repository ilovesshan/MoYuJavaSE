package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/21
 * @description:
 */
public class Deadlock {
    public static final Object MONITOR1 = new Object();
    public static final Object MONITOR2 = new Object();

    public static void lock1() throws InterruptedException {
        synchronized (MONITOR1) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "持有 MONITOR1");
            synchronized (MONITOR2) {
                System.out.println(Thread.currentThread().getName() + "持有 MONITOR2");
            }
        }
    }

    public static void lock2() throws InterruptedException {
        synchronized (MONITOR2) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "持有 MONITOR2");
            synchronized (MONITOR1) {
                System.out.println(Thread.currentThread().getName() + "持有 MONITOR1");
            }
        }
    }


    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Deadlock.lock1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Deadlock.lock2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
