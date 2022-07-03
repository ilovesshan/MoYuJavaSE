package com.ilovesshan.day16;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class BigDecimalUtils {

    static double add(double d1, double d2) {
        BigDecimal i1 = new BigDecimal(Double.toString(d1));
        BigDecimal i2 = new BigDecimal(Double.toString(d2));
        return Double.parseDouble(i1.add(i2).toString());
    }


    static double subtract(double d1, double d2) {
        BigDecimal i1 = new BigDecimal(Double.toString(d1));
        BigDecimal i2 = new BigDecimal(Double.toString(d2));
        return Double.parseDouble(i1.subtract(i2).toString());
    }


    static double multiply(double d1, double d2) {
        BigDecimal i1 = new BigDecimal(Double.toString(d1));
        BigDecimal i2 = new BigDecimal(Double.toString(d2));
        return Double.parseDouble(i1.multiply(i2).toString());
    }

    static double divide(double d1, double d2) {
        BigDecimal i1 = new BigDecimal(Double.toString(d1));
        BigDecimal i2 = new BigDecimal(Double.toString(d2));
        return Double.parseDouble(i1.divide(i2).toString());
    }
}
