package com.ilovesshan.day17;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/5
 * @description:
 */
public class CommonCompileException {
    public static void main(String[] args) {

        // FileNotFoundException 文件找不到异常

        try {
            InputStream stream = new FileInputStream(new File("/abc/text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // ClassNotFoundException 类找不到异常
        try {
            Class<?> aClass = Class.forName("com.ilovesshan.day17.main");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
