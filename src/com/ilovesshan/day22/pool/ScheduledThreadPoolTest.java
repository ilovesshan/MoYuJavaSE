package com.ilovesshan.day22.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 创建一个可定期或者延时执行任务的定长线程池，支持定时及周期性任务执行。
 */

public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
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

        // service.shutdown();
    }
}
