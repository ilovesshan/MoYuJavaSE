package com.ilovesshan.day16;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        double i1 = 0.1;
        double i2 = 0.2;
        System.out.println(i1 + i2); // 0.30000000000000004

        // 0.3
        System.out.println(BigDecimalUtils.add(i1, i2));

        // -0.1
        System.out.println(BigDecimalUtils.subtract(i1, i2));

        // 0.02
        System.out.println(BigDecimalUtils.multiply(i1, i2));

        // 0.5
        System.out.println(BigDecimalUtils.divide(i1, i2));

    }
}
