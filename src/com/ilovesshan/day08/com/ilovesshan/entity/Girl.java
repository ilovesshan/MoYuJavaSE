package com.ilovesshan.day08.com.ilovesshan.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/21
 * @description:
 */
public class
Girl {
    private int age;

    // 设置age
    public void setAge(int age) {
        // 逻辑处理代码
        this.age = 18;
    }

    // 获取age
    public int getAge() {
        // 逻辑处理代码
        return age;
    }

    public static void main(String[] args) {
        Girl girl = new Girl();

        // 设置成 30
        girl.setAge(30);

        // 获取是 18 是因为内部做了一层拦截
        System.out.println(girl.getAge());
    }
}
