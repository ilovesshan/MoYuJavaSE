package com.ilovesshan.day08.com.ilovesshan.b;

import com.ilovesshan.day08.com.ilovesshan.a.A;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class B extends A {
    String className = "A";

    void printSuperName() {
        System.out.println(super.classTag);
        // super.sayName()
    }

}
