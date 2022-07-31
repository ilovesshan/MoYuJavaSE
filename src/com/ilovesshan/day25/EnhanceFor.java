package com.ilovesshan.day25;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class EnhanceFor {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "11");
        hashMap.put("b", "22");
        hashMap.put("c", "33");
        hashMap.put("d", "44");


        for (String s : arrayList) {
            System.out.print(s + "\t");
        }
        System.out.println();

        System.out.println("*******************************");

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}
