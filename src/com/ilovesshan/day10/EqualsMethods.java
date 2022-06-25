package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class EqualsMethods {
    private String name;


    public static void main(String[] args) {
        String s1 = "s1";
        String s2 = "s1";
        String s3 = new String("s1");

        System.out.println("s1.equals(s2) = " + s1.equals(s2)); // true
        System.out.println("s1.equals(s2) = " + s1.equals(s3)); // true
        System.out.println("s1.equals(s2) = " + s1 == s3); // false

    }
}
