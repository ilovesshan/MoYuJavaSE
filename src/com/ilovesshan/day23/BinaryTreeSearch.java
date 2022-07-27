package com.ilovesshan.day23;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description: 搜索二叉树查找
 */
public class BinaryTreeSearch {

    public static int findValue(Node node, int target) {
        if (node != null) {
            if (target > node.getData()) {
                return findValue(node.getRight(), target);
            } else if (target == node.getData()) {
                return target;
            } else {
                return findValue(node.getLeft(), target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = CreateTree.createBinaryTree();

        int target1 = 10;
        int i1 = BinaryTreeSearch.findValue(root, target1);
        System.out.println("查找结果: " + i1);


        int target2 = 100;
        int i2 = BinaryTreeSearch.findValue(root, target2);
        System.out.println("查找结果: " + i2);

    }
}
