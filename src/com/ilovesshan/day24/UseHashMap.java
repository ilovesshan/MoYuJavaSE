package com.ilovesshan.day24;

import com.ilovesshan.day24.entity.User;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/29
 * @description: HashMap 基本使用
 */
public class UseHashMap {

    public static void main(String[] args) {
        HashMap<String, User> hashMap = new HashMap<>();
        TreeMap<String, User> treeMap = new TreeMap<>();
        Hashtable<String, User> hashtable = new Hashtable<>();


        // 插入数据 key相同时、后面的会覆盖前面的
        hashMap.put("u1", new User("u1", "u1!@#"));
        hashMap.put("u2", new User("u2", "u2!@#"));
        hashMap.put("u3", new User("u1", "u3!@#"));
        hashMap.put("u2", new User("u1", "u4!@#"));


        // 根据Key获取Value
        User user = hashMap.get("u2");
        System.out.println(user); // User{username='u1', password='u4!@#'}


        // 删除元素
        hashMap.remove("u1");

        // 长度
        System.out.println("hashMap.size() = " + hashMap.size()); // hashMap.size() = 2

        // 获取所有的value
        Collection<User> values = hashMap.values();
        System.out.println("values = " + values); // values = [User{username='u1', password='u4!@#'}, User{username='u1', password='u3!@#'}]

        // 获取所有的Key
        Set<String> keys = hashMap.keySet();
        System.out.println("keys = " + keys); // keys = [u2, u3]


    }
}
