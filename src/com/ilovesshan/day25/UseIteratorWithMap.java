package com.ilovesshan.day25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class UseIteratorWithMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "11");
        hashMap.put("b", "22");
        hashMap.put("c", "33");
        hashMap.put("d", "44");


        // 方法一: 先获取所有的key,再通过key取value
        Set<String> keySet = hashMap.keySet();
        Iterator<String> keysIterator = keySet.iterator();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            System.out.println("key: " + key + ", value: " + hashMap.get(key));
        }


        System.out.println("***********************************************");


        // 方法二: 获取所有Entry对象,每一个Entry对象对象中保存了对应的key和value
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}
