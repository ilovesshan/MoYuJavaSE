package com.ilovesshan.day21;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/21
 * @description:
 */
public class UseSynchronization {
    public static final Object MONITOR = new Object();

    public synchronized void foo() {
        System.out.println("锁的是 this");
    }

    public synchronized static void bar() {
        System.out.println("锁的是 UseSynchronization");
    }

    public void code() {
        // 锁的是 this
        synchronized (this) {
            System.out.println("锁的是 this");
        }

        // 锁的是 UseSynchronization
        synchronized (UseSynchronization.class) {
            System.out.println("锁的是 UseSynchronization");
        }

        // 锁的是 UseSynchronization成员属性
        synchronized (MONITOR) {
            System.out.println("锁的是 UseSynchronization成员属性");
        }

    }

    public static void main(String[] args) {

    }
}
