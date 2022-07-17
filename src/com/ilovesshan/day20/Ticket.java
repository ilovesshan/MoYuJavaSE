package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/17
 * @description:
 */
public class Ticket implements Runnable {
    private static int count = 50;

    @Override
    public void run() {
        while (count > 0) {
            // 这里加锁是关键代码 具体写法后面会详细介绍到
            synchronized (Ticket.class) {
                // Thread.currentThread().getName() 可以获取当前线程的名称   Thread-0 / Thread-1
                String name = Thread.currentThread().getName();

                System.out.println(name + "窗口卖出一张票, 剩余：" + --count + "张票~");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Ticket());
        Thread t2 = new Thread(new Ticket());

        t1.start();
        t2.start();
    }

}
