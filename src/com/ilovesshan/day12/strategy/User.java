package com.ilovesshan.day12.strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/27
 * @description:
 */
public class User /*implements Comparable */ {
    private String name;
    private int age;
    private double height;

    public User() {
    }

    public User(String name, int age, double height) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

//    @Override
//    public Integer compare(Comparable o) {
//        if (o instanceof User) {
//            User user = (User) o;
//            return this.getAge() - user.getAge();
//        }
//        return null;
//    }
}
