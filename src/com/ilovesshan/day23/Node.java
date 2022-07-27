package com.ilovesshan.day23;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/27
 * @description:
 */

public class Node {
    // 数据
    private Integer data;
    // 左节点
    private Node left;
    // 右节点
    private Node right;

    public Node() {
    }

    public Node(Integer data) {
        this.data = data;
    }

    public Node(Integer data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
