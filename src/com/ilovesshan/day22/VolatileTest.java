package com.ilovesshan.day22;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/23
 * @description:
 */
public class VolatileTest {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            // 创建500个线程 每次进行count+1
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // 睡2s 查看结果
        Thread.sleep(3000);

        System.out.println("count= " + count);

    }
}
