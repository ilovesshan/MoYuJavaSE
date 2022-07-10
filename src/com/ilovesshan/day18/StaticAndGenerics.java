package com.ilovesshan.day18;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class StaticAndGenerics {
    public static void main(String[] args) {

    }
}


class StaticClass<T> {
    private T t1;

    // 错误
    // private  static   T t2;

    static {
        int i3;
        // 错误
        // T t4;
    }


    // ok
    public static <E> E printS(E e) {
        return e;
    }
}