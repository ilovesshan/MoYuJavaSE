package com.ilovesshan.day22.pool;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 自定义线程池
 */
public class CustomThreadPool {

    public static void main(String[] args) {

        // 自定义的线程工厂
        // MyThreadFactory factory = new MyThreadFactory("dev-custom"),

        // google 提供的线程工厂
        // ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("dev-google").build();

        // apache 提供的线程工厂
        BasicThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("dev-apache").build();

        ThreadPool threadPool = new ThreadPool(
                5,
                10,
                0,
                TimeUnit.MINUTES,
                // 10 队列只能放10个任务 多余的会被拒绝掉
                new LinkedBlockingQueue<Runnable>(100),
                factory,
                new MyRejectedExecutionHandler()
        );

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("*************" + finalI + "*******************");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threadPool.submit(thread);
        }

        threadPool.shutdown();
    }

}


class ThreadPool extends ThreadPoolExecutor {
    public ThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }
}


// 自定义线程工厂
class MyThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final String namePrefix;

    // 自己定义线程的名字 方便排查
    MyThreadFactory(String prefix) {
        namePrefix = "pool-" + prefix + poolNumber.getAndIncrement();
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(null, r, namePrefix, 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }

}


// 自定义拒绝策略
class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务太多了,做不完....");
    }
}
