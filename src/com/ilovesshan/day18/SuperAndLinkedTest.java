package com.ilovesshan.day18;

import com.ilovesshan.day18.utils.ISuper;
import com.ilovesshan.day18.utils.SuperArray;
import com.ilovesshan.day18.utils.SuperLinked;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class SuperAndLinkedTest {
    public static void main(String[] args) {

        // 指定SuperArray类 传入的泛型是User类型 那么只能接收 User 或者 User的子类型 其他类不行
        ISuper<User> superArray = new SuperArray<>();
        ISuper<User> superLinked = new SuperLinked<>();


        // ok
        superArray.add(new User());
        superArray.add(new JackFamily());

        superLinked.add(new User());
        superLinked.add(new JackFamily());


        // 错误
        // superArray.add( new Dog());
        // superArray.add(new Object());
        // superLinked.add( new Dog());
        // superLinked.add(new Object());
    }
}


class JackFamily extends User {
}

