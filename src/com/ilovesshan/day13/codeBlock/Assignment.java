package com.ilovesshan.day13.codeBlock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class Assignment {
    // public static String name1 = "jack";  等同于1 2
    /* 1 */ public static String name1;

    // public String name2 = "jack";  等同于3 4
    /* 3 */public String name2;

    {
        // System.out.println("实例代码块执行..."); // 等同于 5
    }

    static {
        /* 2 */
        name1 = "jack";
        System.out.println("stack  block code");
    }

    Assignment() {
        /* 5 */
        System.out.println("实例代码块执行...");
        /* 4 */
        name2 = "jack";
        System.out.println("构造器代码块执行...");
    }

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
        System.out.println(Assignment.name1);
        System.out.println(assignment.name2);
    }
}
