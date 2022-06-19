package com.ilovesshan.day07;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/19
 * @description:
 */
public class OverLoadMethod {

    public double add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(double a, int b) {
        return a + b;
    }

    public double add(int a, double b) {
        return a + b;
    }

    // 可变长参数
    public double add(int... nums) {
        // nums 本质是一个int[]
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i;
        }
        return res;
    }


    public static void main(String[] args) {
        OverLoadMethod loadMethod = new OverLoadMethod();

        System.out.println(loadMethod.add(10, 20));
        System.out.println(loadMethod.add(10.0, 20.0));
        System.out.println(loadMethod.add(10.0, 20));
        System.out.println(loadMethod.add(10, 20.0));

        System.out.println(loadMethod.add(10, 20, 30, 40, 50, 60));
    }
}
