package com.ilovesshan.day25;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class HashMapVsLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();


        hashMap.put("zs", "zhangsan");
        hashMap.put("ls", "lisi");
        hashMap.put("ww", "wangwu");
        hashMap.put("zl", "zhaoliu");
        hashMap.put("sq", "sunqi");


        linkedHashMap.put("zs", "zhangsan");
        linkedHashMap.put("ls", "lisi");
        linkedHashMap.put("ww", "wangwu");
        linkedHashMap.put("zl", "zhaoliu");
        linkedHashMap.put("sq", "sunqi");


        System.out.println(hashMap);
        System.out.println(linkedHashMap);

    }
}
