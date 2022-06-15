package com.ilovesshan.day04;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/15
 * @description:
 */
public class ForCycle {
    public static void main(String[] args) {
        // 简单的需求，打印10句话 `好好学习~`
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "好好学习~");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 100; i <= 999; i++) {
            int a = i / 100;
            int b = i / 10 % 10;
            int c = i % 10;

            if (i == a * a * a + b * b * b + c * c * c) {
                System.out.println(i);
            }

        }


        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }


        // for循环 打标签
        outerFor:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // break 默认只会打断当前循环 并不会打断外层的for
                // 如果在某个条件下 想打断外层for循环 可以使用打标签的方式
                System.out.println("*************" + i + "****************");
                if (i == 3) {
                    // outerFor 可以自己随便命名。
                    break outerFor;
                }
            }
        }

        // 更高级的写法 本质和上面是一样的，只不过换了位置.
        int i = 0;
        for (; ; ) {
            if (i < 10) {
                System.out.println(i + "好好学习~");
                i++;
            } else {
                break;
            }
        }


    }
}
