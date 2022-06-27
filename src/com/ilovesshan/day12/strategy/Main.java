package com.ilovesshan.day12.strategy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/27
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        // 创建三个User对象、把他们放入到users 数组中
        User jack = new User("jack", 10, 156);
        User tom = new User("tom", 20, 176);
        User lucy = new User("lucy", 14, 183);

        User[] users = new User[]{jack, tom, lucy};

        // 1、对users数组按照年龄进行排序
        new UserSortUtils().sort(users, new AgeSort());
        System.out.println(Arrays.toString(users));
        // [User{name='jack', age=10, height=156.0}, User{name='lucy', age=14, height=183.0}, User{name='tom', age=20, height=176.0}]


        // 2、对users数组按照身高进行排序
        new UserSortUtils().sort(users, new HeightSort());
        System.out.println(Arrays.toString(users));
        // [User{name='jack', age=10, height=156.0}, User{name='tom', age=20, height=176.0}, User{name='lucy', age=14, height=183.0}]
    }
}
