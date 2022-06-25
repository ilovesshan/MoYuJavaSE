package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class CarTest {
    public static void main(String[] args) {
        BmwCar bmwCar = new BmwCar();
        bmwCar.printCarInfo();
        System.out.println("bmwCar.brand = " + bmwCar.brand);
        System.out.println("bmwCar.color = " + bmwCar.color);
    }
}
