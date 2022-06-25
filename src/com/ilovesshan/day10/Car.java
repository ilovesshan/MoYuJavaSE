package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class Car {
    String brand;
    String color;

    public Car() {
    }

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }


    public void start() {
        System.out.println("汽车启动...");
    }

    public void run() {
        System.out.println("汽车跑起来了...");

    }

}
