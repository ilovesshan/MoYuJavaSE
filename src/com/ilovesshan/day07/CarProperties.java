package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class CarProperties {
    public static void main(String[] args) {
        // 存放我买的车
        Car[] cars = new Car[10];

        // 买的第1辆车
        Car car1 = new Car();
        car1.type = "宝马";
        car1.color = "红色";
        car1.maxSpeed = 360;
        cars[0] = car1;


        // 买的第2辆车
        Car car2 = new Car();
        car2.type = "奥迪";
        car2.color = "白色";
        car2.maxSpeed = 280;
        cars[1] = car2;


        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                System.out.println(cars[i].type + " " + cars[i].color + " " + cars[i].maxSpeed);
            }
        }
    }
}
