package com.ilovesshan.day19;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/10
 * @description:
 */
public class IntroduceEnum {
    // public static final int SPRING = 1;
    // public static final int SUMMER = 2;
    // public static final int AUTUMN = 3;
    // public static final int WINTER = 4;

    public static final Season SPRING = new Season(1, "SPRING");
    public static final Season SUMMER = new Season(1, "SUMMER");
    public static final Season AUTUMN = new Season(1, "AUTUMN");
    public static final Season WINTER = new Season(1, "WINTER");

    IntroduceEnum() {
    }

}


class Season {
    private int code;
    private String name;

    public Season(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


enum SeasonEnum {
    SPRING, SUMMER, AUTUMN, WINTER;
}