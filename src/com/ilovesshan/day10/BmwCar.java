package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class BmwCar extends Car {

    BmwCar() {
        // 调用父类构造器
        super("宝马", "白色");
    }

    public void printCarInfo() {
        // 访问父类成员属性
        System.out.println(super.brand); // 宝马
        System.out.println(super.color); // 白色

        // 访问父类成员方法
        super.start(); // 汽车启动...
        super.run(); // 汽车跑起来了...
    }
}
