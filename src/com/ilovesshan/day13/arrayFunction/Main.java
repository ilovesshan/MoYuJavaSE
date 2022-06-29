package com.ilovesshan.day13.arrayFunction;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/29
 * @description:
 */
public class Main {

    public int addTer(IAdd iAdd) {
        return iAdd.add(10, 30);
    }

    public static void main(String[] args) {
        Main main = new Main();

        // 原始写法
        int addTer1 = main.addTer(new IAdd() {
            @Override
            public int add(int i1, int i2) {
                return i1 + 2 * i2;
            }
        });
        System.out.println("addTer1 = " + addTer1);

        // 箭头函数 写法
        // 之所以叫 函数式接口  addTer 形参可以接受一个函数
        int addTer2 = main.addTer((i1, i2) -> i1 + 2 * i2);
        System.out.println("addTer2 = " + addTer2);
    }
}
