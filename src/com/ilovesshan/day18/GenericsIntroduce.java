package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/9
 * @description:
 */
public class GenericsIntroduce {
    public static void main(String[] args) {
        // 注意：<> 是一个标识符 它可以自动的进行类型推断
        // Common<Boy> boyCommon 定义类型的时候声明了泛型的类型，所以后面 new Common<> 就可以不用指明泛型类型了


        // 如果实例化一个泛型类时、没有指定的声明泛型，那么jvm默认的泛型就是 Object
        // 可以传入一个 Boy类型
        Common<Boy> boyCommon = new Common<>(new Boy());
        Boy boy = boyCommon.getT();
        System.out.println(boy);

        // 可以传入一个Cat类型
        Common<Cat> catCommon = new Common<>(new Cat());
        Cat cat = catCommon.getT();
        System.out.println(cat);


    }
}


class Boy {
}

class Cat {
}


// Common 是一个泛型类、
// T 本质就是一个字母、可以随便表示，但是约定俗成吧，统一用一些字母，例如： T, K, V ,T, E 来表示泛型的类型。
// Common类 很简单 一个T类型的成员变量，并且提供了getter和setter方法。
class Common<T> {
    private T t;

    public Common(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
