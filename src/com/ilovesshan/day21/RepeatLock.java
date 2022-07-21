package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/21
 * @description:
 */
public class RepeatLock {
    public static final Object MONITOR = new Object();

    public static void foo() {
        synchronized (MONITOR) {
            System.out.println(Thread.currentThread().getName() + "第1层");
            synchronized (MONITOR) {
                System.out.println(Thread.currentThread().getName() + "第2层");
                synchronized (MONITOR) {
                    System.out.println(Thread.currentThread().getName() + "第3层");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            RepeatLock.foo();
        }).start();
    }
}
