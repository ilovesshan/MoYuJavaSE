package com.ilovesshan.day10;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class Teacher implements Cloneable {
    String name;
    String orderNo;
    Student student;

    public Teacher(String name, String orderNo) {
        this.name = name;
        this.orderNo = orderNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;

        if (o instanceof Teacher) {
            Teacher t = (Teacher) o;
            if (Objects.equals(t.name, this.name) && Objects.equals(t.orderNo, this.orderNo)) return true;
            return false;
        }
        return false;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        Teacher t1 = new Teacher("liLei", "111");
        Teacher t2 = new Teacher("liLei", "112");
        Teacher t3 = new Teacher("liLei", "111");

        System.out.println("t1.equals(t2) = " + t1.equals(t2)); // false
        System.out.println("t1.equals(t3) = " + t1.equals(t3)); // true


    }

}

