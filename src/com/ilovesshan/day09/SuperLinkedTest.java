package com.ilovesshan.day09;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/23
 * @description:
 */
public class SuperLinkedTest {
    public static void main(String[] args) {

        SuperLinked superLinked = new SuperLinked();

        // 增加
        superLinked.add(10);
        superLinked.add(20);
        superLinked.add(30);
        superLinked.add(40);
        superLinked.add(50);

        // 查询
        System.out.println(superLinked.get(0));
        System.out.println(superLinked.get(1));
        System.out.println(superLinked.get(2));

        // 修改
        superLinked.set(0, 500);
        superLinked.set(1, 400);

        // 删除
        superLinked.remove(0);
        superLinked.remove(1);

        // 指定位置插入
        superLinked.add(2, 200);
        superLinked.add(1, -300);
        superLinked.add(0, -500);

        System.out.println(superLinked.linkedToString());

        // 插入1000条数据测试排序速度
        // 1000  15
        // 2000  17
        // 5000  40
        // 10000 176
        for (int i = 0; i < 10000; i++) {
            superLinked.add((int) (Math.random() * 1000));
        }

        long startTime = System.currentTimeMillis();
        // 排序
        superLinked.sort();
        System.out.println("链表长度：" + superLinked.getLength());
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时: " + (endTime - startTime));
        System.out.println(superLinked.linkedToString());

    }
}
