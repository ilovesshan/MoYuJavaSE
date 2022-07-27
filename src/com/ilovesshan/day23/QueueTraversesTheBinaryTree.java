package com.ilovesshan.day23;

import com.ilovesshan.day18.utils.SuperArray;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description: 队列实现遍历二叉树 层次遍历
 */

public class QueueTraversesTheBinaryTree {
    public static void main(String[] args) {
        Node tree = CreateTree.create();
        SuperArray<Node> superLinked = new SuperArray<>();
        superLinked.add(tree);

        while (superLinked.getLength() > 0) {
            Node currentNode = superLinked.get(0);
            if (currentNode != null) {
                superLinked.remove(0);
                System.out.println(currentNode.getData());
                superLinked.add(currentNode.getLeft());
                superLinked.add(currentNode.getRight());
            }
        }
    }
}
