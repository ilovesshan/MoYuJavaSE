package com.ilovesshan.day25;

import com.ilovesshan.day12.strategy.User;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */

public class TerrMapWithCustomComparator {
    public static void main(String[] args) {

        TreeMap<Student, String> treeMap1 = new TreeMap<>(((o1, o2) -> (int) (o1.getAge() - o2.getAge())));
        TreeMap<Student, String> treeMap2 = new TreeMap<>(((o1, o2) -> (int) (o1.getHeight() - o2.getHeight())));


        treeMap1.put(new Student("zs",30,175.0),"ZS");
        treeMap1.put(new Student("ls",18,155.0),"LS");
        treeMap1.put(new Student("ww",12,185.0),"WW");


        treeMap2.put(new Student("zs",30,175.0),"ZS");
        treeMap2.put(new Student("ls",18,155.0),"LS");
        treeMap2.put(new Student("ww",12,185.0),"WW");
        
        System.out.println(treeMap1);
        System.out.println(treeMap2);
        // {Student{name='ww', age=12.0, height=185.0}=WW, Student{name='ls', age=18.0, height=155.0}=LS, Student{name='zs', age=30.0, height=175.0}=ZS}
        // {Student{name='ls', age=18.0, height=155.0}=LS, Student{name='zs', age=30.0, height=175.0}=ZS, Student{name='ww', age=12.0, height=185.0}=WW}
    }
}


class Student {
    private String name;
    private double age;
    private double height;

    public Student() {
    }

    public Student(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}