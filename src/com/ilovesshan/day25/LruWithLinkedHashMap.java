
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
public class LruWithLinkedHashMap {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>(10, 0.75F, true);

        map.put("zs", "zhangsan");
        map.put("ls", "lisi");
        map.put("ww", "wangwu");
        map.put("zl", "zhaoliu");
        map.put("sq", "sunqi");
        System.out.println(map); // {zs=zhangsan, ls=lisi, ww=wangwu, zl=zhaoliu, sq=sunqi}

        // 访问一次zl  看结果将"zl=zhaoliu"放到链表最后面
        map.get("zl");
        System.out.println(map); // {zs=zhangsan, ls=lisi, ww=wangwu, sq=sunqi, zl=zhaoliu}


        // 再访问一次ls  看结果将"ls=lisi"放到链表最后面
        map.get("ls");
        System.out.println(map); // {zs=zhangsan, ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi}


        // 新加入两个 默认会被放到链表最后面
        map.put("sb", "songba");
        map.put("lj", "laojiu");

        System.out.println(map); // {zs=zhangsan, ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi, sb=songba, lj=laojiu}
    }
}
