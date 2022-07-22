package com.ilovesshan.day21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/22
 * @description:
 */
public class ReentrantLockTicket {
    public  static  final Lock reentrantLock = new ReentrantLock();

    public static int count = 100;

    public synchronized static void sale() {
        // 加锁
        reentrantLock.lock();
        try {
            while (count > 0) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "窗口卖票一张, 剩余: " + --count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 无论如何 都要保证释放锁
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(ReentrantLockTicket::sale, "窗口1").start();
        new Thread(ReentrantLockTicket::sale, "窗口1").start();
        new Thread(ReentrantLockTicket::sale, "窗口1").start();
    }
}
