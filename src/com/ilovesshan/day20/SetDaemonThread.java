package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/17
 * @description:
 */
public class SetDaemonThread {
    public static void main(String[] args) {

        System.out.println("mian----");

        Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2---" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束----");
            });
            // 将 t2 线程设置成 t1的守护线程, 即t1结束 那么t2 就结束
            t2.setDaemon(true);

            t2.start();

            for (int i = 0; i < 5; i++) {
                System.out.println("t1---" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1结束----");


        });


        // 将 t1 线程设置成 main的守护线程, 即main结束 那么t1 就结束
        // t1.setDaemon(true);

        t1.start();


    }
}
