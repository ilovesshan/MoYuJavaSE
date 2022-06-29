package com.ilovesshan.day13.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */
public class LazySingletonMode {
    private static LazySingletonMode instance = null;

    private LazySingletonMode() {
    }

    public static LazySingletonMode getInstance() {
        if (instance == null) {
            instance = new LazySingletonMode();
        }
        return instance;
    }

}
