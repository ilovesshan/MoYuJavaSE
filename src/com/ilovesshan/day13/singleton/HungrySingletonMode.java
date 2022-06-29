package com.ilovesshan.day13.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */

public class HungrySingletonMode {
    private static final HungrySingletonMode instance = new HungrySingletonMode();

    private HungrySingletonMode() {
    }

    public static HungrySingletonMode getInstance() {
        return instance;
    }

}
