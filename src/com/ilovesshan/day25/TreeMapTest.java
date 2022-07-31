package com.ilovesshan.day25;

import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap1 = new TreeMap<>();
        TreeMap<Integer, String> treeMap2 = new TreeMap<>();

        treeMap1.put("A", "A");
        treeMap1.put("E", "E");
        treeMap1.put("C", "C");
        treeMap1.put("D", "D");
        treeMap1.put("B", "B");

        treeMap2.put(1, "A");
        treeMap2.put(2, "B");
        treeMap2.put(4, "D");
        treeMap2.put(3, "C");

        System.out.println("treeMap1 = " + treeMap1); // treeMap1 = {A=A, B=B, C=C, D=D, E=E}
        System.out.println("treeMap2 = " + treeMap2); // treeMap2 = {1=A, 2=B, 3=C, 4=D}


    }
}
