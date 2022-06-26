package com.ilovesshan.day12.template;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        // 小学生
        PupilStudent pupilStudent = new PupilStudent("小学生");
        // 大学生
        CollegeStudent collegeStudent = new CollegeStudent("大学生");

        // 拜访者
        Visitor visitor = new Visitor();

        // 看看小学生一天生活
        System.out.println("***********************开始体验小学生一天的生活***************************");
        visitor.visit(pupilStudent);
        System.out.println("***********************小学生一天的生活体验结束***************************");

        // 看看大学生一天生活
        System.out.println("***********************开始体验大学生一天的生活***************************");
        visitor.visit(collegeStudent);
        System.out.println("***********************大学生一天的生活体验结束***************************");
    }
}
