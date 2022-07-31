package com.ilovesshan.day25;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class RemoveDataInList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("B");
        list.add("B");
        list.add("C");


        // 删除list集合中 值等于C的项


        // 使用for循环从前往后遍历时, 删除元素之后数组长度会自动缩短,注意回退i位置,
        for (int i = 0; i < list.size(); i++) {
            if ("B".equals(list.get(i))) {
                list.remove(list.get(i));
                i--;
            }

        }
        System.out.println("list = " + list);


        // 使用for循环从后往前遍历时, 不需要考虑i的位置
        for (int i = list.size()-1; i >=0; i--) {
            if ("B".equals(list.get(i))) {
                list.remove(list.get(i));
            }
        }
        System.out.println("list = " + list);


        // 比较推荐使用这种方法
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if ("B".equals(iterator.next())) {
                iterator.remove();
            }
        }
        System.out.println("list = " + list);

    }
}
