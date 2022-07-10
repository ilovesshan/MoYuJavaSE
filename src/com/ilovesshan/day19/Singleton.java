package com.ilovesshan.day19;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */

class SingletonTest {
    public static void main(String[] args) {

        System.out.println(Singleton.getInstance() == Singleton.getInstance());
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }
}

public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {

        return SingletonHolder.INSTANCE.mSingleton;
    }


    enum SingletonHolder {
        INSTANCE;

        private final Singleton mSingleton;

        SingletonHolder() {
            mSingleton = new Singleton();
        }
    }
}
