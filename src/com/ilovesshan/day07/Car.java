package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class Car {
    // 类型
    String type;

    //颜色
    String color;

    // 最大马力
    int maxSpeed;


    public void run() {
        System.out.println("嘀嘀嘀，开车了...");
    }


    // 改变车的颜色
    // color 叫做形参
    public void changeColor(String color) {
        System.out.println("给车改变成" + color + "了...");
    }


    /**
     * 注意看 之前我们定义的方法都有一个void关键字
     * void关键字 就表示没有返回值。
     * Boolean 就表示要返回一个Boolean值
     * int  就表示要返回一个int值
     * String 就表示要返回一个String值
     * 其他类型以此类推...
     *
     * @param color 车的颜色
     * @return 改色的结果
     */
    public boolean changeColorIsSuccess(String color) {
        double random = Math.random();
        System.out.println("给车改变成" + color + "了...");
        if (random > 0.5) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 打开车窗
     * 接收多个参数、形参之间就用英文的逗号隔开即可
     *
     * @param leftBefore  左边前窗
     * @param leftAfter   左边后窗
     * @param rightBefore 右边前窗
     * @param rightAfter  右边后窗
     * @param top         天窗
     */
    public void openWindow(boolean leftBefore, boolean leftAfter, boolean rightAfter, boolean rightBefore, boolean top) {
        // 实现开窗的方法...
    }
}
