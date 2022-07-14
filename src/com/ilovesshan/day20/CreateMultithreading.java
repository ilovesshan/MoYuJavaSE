package com.ilovesshan.day20;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/14
 * @description:
 */
public class CreateMultithreading {
    public static void main(String[] args) {

        System.out.println(1);
        // 创建一个线程实例、并调用 start()方法 ，注意是 start方法 不是 run方法
        new MyThread1().start();
        System.out.println(2);

        // 注意我们创建了 一个实现Runnable接口的类的实例, 但是这个实例身上没有  start方法，那怎么开启子线程呢？
        // 通过创建一个 Thread类实例, 来帮助我们创建子线程。
        // Runnable接口的类的实例作为构造参数传进去，接着调用这个实例start方法就ok了
        System.out.println(1);
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        System.out.println(2);


        // 通过匿名内部类和箭头函数来创建子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过匿名内部类和箭头函数来创建子线程");
            }
        }).start();

    }
}


class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类, 开启的子线程...");
    }
}


class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口, 开启的子线程...");
    }
}

