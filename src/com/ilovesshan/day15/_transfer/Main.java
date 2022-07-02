package com.ilovesshan.day15._transfer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/2
 * @description:
 */
public class Main {
    public static void main(String[] args) {

        // Date 和 Instant 互相转换
        Date date = new Date();

        // Date => Instant
        Instant instant = date.toInstant();

        // Instant => Date
        Date date1 = Date.from(instant);


        // Date 和 本地时间(LocalDateTime) 互相转换

        // Date => LocalDateTime
        // Date => Instant => LocalDateTime
        Instant instant1 = date.toInstant();
        LocalDateTime.ofInstant(instant1, TimeZone.getDefault().toZoneId());

        // LocalDateTime => Date
        // LocalDateTime => Instant => Date
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant2 = localDateTime.toInstant(ZoneOffset.UTC);
        Date from = Date.from(instant2);


        // Instant 和 本地时间(LocalDateTime) 互相转换

        // Instant => LocalDateTime
        LocalDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());

        // LocalDateTime => Instant
        // 方法1
        localDateTime.toInstant(ZoneOffset.UTC);
        // 方法2
        localDateTime.atOffset(ZoneOffset.UTC).toInstant();

    }
}
