package com.ilovesshan.day12.template;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public abstract class Student {
    String studentType = "";

    /**
     * 起床
     */
    abstract void getUp();

    /**
     * 吃饭
     */
    abstract void eat();

    /**
     * 学习
     */
    abstract void study();

    /**
     * 休息
     */
    abstract void play();

    /**
     * 睡觉
     */
    abstract void sleep();


    /**
     * 学生的一天生活
     */
    public void life() {
        getUp();

        eat();

        study();

        play();

        sleep();
    }

}
