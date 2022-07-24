package com.ilovesshan.day22.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */

public class FixedThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            service.submit(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println("********" + finalI + "*********");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
