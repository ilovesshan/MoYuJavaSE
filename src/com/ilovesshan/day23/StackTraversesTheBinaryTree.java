package com.ilovesshan.day23;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description: 栈实现遍历二叉树 先序遍历
 */
public class StackTraversesTheBinaryTree {
    public static void main(String[] args) {
        Node tree = CreateTree.create();

        Stack<Node> stack = new Stack<>();

        stack.push(tree);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode != null) {
                System.out.println(currentNode.getData());
                stack.push(currentNode.getRight());
                stack.push(currentNode.getLeft());
            }
        }
    }
}
