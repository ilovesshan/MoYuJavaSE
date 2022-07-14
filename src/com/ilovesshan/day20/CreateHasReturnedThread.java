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
public class CreateHasReturnedThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(1);
        System.out.println(2);
        // 创建 实例
        HasReturnedThread hasReturnedThread = new HasReturnedThread();
        // 通过 FutureTask 来管理这个子线程
        FutureTask<Integer> futureTask = new FutureTask<>(hasReturnedThread);
        // 开启线程
        futureTask.run();
        // 注意 get() 方法会阻塞代码向下执行 会抛出异常
        Integer value = futureTask.get();
        System.out.println(value);
        System.out.println(4);
        System.out.println(3);

    }
}

// 实现Callable接口, 并且需要实现 call()方法
// Callable 接口 需要传入一个泛型 这个泛型类型就是 all方法(你要返回的数据)的返回值类型
class HasReturnedThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 3;
    }
}