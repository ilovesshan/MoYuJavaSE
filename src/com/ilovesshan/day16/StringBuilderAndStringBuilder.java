package com.ilovesshan.day16;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/3
 * @description:
 */
public class StringBuilderAndStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        String str = "";

        int count = 10000;




        // 追加
        builder.append("a").append("b").append("c");
        System.out.println(builder);
        // 指定位置插入
        builder.insert(0, "A");
        System.out.println(builder);
        // 查找
        int i1 = builder.indexOf("b");
        System.out.println(i1);


        // 追加
        buffer.append("a").append("b").append("c");
        System.out.println(buffer);
        // 指定位置插入
        buffer.insert(0, "A");
        System.out.println(builder);
        // 查找
        int i2 = buffer.indexOf("b");
        System.out.println(i2);



        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            builder.append(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder 拼接" + count + "条数据耗时：" + (end - start));


        start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            buffer.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer 拼接" + count + "条数据耗时：" + (end - start));


        start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            str += Integer.toString(i);
        }
        end = System.currentTimeMillis();
        System.out.println("String 拼接" + count + "条数据耗时：" + (end - start));



    }
}
