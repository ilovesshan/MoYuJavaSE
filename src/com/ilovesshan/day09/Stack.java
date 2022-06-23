package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/24
 * @description:
 */
public class Stack {

    SuperLinked mSuperLinked = new SuperLinked();

    public void push(int data) {
        mSuperLinked.add(data);
    }

    public void pop() {
        mSuperLinked.remove(0);
    }

    public int peek() {
        return mSuperLinked.get(0);
    }

    public boolean isEmpty() {
        return mSuperLinked.getLength() == -1;
    }


    public String stackToString() {
        return mSuperLinked.linkedToString();
    }

}
