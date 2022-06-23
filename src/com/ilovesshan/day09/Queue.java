package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/24
 * @description:
 */
public class Queue {
    SuperLinked mSuperLinked = new SuperLinked();

    public void push(int data) {
        if (isEmpty()) {
            mSuperLinked.add(0, data);
            return;
        }
        mSuperLinked.add(mSuperLinked.getLength(), data);
    }

    public void pop() {
        mSuperLinked.remove(mSuperLinked.getLength());
    }

    public int peek() {
        return mSuperLinked.get(mSuperLinked.getLength());
    }

    public boolean isEmpty() {
        return mSuperLinked.getLength() == -1;
    }


    public String queueToString() {
        return mSuperLinked.linkedToString();
    }
}
