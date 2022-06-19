package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class CarMethod {
    public static void main(String[] args) {
        Car car = new Car();

        // 调用方法
        car.run();

        // 改变车的颜色
        car.changeColor("梦幻白色");

        boolean isSuccess = car.changeColorIsSuccess("雅库黑");
        if (isSuccess) {
            System.out.println("结账开回家...");
        } else {
            System.out.println("继续改...");
        }
    }
}
