package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/21
 * @description:
 */
public class WaitAndNotify {
    public static final Object MONITOR = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (MONITOR) {
                System.out.println(Thread.currentThread().getName() + "持有 MONITOR");
                try {
                    // 一直睡，直到被 notify() 或者 notifyAll()
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "被唤醒...");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "被唤醒后执行了100000行代码");
            }
        }).start();


        new Thread(() -> {
            synchronized (MONITOR) {
                System.out.println(Thread.currentThread().getName() + "持有 MONITOR");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                MONITOR.notify();
                System.out.println(Thread.currentThread().getName() + "随机唤醒争夺MONITOR锁的一个线程");
            }
        }).start();
    }
}
