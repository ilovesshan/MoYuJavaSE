package com.ilovesshan.day20;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/14
 * @description:
 */
public class CalculateNumberTotal {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long total = 0;
        long maxNum = 10000000;
        // 单线程方式
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < maxNum; i++) {
            total += i;
        }
        long endTime = System.currentTimeMillis();

        System.out.println("单线程方式   计算1~" + maxNum + "总和是: " + total + ", 耗时: " + (endTime - startTime));


        // 多线程方式
        total = 0;
        startTime = System.currentTimeMillis();

        FutureTask[] futureTasks = new FutureTask[10];

        for (int i = 0; i < futureTasks.length; i++) {
            FutureTask<Long> futureTask = new FutureTask<>(new CalculateNumber(i * 10000000, (i + 1) * 10000000));
            futureTask.run();
            futureTasks[i] = futureTask;
        }

        for (int i = 0; i < futureTasks.length; i++) {
            Long result = (Long) futureTasks[i].get();
            total += result;
        }

        endTime = System.currentTimeMillis();
        System.out.println("多线程方式   计算1~" + maxNum + "总和是: " + total + ", 耗时: " + (endTime - startTime));
    }
}


class CalculateNumber implements Callable<Long> {
    int start;
    int end;

    public CalculateNumber() {
    }

    public CalculateNumber(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        long result = 0L;
        for (int i = start; i < end; i++) {
            result += i;
        }
        return result;
    }
}