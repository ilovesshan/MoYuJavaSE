package com.ilovesshan.day22.pool;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description: 自定义线程池
 */
public class CustomThreadPool {

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(
                5,
                10,
                0,
                TimeUnit.MINUTES,
                // 10 队列只能放10个任务 多余的会被拒绝掉
                new LinkedBlockingQueue<Runnable>(10),
                new MyThreadFactory(),
                new MyRejectedExecutionHandler()
        );

        for (int i = 0; i < 25; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("*************" + finalI + "*******************");
                    Thread.sleep(100);
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

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}


// 自定义拒绝策略
class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("任务太多了,做不完....");
    }
}
