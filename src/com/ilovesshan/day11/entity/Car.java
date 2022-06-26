package com.ilovesshan.day11.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */

public class Car {
    String name = "Car";

    /**
     * 查看汽车的驾驶挡类型
     */

    public void showType() {
    }

    public static void main(String[] args) {

        // 男孩想买车并且看一下各自的配置信息 下面有两辆车
        Car benZCar = new BenZCar();
        Car audiCar = new AudiCar();

        BenZCar benZCar1 = new BenZCar();
        AudiCar audiCar1 = new AudiCar();

        Boy boy = new Boy();
        // 可以买 奔驰车 也可以买奥迪车
        boy.buyCar(benZCar); // BenZCar 是自动挡...
        boy.buyCar(audiCar); // BenZCar 是手动挡...

        System.out.println(benZCar.name); // Car
        System.out.println(audiCar.name); // Car

        System.out.println(benZCar1.name); // BenZCar
        System.out.println(audiCar1.name); // AudiCar
    }

}

class BenZCar extends Car {
    String name = "BenZCar";

    @Override
    public void showType() {
        System.out.println("BenZCar 是自动挡...");
    }
}


class AudiCar extends Car {
    String name = "AudiCar";

    @Override
    public void showType() {
        System.out.println("BenZCar 是手动挡...");
    }
}