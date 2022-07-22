package com.ilovesshan.day21;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/22
 * @description:
 */
public class ReentrantReadWriteLockTest {

    public static ReentrantReadWriteLock sReadWriteLock = new ReentrantReadWriteLock();
    public static int count = 1;


    public static void read() {
        // 获取 读取锁
        ReentrantReadWriteLock.ReadLock readLock = sReadWriteLock.readLock();
        readLock.lock();
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "读取数据...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public static void write() {
        // 获取 写入锁
        ReentrantReadWriteLock.WriteLock writeLock = sReadWriteLock.writeLock();
        writeLock.lock();
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "写入数据...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int num = (int) (Math.random() * 100);
            if (num > 20) {
                // 读
                new Thread(() -> ReentrantReadWriteLockTest.read()).start();
            } else {
                // 写
                new Thread(() -> ReentrantReadWriteLockTest.write()).start();
            }
        }
    }
}
