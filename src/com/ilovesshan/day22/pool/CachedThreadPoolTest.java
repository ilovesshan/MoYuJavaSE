package com.ilovesshan.day22.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 */

public class CachedThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
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
