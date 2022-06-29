package com.ilovesshan.day13.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */
public class InnerClassSingletonMode {


    private InnerClassSingletonMode() {
    }

    public static InnerClassSingletonMode getInstance() {
        return InnerClassSingletonModeHolder.instance;
    }

    private static class InnerClassSingletonModeHolder {
        private static final InnerClassSingletonMode instance = new InnerClassSingletonMode();
    }
}
