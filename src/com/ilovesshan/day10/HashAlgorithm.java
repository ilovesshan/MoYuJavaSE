package com.ilovesshan.day10;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class HashAlgorithm {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // MessageDigest md5 = MessageDigest.getInstance("SHA1");
        // MessageDigest md5 = MessageDigest.getInstance("SHA-256");
        // MessageDigest md5 = MessageDigest.getInstance("SHA-512");

        byte[] digest = md5.digest("ilovesshan".getBytes(StandardCharsets.UTF_8));
        System.out.println(Arrays.toString(digest));
        // [8, 3, 77, -46, -55, -95, 7, -70, -79, -52, 64, 68, 22, 127, 83, 2]
    }
}
