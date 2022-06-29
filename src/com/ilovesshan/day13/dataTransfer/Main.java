package com.ilovesshan.day13.dataTransfer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}


public class Main {

    public static void changeCat1(Cat cat) {
        // 本质是修改了 传递进来的 cat的值(内存地址), 所以外界会受影响
        cat.setName("加菲猫");
    }

    public static void changeCat2(Cat cat) {
        // 注意，这里是 new Cat(), 会在堆中重新开辟空间， 并且 cat 会指向这个空间， 和外界不产生影响
        cat = new Cat("加菲猫");
    }

    public static void changeI(int i) {
        // 随便改 不影响外面
        i = 100;
    }

    public static void changeStr(String str) {
        // 原理和 changeCat2 一样
        str = "你好";
    }

    public static void main(String[] args) {
        Cat tomCat1 = new Cat("汤姆猫");
        Cat tomCat2 = new Cat("汤姆猫");

        Main.changeCat1(tomCat1); // 本质是拷贝了一份tomCat1的值(地址)
        System.out.println(tomCat1); // Cat{name='加菲猫'}


        Main.changeCat2(tomCat2); // 本质是拷贝了一份tomCat2的值(地址)
        System.out.println(tomCat2); // Cat{name='汤姆猫'}


        int i = 20;
        String str = "hello";

        Main.changeI(i); // 传递的i 本质是拷贝了一份 i的值
        Main.changeStr(str); //  传递的str 本质是拷贝了一份str的值(地址)

        System.out.println(i); // 20
        System.out.println(str); // hello

    }
}
