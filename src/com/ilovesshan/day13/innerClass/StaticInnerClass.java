package com.ilovesshan.day13.innerClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class StaticInnerClass {
    static {
        System.out.println("StaticInnerClass 静态代码块执行...");
    }

    {
        System.out.println("StaticInnerClass 实例代码块执行...");
    }

    public static String name1 = "StaticInnerClass name1";
    public String name2 = "StaticInnerClass name2";

    public static void sayName1() {
        System.out.println(name1);
    }

    public void sayName2() {
        System.out.println(name2);
    }

    public void createInnerClassInstance() {
        InnerClass.sayName3();

        System.out.println("**************************************");

        InnerClass aClass = new InnerClass();
        aClass.sayName4();
    }


    static class InnerClass {
        static {
            System.out.println("InnerClass 静态代码块执行...");
        }

        {
            System.out.println("InnerClass 实例代码块执行...");
        }

        public static String name3 = "InnerClass name3";
        public String name4 = "InnerClass name4";

        public static void sayName3() {
            // 访问外部静态成员 直接访问
            System.out.println(name1);
            sayName1();

            // 访问外部非静态成员 创建实例访问
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            System.out.println(staticInnerClass.name2);
            staticInnerClass.sayName2();
        }

        public void sayName4() {
            // 访问外部静态成员 直接访问
            System.out.println(name1);
            sayName1();

            // 访问外部非静态成员 创建实例访问
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            System.out.println(staticInnerClass.name2);
            staticInnerClass.sayName2();
        }

    }

    public static void main(String[] args) {
        StaticInnerClass memberInnerClass = new StaticInnerClass();
        memberInnerClass.createInnerClassInstance();
    }

}
