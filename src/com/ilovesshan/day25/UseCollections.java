package com.ilovesshan.day25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class UseCollections {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");

        // 添加数据
        Collections.addAll(arrayList, "e", "f", "g");
        System.out.println("arrayList = " + arrayList); //  [a, b, c, d, e, f, g]


        // 反转
        Collections.reverse(arrayList);
        System.out.println("arrayList = " + arrayList); //   [g, f, e, d, c, b, a]


        // 替换
        Collections.replaceAll(arrayList, "a", "A");
        System.out.println("arrayList = " + arrayList); //  [g, f, e, d, c, b, A]


        // 乱序 打乱集合顺序
        Collections.shuffle(arrayList);
        System.out.println("arrayList = " + arrayList); //   [c, f, g, b, d, a, e]


    }
}
