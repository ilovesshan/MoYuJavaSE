package com.ilovesshan.day22.threadSync;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description:
 */
public class ThreadSync {
    static void todo() {
        System.out.println(Thread.currentThread().getName() + " 开始执行...");
        try {
            Thread.sleep((new Random().nextInt(5000)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 执行结束...");
    }
}

class JoinText {
    public static void main(String[] args) throws InterruptedException {
        // task 1
        Thread t1 = new Thread(ThreadSync::todo, "A线程");
        t1.start();
        t1.join();


        // task 2
        Thread t2 = new Thread(ThreadSync::todo, "B线程");
        t2.start();
        t2.join();


        // task 3
        Thread t3 = new Thread(ThreadSync::todo, "C线程");
        t3.start();
        t3.join();

        System.out.println("主线程开始工作了...");
    }
}

class CountDownTest {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch downLatch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        // task 1
        Runnable t1 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行结束...");
            downLatch.countDown();
        };


        // task 2
        Runnable t2 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行结束...");
            downLatch.countDown();
        };


        // task 3
        Runnable t3 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 执行结束...");
            downLatch.countDown();
        };

        service.submit(t1);
        service.submit(t2);
        service.submit(t3);

        downLatch.await();
        System.out.println("主线程开始工作了...");

        service.shutdown();
    }
}


class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("主线程开始工作了...");
        });


        // task 1
        Runnable t1 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
                System.out.println(Thread.currentThread().getName() + " 执行结束...");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };


        // task 2
        Runnable t2 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
                System.out.println(Thread.currentThread().getName() + " 执行结束...");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };


        // task 3
        Runnable t3 = () -> {
            try {
                Thread.sleep((new Random().nextInt(5000)));
                System.out.println(Thread.currentThread().getName() + " 执行结束...");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        service.submit(t1);
        service.submit(t2);
        service.submit(t3);

    }
}

class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        // 声明2个信号量(2个令牌)
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 尝试获取令牌
                    semaphore.acquire();
                    // 模拟进入厕所 有令牌就能进入 没有就排队等候
                    System.out.println(Thread.currentThread().getName() + "进入厕所...");
                    Thread.sleep((new Random().nextInt(5000)));
                    System.out.println(Thread.currentThread().getName() + "离开厕所...");
                    // 回收令牌
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}