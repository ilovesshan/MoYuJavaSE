package com.ilovesshan.day24;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/29
 * @description: HashSet基本使用
 */
public class UseHashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        // 添加元素
        hashSet.add("5");
        hashSet.add("4");
        hashSet.add("5");
        hashSet.add("3");
        hashSet.add("2");
        hashSet.add("1");
        hashSet.add("0");
        hashSet.add("a");
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");
        hashSet.add("e");
        hashSet.add("f");

        // 无序 不重复
        System.out.println(hashSet); // [0, 1, a, 2, b, 3, c, 4, d, 5, e, f]


        hashSet.remove("a");
        hashSet.remove("5");

        System.out.println(hashSet); // [0, 1, 2, b, 3, c, 4, d, e, f]


        // 长度
        System.out.println(hashSet.size()); // 10

        // 使用 Iterator 遍历
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
