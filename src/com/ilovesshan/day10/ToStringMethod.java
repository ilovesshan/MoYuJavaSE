package com.ilovesshan.day10;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/25
 * @description:
 */
public class ToStringMethod {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 这里借用一手 teacher 类来举例

        Teacher t1 = new Teacher("liLei", "1001");
        System.out.println(t1); // com.ilovesshan.day10.Teacher@e2d56bf

        String s1 = "1001";
        System.out.println(s1); // 1001


        Teacher t2 = new Teacher("liLei", "112");
        t2.setStudent(new Student());
        Teacher t3 = (Teacher) t2.clone();

        t2.name = "tom";
        t2.student.name ="lucy";

        System.out.println(t2.name); // tom
        System.out.println(t3.name); // liLei
        System.out.println(t2.student.name); // lucy
        System.out.println(t3.student.name); // lucy

        System.out.println(t2.name == t3.name); // true
        System.out.println(t2.orderNo == t3.orderNo);// true
        System.out.println(t2.equals(t3)); // true

    }
}
