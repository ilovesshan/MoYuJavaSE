package com.ilovesshan.day11.entity;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/26
 * @description:
 */
public class Human {

}

class Man extends Human {

}

class Woman extends Human {
}


class Part {
    public void play(Human human) {
        System.out.println("Human开part...");
    }


    public void play(Man man) {
        System.out.println("Man开part...");
    }


    public void play(Woman woman) {
        System.out.println("Woman开part...");
    }


    public static void main(String[] args) {
        Part part = new Part();

        Human human = new Human();
        Human man = new Man();
        Human woman = new Woman();

        part.play(human); // Human开part...
        part.play(man); // Human开part...
        part.play(woman); // Human开part...


    }
}