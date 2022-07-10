package com.ilovesshan.day19;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */


class EnumExpendTest {
    public static void main(String[] args) {
        EnumExpend[] values = EnumExpend.values();
        for (EnumExpend value : values) {
            System.out.println(value.getName() + ": " + value.getDescribe());
        }
    }
}

public enum EnumExpend {
    SPRING("春天", "春天到了..."),
    SUMMER("夏天", "夏天到了..."),
    AUTUMN("秋天", "秋天到了..."),
    WINTER("冬天", "冬天到了...");

    private String name;
    private String describe;

    EnumExpend() {
    }

    EnumExpend(String message, String describe) {
        this.name = message;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
