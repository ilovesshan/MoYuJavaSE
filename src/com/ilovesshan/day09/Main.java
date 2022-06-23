package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/23
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        SuperArray superArray = new SuperArray(2);

        // 添加
        superArray.add(10);
        superArray.add(20);
        superArray.add(30);
        superArray.add(40);
        superArray.add(50);

        // 查询
        System.out.println(superArray.get(-1)); // 检索的索引[-1]异常
        System.out.println(superArray.get(0));

        // 更改
        superArray.set(5, -100); //检索的索引[5]异常
        superArray.set(0, 100);
        superArray.set(3, 400);

        // 删除
        superArray.remove(-1); // 检索的索引[-1]异常
        superArray.remove(0);
        superArray.remove(2);

        // 指定位置插入
        superArray.add(0, 10);
        superArray.add(1, 56);
        superArray.add(3, 500);
        superArray.add(5, 12);
        superArray.add(3, -200);

        // 排序
        superArray.sort();

        System.out.println(superArray.arrayToString());
    }
}
