package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class Student {
    String name = "Student Name";
    String orderNo = "Student orderNo";

    Student(){
        System.out.println("Student 默认无参构造器被调用...");
    }

    public void learn() {
        System.out.println("Student learn...");
    }
}
