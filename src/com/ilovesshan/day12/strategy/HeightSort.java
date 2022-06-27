package com.ilovesshan.day12.strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/27
 * @description:
 */
public class HeightSort implements Comparable {
    @Override
    public Integer compare(Object o1, Object o2) {
        if (o1 instanceof User && o2 instanceof User) {
            User u1 = (User) o1;
            User u2 = (User) o2;

            return (int) (u1.getHeight() - u2.getHeight());
        }
        return null;
    }
}
