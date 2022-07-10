package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/9
 * @description:
 */
public class GenericsClassAndMethod {
    public static void main(String[] args) {
        Stack<Dog, Integer> stack = new Stack<>();

        Dog dog1 = new Dog("小白");
        Dog dog2 = new Dog("小花");
        Dog dog3 = new Dog("小🦌");
        stack.push(dog1);
        stack.push(dog2);
        stack.push(dog3);

        System.out.println(stack.findByIndex(0).getName());
        System.out.println(stack.findByIndex(1).getName());


        // 传入的 Dog 类型 那么返回类型会自动进行推断 默认是Object
        Dog dog = GenericsMethod.doSomeThing(dog3);
        System.out.println(dog.getName());

        // 自动类型推断
        String hello = GenericsMethod.doSomeThing("hello");

    }
}

class GenericsMethod {
    // 泛型方法 语法   public <T> T doSomeThing(T t) {}
    // T  会根据 传入的形参进行自动类型的推断
    // 一般使用泛型方法 都会和方法返回值配合使用
    public static <T> T doSomeThing(T t) {
        return t;
    }


    // 多个参数
    public static <K, V> V doSomeThing(K k, V v) {
        return v;
    }

}

class Dog {
    private String name;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Stack<T, E> {
    private Object[] elementData;
    private int currentIndex = 0;

    public Stack() {
        elementData = new Object[5];
    }

    public void push(T t) {
        elementData[currentIndex] = t;
        currentIndex++;
    }

    public T findByIndex(int index) {
        return (T) this.elementData[index];
    }

}