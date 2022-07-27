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

    public static Node createBinaryTree() {
        // 根节点
        Node n1 = new Node(10);

        Node n2 = new Node(5);
        Node n3 = new Node(2);
        Node n4 = new Node(8);
        Node n11 = new Node(9);
        Node n5 = new Node(1);
        Node n6 = new Node(20);
        Node n7 = new Node(15);
        Node n8 = new Node(30);
        Node n9 = new Node(12);
        Node n10 = new Node(40);

        n1.setLeft(n2);
        n1.setRight(n6);

        n2.setLeft(n3);
        n2.setRight(n4);

        n3.setLeft(n5);

        n4.setRight(n11);

        n6.setLeft(n7);
        n6.setRight(n8);

        n7.setLeft(n9);
        n8.setRight(n10);

        return n1;
    }

}
