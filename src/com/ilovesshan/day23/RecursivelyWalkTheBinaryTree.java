package com.ilovesshan.day23;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description: 递归遍历二叉树，实现前序遍历、中序遍历、后序遍历
 */

public class RecursivelyWalkTheBinaryTree {

    // 前序遍历
    public static void preRecursive(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        preRecursive(node.getLeft());
        preRecursive(node.getRight());
    }

    // 中序遍历
    public static void inRecursive(Node node) {
        if (node == null) {
            return;
        }
        inRecursive(node.getLeft());
        System.out.println(node.getData());
        inRecursive(node.getRight());
    }

    // 后序遍历
    public static void postRecursive(Node node) {
        if (node == null) {
            return;
        }
        postRecursive(node.getLeft());
        postRecursive(node.getRight());
        System.out.println(node.getData());
    }


    public static void main(String[] args) {
        Node tree = CreateTree.create();

        // 前序遍历
        System.out.println("前序遍历结果: ");
        RecursivelyWalkTheBinaryTree.preRecursive(tree);


        // 中序遍历
        System.out.println("中序遍历结果: ");
        RecursivelyWalkTheBinaryTree.inRecursive(tree);


        // 后序遍历
        System.out.println("后序遍历结果: ");
        RecursivelyWalkTheBinaryTree.postRecursive(tree);
    }

}
