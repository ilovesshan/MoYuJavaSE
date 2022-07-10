package com.ilovesshan.day18.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public interface ISuper<T> {
    void add(T t);

    void add(int index, T t);

    void remove(int index);

    T get(int index);

    void set(int index, T data);

    int getLength();
}
