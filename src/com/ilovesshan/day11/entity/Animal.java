package com.ilovesshan.day11.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public class Animal {
    public void eat() {
        System.out.println("Animal eat");
    }

    public void eat(String food) {
        System.out.println("Animal eat: " + food);
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog eat");
    }

    public void eat(String food) {
        System.out.println("Dog eat: " + food);
    }

    public void run() {
        System.out.println("Dog running...");
    }
}


class Cat extends Animal {
    public void eat() {
        System.out.println("Cat eat");
    }

    public void eat(String food) {
        System.out.println("Cat eat: " + food);
    }

    public void play() {
        System.out.println("Dog playing...");
    }
}

class TestAnimal {

    public static void main(String[] args) {
        TestAnimal animal = new TestAnimal();
        animal.t(new Animal());
        // Animal eat


        animal.t(new Dog());
        // Dog eat
        // Dog running...

        animal.t(new Cat());
        // Cat eat
        // Dog playing...
    }

    // 向上转型
    public void t(Animal animal) {
        animal.eat();

        // 传入的是Dog类型 调用run方法
        if (animal instanceof Dog) {
            // 向下转型
            Dog dog = (Dog) animal;
            dog.run();
        }
        // 传入的是Cat类型 调用play方法
        if (animal instanceof Cat) {
            // 向下转型
            Cat cat = (Cat) animal;
            cat.play();
        }
    }
}


class Main {
    public static void main(String[] args) {
        Animal dog1 = new Dog();
        Dog dog2 = new Dog();

        dog1.eat(); // Dog eat
        dog1.eat("骨头"); // Dog eat: 骨头

        dog2.eat(); // Dog eat
        dog2.eat("骨头"); // Dog eat: 骨头
    }
}
