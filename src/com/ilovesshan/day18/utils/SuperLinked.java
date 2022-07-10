package com.ilovesshan.day18.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/23
 * @description:
 */
public class SuperLinked<T> implements ISuper<T> {

    private Node<T> first = null;
    private int currentIndex = -1;

    /**
     * 插入数据
     *
     * @param data 数据
     */
    public void add(T data) {
        Node node = new Node(data, null);
        // 第一次添加元素
        if (first != null) {
            // 已经存在元素了、采用头插法
            node.setNext(first);
        }
        first = node;
        currentIndex++;
    }

    /**
     * 指定位置插入
     *
     * @param index 索引
     * @param data  数据
     */
    public void add(int index, T data) {
        // 头插入
        if (index == 0) {
            this.add(data);
            return;
        }
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return;
        }
        // 其他位置插入
        Node node = new Node(data, null);
        Node targetNode = first;
        for (int i = 0; i < index - 1; i++) {
            targetNode = targetNode.getNext();
        }
        node.setNext(targetNode.getNext());
        targetNode.setNext(node);
        currentIndex++;
    }


    /**
     * 删除数据
     *
     * @param index 索引
     */
    public void remove(int index) {
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return;
        }
        if (index == 0) {
            first = first.getNext();
            currentIndex--;
            return;
        }
        Node targetNode = first;

        for (int i = 0; i < index - 1; i++) {
            targetNode = targetNode.getNext();
        }
        targetNode.setNext(targetNode.getNext().getNext());
        currentIndex--;
    }

    /**
     * 查询数据
     *
     * @param index 索引
     * @return 查到的数据
     */
    public T get(int index) {
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return null;
        }
        Node targetNode = first;
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        return (T) targetNode.getData();
    }

    /**
     * 更新数据
     *
     * @param index 索引
     * @param data  数据
     */
    public void set(int index, T data) {
        Node currentNode = first;

        if (index == 0) {
            if (currentNode == null) {
                first = new Node(data, null);
                currentIndex++;
                return;
            } else {
                first.setData(data);
                return;
            }
        }
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return;
        }


        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(data);
    }

    /**
     * 获取长度
     *
     * @return 长度
     */
    public int getLength() {
        return currentIndex;
    }
}
