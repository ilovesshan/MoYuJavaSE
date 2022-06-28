package com.ilovesshan.day13.innerClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class LocalClass {

    public static String name = "localClass name";
    public static String name1 = "localClass name1";
    public String name2 = "localClass name2";

    public static void printName1() {
        System.out.println(name1);
    }

    public void printName2() {
        System.out.println(this.name2);
    }

    public void createInnerClassInstance() {
        // 局部内部类
        class InnerClass {
            String name = "InnerClass name";

            {
                System.out.println("InnerClass 实例代码块执行...");
            }

            public void printName() {
                System.out.println(this.name);
                System.out.println(LocalClass.this.name);

                // 访问外部变量
                System.out.println(name1);
                System.out.println(name2);

                printName1();
                printName2();

            }
        }

        new InnerClass().printName();
    }

    public static void main(String[] args) {
        LocalClass localClass = new LocalClass();
        localClass.createInnerClassInstance();
    }

}
