package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/22
 * @description:
 */
public class InterruptThread {
    public static final Object MONITOR = new Object();

    public static void main(String[] args) {


        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "   start...");
            try {
                Thread.sleep(6000000);
            } catch (InterruptedException e) {
                System.out.println("被打断睡觉了...");
                e.printStackTrace();

            }
            System.out.println(Thread.currentThread().getName() + "   end...");
        };

        Thread thread = new Thread(runnable);
        // thread.start();


        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "   start...");
            synchronized (MONITOR) {
                try {
                    MONITOR.wait(6000000);
                } catch (InterruptedException e) {
                    System.out.println("被打断睡觉了...");
                    e.printStackTrace();

                }
                System.out.println(Thread.currentThread().getName() + "   end...");
            }
        });
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // thread.interrupt();

        thread1.interrupt();

    }

}
