package com.ilovesshan.day03;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/14
 * @description: 数据类型的计算
 */
public class DataTypeCalculate {
    public static void main(String[] args) {
        // 算术运算
        byte b = 1;
        short s = 1;
        int i = 1;
        long l = 1L;
        float f = 1.0F;
        double d = 1.0;

        // IDEA会报警 要么使用int接收 要么将结果强转成byte
        // byte res1 = b + s;
        int res2 = b + s;

        // IDEA会报警 要么使用double接收 要么将结果强转成int
        // int res3 =  b  + d;
        double res4 = b + d;

        // IDEA会报警 要么使用long接收 要么将结果强转成int
        // int res5 =  l + i;
        long res5 = l + i;

        // 当数值类进行运算时(增加自减不进行转化外)，
        // 没有long类型就将非int类型转int类计算并且返回int
        // 有long类型就将非long类型转成long类型计算 并且返回long

        // 逻辑运算

        // 逻辑或 &   短路或 &&
        boolean flag1 = true;
        boolean flag2 = false;

        System.out.println(flag1 & flag2); // false
        System.out.println(flag1 && flag2); // false

        // 逻辑与 |   短路与 ||

        System.out.println(flag1 | flag2);  // true
        System.out.println(flag1 || flag2);  // true


        // 逻辑非 !

        System.out.println(!flag1); // false
        System.out.println(!flag2); // true

        // 赋值运算
        int a = 10;

        a += 10; // a = a + 10;
        a -= 10; // a = a - 10;
        a *= 10; // a = a * 10;
        a /= 10; // a = a / 10


        // 三目运算
        //三目运算语法   表达式 ? 表达式等于true : 表达式等于false
        int i1 = 10;
        int i2 = 20;
        boolean c = true;

        int i3 = i1 > i2 ? i1 : i2;

        int i4 = i1 * 10 > i2 - 100 ? i1 : i2;

        int i5 = c ? i1 : i2;

        // 位移运算


        // 类型转换

        // float,double => byte、short、 int、long

        float num1 = 1.0F;
        double num2 = 1.0F;

        byte num3 = 1;
        short num4 = 1;
        int num5 = 1;
        long num6 = 1;


        // ok
        float r1 = num1 + num3;
        double r2 = num2 + num4;

        // float -> byte
        byte r3 = (byte) (num1 + num3);

        // double -> int
        int r4 = (int) (num2 + num4);

        // long -> int
        int r5 = (int) (num6 + num5);

        // long - short
        short r6 = (short) (num6 + num4);

        // char +  byte、short、 int、long
        char c1 = 'a';
        char c2 = '1';

        // byte -> char
        char r7 = (char) (c1 + c2 + num3);


        // float -> char
        char r8 = (char) (c1 + c2 + num1);


    }

}
