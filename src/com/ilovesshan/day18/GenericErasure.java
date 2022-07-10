package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class GenericErasure {
    // public static void printPair(Pair<User> pair) {}
    // public static void printPair(Pair<Cat> pair) {}

    // 注意 两个printPair方法 并不构成 方法的重载
    // 原因是: 经过泛型擦除之后将会是：很显然 编译器都通不过
    // public static void printPair(Pair pair) {}
    // public static void printPair(Pair pair) {}


    public static void main(String[] args) {

    }


}

// 泛型擦除的时候 T 将默认转成 Object
class Pair<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


class UserPicker extends Pair<User> {
    private User u;

    @Override
    public User getT() {
        return u;
    }

    // 看一个诡异的现象: 父类的set方法泛型被擦除后 public void setT(Object t) {  this.t = t;  }
    // 而 这里却传入的了 一个 User 类型, 好像违背了重写的规则

    // 其实 jvm在底层帮助我们做了很多很多的事情、底层通过一个桥接方法 来实现了 这里产生的小冲突
    @Override
    public void setT(User t) {
        this.u = t;
    }
}
