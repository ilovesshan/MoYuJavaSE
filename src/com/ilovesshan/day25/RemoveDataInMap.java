package com.ilovesshan.day25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class RemoveDataInMap {
    public static void main(String[] args) {
        // 删除hashMap集合中 value等于BB的项

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "AA");
        hashMap.put("B", "BB");
        hashMap.put("C", "BB");
        hashMap.put("D", "BB");
        hashMap.put("E", "EE");


        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if ("BB".equals(entry.getValue())) {
                iterator.remove();
            }
        }

        System.out.println("hashMap = " + hashMap);  // hashMap = {A=AA, E=EE}
    }
}
