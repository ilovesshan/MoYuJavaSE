package com.ilovesshan.day13.innerClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */

interface ICalculate {
    int plus(int i1, int i2);
}


abstract class Plus {
    public Plus() {
    }

    public Plus(String tag) {
        System.out.println(tag);
    }

    abstract int plus(int i1, int i2);
}


class Utils {
    String name = "default class anem";

    Utils() {

    }

    Utils(String name) {
        this.name = name;
    }

    public void printClassName() {
        System.out.println(this.name);
    }
}

public class AnonymousClass {
    public static void main(String[] args) {

        // 接口 匿名内部类
        ICalculate iCalculate = new ICalculate() {
            @Override
            public int plus(int i1, int i2) {
                return i1 + i2;
            }
        };

        int res1 = iCalculate.plus(20, 30);
        System.out.println(res1);


        // 抽象类 匿名内部类  调用父类默认构造器
        // 抽象类 匿名内部类  调用父类带参数构造器
        Plus p1 = new Plus() {
            @Override
            int plus(int i1, int i2) {
                return i1 + i2;
            }
        };


        // 抽象类 匿名内部类  调用父类带参数构造器
        Plus p2 = new Plus("TAG") {
            @Override
            int plus(int i1, int i2) {
                return i1 + i2;
            }
        };

        int res2 = p2.plus(20, 30);
        System.out.println(res2);


        // 普通类  带参数构造器
        Utils util1 = new Utils() {
        };
        util1.printClassName();

        // 普通类
        Utils utils2 = new Utils("common class name") {
        };
        utils2.printClassName();

    }
}
