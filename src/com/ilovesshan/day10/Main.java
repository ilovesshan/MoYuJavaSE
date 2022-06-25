package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        FemaleStudent femaleStudent = new FemaleStudent();
        MaleStudent maleStudent = new MaleStudent();

        // 可以看出来，我们创建了学生类子类的实例，是通过子类可以访问到父类的属性和方法的。

        System.out.println("femaleStudent.name = " + femaleStudent.name); //  Student Name
        System.out.println("maleStudent.name = " + maleStudent.name); //  Student Name

        femaleStudent.learn(); // Student learn...
        maleStudent.learn(); // Student learn...

    }
}
