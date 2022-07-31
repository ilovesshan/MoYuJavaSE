package com.ilovesshan.day25;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class MyLru<K, V> extends LinkedHashMap<K, V> {

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 什么时候时机开启 将最久没有被访问到的数据淘汰
        return size() > 4;
    }

    public MyLru() {
        super();
    }

    public MyLru(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }


    public static void main(String[] args) {

        Map<String, String> map = new MyLru<>(10, 0.75F, true);

        map.put("zs", "zhangsan");
        map.put("ls", "lisi");
        map.put("ww", "wangwu");
        map.put("zl", "zhaoliu");
        map.put("sq", "sunqi");
        // 由于 removeEldestEntry方法中 当链表长度大于4就删除太久未访问的数据  被删除了"zs=zhangsan"
        System.out.println(map); //{ls=lisi, ww=wangwu, zl=zhaoliu, sq=sunqi}

        // 访问一次zl  看结果将"zl=zhaoliu"放到链表最后面
        map.get("zl");
        System.out.println(map); // {ls=lisi, ww=wangwu, sq=sunqi, zl=zhaoliu}


        // 再访问一次ls  看结果将"ls=lisi"放到链表最后面
        map.get("ls");
        System.out.println(map); // {ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi}


        // 新加入两个 默认会被放到链表最后面
        map.put("sb", "songba");
        map.put("lj", "laojiu");

        // “ww=wangwu, sq=sunqi,” 被删除了
        System.out.println(map); // {zl=zhaoliu, ls=lisi, sb=songba, lj=laojiu}
    }
}
