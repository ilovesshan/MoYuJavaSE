package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/14
 * @description:
 */
public class InvokeInstanceRun {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=>" + i);
            if (i == 0) {
                // 开启子线程
                MyThread thread = new MyThread();
                thread.run();
            }
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=>" + i);
        }
    }
}
