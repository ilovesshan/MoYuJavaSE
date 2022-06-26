package com.ilovesshan.day12._interface;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public interface CommonAction {
    void fly();

    default void show() {
    }

}

class plane implements CommonAction {

    @Override
    public void fly() {

    }

}


class Bird implements CommonAction {

    @Override
    public void fly() {

    }
}