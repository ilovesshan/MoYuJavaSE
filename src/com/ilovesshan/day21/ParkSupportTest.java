package com.ilovesshan.day21;

import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/22
 * @description:
 */
public class ParkSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "   start...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("被打断睡觉了...");
                e.printStackTrace();
            }
            // 阻塞线程执行
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "   end...");
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "唤醒 thread...");
        LockSupport.unpark(thread);

    }
}
