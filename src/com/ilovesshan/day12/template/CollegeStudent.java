package com.ilovesshan.day12.template;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public class CollegeStudent extends Student {

    CollegeStudent(String studentType) {
        this.studentType = studentType;
    }

    @Override
    void getUp() {
        System.out.println(this.studentType + "起床了...");
    }

    @Override
    void eat() {
        System.out.println(this.studentType + "干饭了...");
    }

    @Override
    void study() {
        System.out.println(this.studentType + "在学习...");
    }

    @Override
    void play() {
        System.out.println(this.studentType + "下课休息了...");
    }

    @Override
    void sleep() {
        System.out.println(this.studentType + "睡觉了...");
    }
}
