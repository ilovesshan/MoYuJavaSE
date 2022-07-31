package com.ilovesshan.day25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class UseIteratorWithSet {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");


        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");;
        }
        System.out.println();


    }
}
