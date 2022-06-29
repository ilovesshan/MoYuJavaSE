package com.ilovesshan.day13.singleton;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        // 饿汉式
        HungrySingletonMode hungrySingletonMode1 = HungrySingletonMode.getInstance();
        HungrySingletonMode hungrySingletonMode2 = HungrySingletonMode.getInstance();
        System.out.println(hungrySingletonMode1 == hungrySingletonMode1);
        System.out.println("***********************************************");

        // 懒汉式
        LazySingletonMode lazySingletonMode1 = LazySingletonMode.getInstance();
        LazySingletonMode lazySingletonMode2 = LazySingletonMode.getInstance();
        System.out.println(lazySingletonMode1 == lazySingletonMode2);
        System.out.println("***********************************************");

        // 基于内部类的单例模式(饿汉式)
        InnerClassSingletonMode innerClassSingletonMode1 = InnerClassSingletonMode.getInstance();
        InnerClassSingletonMode innerClassSingletonMode2 = InnerClassSingletonMode.getInstance();
        System.out.println(innerClassSingletonMode1 == innerClassSingletonMode2);
        System.out.println("***********************************************");

    }
}
