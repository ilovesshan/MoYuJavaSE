package com.ilovesshan.day24;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/29
 * @description: List接口  LinkedList 基本使用
 */
public class UseLinkedList {
    public static void main(String[] args) {

        //ArrayList 基本使用
        List<String> list = new LinkedList<>();
        List<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("2");

        // 演示 C R U D
        list.add("a");
        list.add("b");
        list.add("c");
        list.addAll(1, list2);


        for (String s : list) {
            System.out.print(s);
        }
        System.out.println(); // a12bc


        list.set(0, "A");


        list.remove(4);


        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println(); // A12b

    }
}
