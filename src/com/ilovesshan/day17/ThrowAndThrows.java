package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */
public class ThrowAndThrows {

    // `throw` 是使用在：方法体中
    public static void t1() {
        throw new UserNameErrorException("");
    }

    // `throws`  是使用在：方法签名后
    public static void t2() throws UserNameErrorException {

    }
}
