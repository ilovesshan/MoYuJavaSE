package com.ilovesshan.day19;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class CommMethods {
    public static void main(String[] args) {
        SeasonEnum spring = SeasonEnum.valueOf("SPRING");
        String name = spring.name();
        int ordinal = spring.ordinal();
        System.out.println(name);
        System.out.println(ordinal);

        SeasonEnum[] values = SeasonEnum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
