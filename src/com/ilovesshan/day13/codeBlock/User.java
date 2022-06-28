package com.ilovesshan.day13.codeBlock;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class User {

    // 静态代码块 可以按照实际业务需求、write your code
    static {
        System.out.println("静态代码块执行...");
    }

    // 实例代码块 可以按照实际业务需求、write your code
    {
        System.out.println("实例代码块执行...");
    }

    public User() {
        System.out.println("User构造器代码执行...");
    }

    // 静态变量
    public static String name1 = "name1";

    // 普通成员变量
    public String name2 = "name2";


    // 静态方法
    public static void printName1() {
        System.out.println(name1);

        printName1();
        System.out.println(name1);

        // 静态方法中不能直接访问普通成员方法和变量、需要创建实例访问
        User user = new User();
        user.printName2();
        System.out.println(user.name2);


    }

    // 普通成员方法
    public void printName2() {
        System.out.println(this.name2);

        // 普通成员方法中可以直接访问静态方法和静态变量
        printName1();
        System.out.println(name1);
    }
}
