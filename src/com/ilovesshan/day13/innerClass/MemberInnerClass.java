package com.ilovesshan.day13.innerClass;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/28
 * @description:
 */
public class MemberInnerClass {
    {
        System.out.println("MemberInnerClass 实例代码块执行...");
    }

    public String name1 = "MemberInnerClass name1";

    public void sayName1() {
        System.out.println(this.name1);
    }

    public void createInnerClassInstance() {
        InnerClass innerClass = new InnerClass();
        innerClass.sayName2();
    }


    /* 可以加修饰符*/  class InnerClass {
        {
            System.out.println("InnerClass 实例代码块执行...");
        }

        // 和普通类用法一样 可以定义成员变量

        public String name2 = "InnerClass name2";

        public void sayName2() {
            System.out.println(this.name2);

            // 访问外部变量和方法
            System.out.println(name1);
            sayName1();
        }

    }

    public static void main(String[] args) {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        memberInnerClass.createInnerClassInstance();
    }

}
