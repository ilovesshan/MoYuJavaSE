package com.ilovesshan.day11.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public class Boy {

    public void buyCar(Car car) {
        this.showCarInfo(car);
    }

    public void showCarInfo(Car car) {
        car.showType();
    }
}
