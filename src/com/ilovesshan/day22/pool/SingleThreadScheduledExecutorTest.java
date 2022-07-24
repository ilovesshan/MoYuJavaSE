package com.ilovesshan.day22.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */

public class SingleThreadScheduledExecutorTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
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
