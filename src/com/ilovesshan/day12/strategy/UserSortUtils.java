package com.ilovesshan.day12.strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/27
 * @description:
 */

public class UserSortUtils {

    public void sort(User[] users, Comparable comparable) {
        for (int i = 0; i < users.length - 1; i++) {
            for (int j = 0; j < users.length - 1 - i; j++) {
                if (comparable.compare(users[j], users[j + 1]) > 0) {
                    // 交换顺序
                    User temp = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = temp;
                }
            }
        }
    }
}
