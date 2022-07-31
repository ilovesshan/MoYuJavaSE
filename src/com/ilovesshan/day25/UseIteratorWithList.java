package com.ilovesshan.day25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class UseIteratorWithList {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }
        System.out.println();


        int size = 0;
        while (size < arrayList.size()) {
            System.out.print(arrayList.get(size) + "\t");
            size++;
        }
        System.out.println();


        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");;
        }
        System.out.println();
    }
}
