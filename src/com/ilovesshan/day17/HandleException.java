package com.ilovesshan.day17;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/5
 * @description:
 */
public class HandleException {
    public static void e2() throws Exception {
        // 可以把异常继续抛出去 也可以捕获
        e1();
    }

    public static void e1() throws Exception {
        System.out.println(10 / 0);
    }

    public static void main(String[] args) {

        // 最终的调用者 需要捕获异常了，否则就会抛给jvm 那就直接让你程序挂了
        try {
            HandleException.e2();
        } catch (Exception e) {
            System.out.println("除数不能为0~");
            e.printStackTrace();
        }
    }
}
