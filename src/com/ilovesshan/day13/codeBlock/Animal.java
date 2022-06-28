package com.ilovesshan.day13.codeBlock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class Animal {
    static {
        System.out.println("Animal静态代码块执行...");
    }

    {
        System.out.println("Animal实例代码块执行...");
    }

    public Animal() {
        System.out.println("Animal构造器代码执行...");
    }
}


class Cat extends Animal {
    static {
        System.out.println("Cat静态代码块执行...");
    }

    {
        System.out.println("Cat实例代码块执行...");
    }

    public Cat() {
        System.out.println("Cat构造器代码执行...");
    }
}

class A {
    public static void main(String[] args) {
        Cat cat = new Cat();
    }
}