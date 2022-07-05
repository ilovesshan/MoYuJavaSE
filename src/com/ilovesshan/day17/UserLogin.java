package com.ilovesshan.day17;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/6
 * @description:
 */
public class UserLogin {
    public static void main(String[] args) {
        try {
            userLoginHandler();
        } catch (Exception e) {

            e.printStackTrace();
            // 打印异常的错误信息
            System.out.println(e.getMessage());
        }

    }

    private static void userLoginHandler() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入用户名: ");
        String username = scanner.next();


        System.out.print("请输入密码: ");
        String password = scanner.next();

        if (!"admin".equals(username)) {
            throw new UserNameErrorException("用户名错误");
        }

        if (!"123456".equals(password)) {
            throw new UserNameErrorException("密码错误");
        }

        System.out.println("login success~");
    }
}
