package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/24
 * @description:
 */
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.isEmpty()); // true

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.stackToString()); // [50,40,30,20,10]

        stack.pop();
        stack.pop();

        System.out.println(stack.stackToString()); // [30,20,10]


        System.out.println(stack.peek()); // 30

        System.out.println(stack.isEmpty()); // false

    }
}
