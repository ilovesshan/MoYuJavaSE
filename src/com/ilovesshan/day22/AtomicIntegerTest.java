package com.ilovesshan.day22;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/24
 * @description:
 */
public class AtomicIntegerTest {
    static AtomicInteger mAtomicInteger = new AtomicInteger(0);

    public static void add() {
        mAtomicInteger.set(mAtomicInteger.get() + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(AtomicIntegerTest::add).start();
            new Thread(AtomicIntegerTest::add).start();
            new Thread(AtomicIntegerTest::add).start();
        }


        Thread.sleep(3000);

        System.out.println("mAtomicInteger.get() = " + mAtomicInteger.get());
    }
}
