package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class Father {
    public void eat() {
        System.out.println("我喜欢吃鱼...");
    }

    public static void main(String[] args) {
        new Father().eat();  // 我喜欢吃鱼...
        new Son().eat(); // 我喜欢吃猪肉...
    }

}


class Son extends Father {
    @Override
    public void eat() {
        System.out.println("我喜欢吃猪肉...");
    }
}
