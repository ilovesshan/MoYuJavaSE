package com.ilovesshan.day23;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description: 通过Node节点构建一棵树
 */
public class CreateTree {

    public static Node create() {
        // 根节点
        Node n1 = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setLeft(n4);
        n2.setRight(n5);

        n3.setLeft(n6);
        n3.setRight(n7);

        return n1;
    }
}
