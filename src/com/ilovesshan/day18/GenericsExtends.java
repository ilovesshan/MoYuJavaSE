package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class GenericsExtends {
    public static void main(String[] args) {
        MyClass1<User> myClass1 = new MyClass1<>();
        MyClass2 myClass2 = new MyClass2();
    }
}

interface MyInterface<T> {
}

// 实现MyInterface接口时 未指明泛型类型
class MyClass1<T> implements MyInterface<T> {}

// 实现MyInterface接口时 指明泛型类型
class MyClass2 implements MyInterface<User> {}