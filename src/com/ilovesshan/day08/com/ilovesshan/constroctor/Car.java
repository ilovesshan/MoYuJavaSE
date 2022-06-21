package com.ilovesshan.day08.com.ilovesshan.constroctor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class Car {
    String type;
    String color;

    // 默认送你一个
    public Car() {
        this("宝马", "红色");
    }


    public Car(String type, String color) {
        // 给成员变量 赋值 this后面会讲到
        this.type = type;
        this.color = color;
    }


    void printColor() {
        // this 访问成员属性
        System.out.println(this.color);
    }

    void printCar() {
        // this 访问成员方法
        this.printColor();
    }


    public static void main(String[] args) {
        // 调用无参构造器
        Car car1 = new Car();
        System.out.println(car1.type); // null
        System.out.println(car1.color); // null

        // 调用有参构造器
        Car car2 = new Car("奔驰", "白色");
        System.out.println(car2.type); // 奔驰
        System.out.println(car2.color); // 白色

        car2.printCar();
    }

}
