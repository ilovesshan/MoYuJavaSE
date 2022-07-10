package com.ilovesshan.day18.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/23
 * @description:
 */
public class SuperArray<T> implements ISuper<T> {

    private Object[] elements = null;
    private int currentIndex = -1;


    public SuperArray() {
        this(10);
    }


    SuperArray(int capacity) {
        elements = new Object[capacity];
    }


    /**
     * 添加数据
     *
     * @param data 值
     */
    public void add(T data) {
        // 判断是否需要扩容
        if (elements.length <= currentIndex + 1) {
            grow();
        }
        currentIndex++;
        elements[currentIndex] = data;
    }


    /**
     * 在指定索引位置插入数据
     *
     * @param index 索引
     * @param data  数据
     */
    public void add(int index, T data) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return;
        }

        // 判断是否需要扩容
        if (elements.length - 1 <= currentIndex + 1) {
            grow();
        }

        for (int i = currentIndex + 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = data;
        currentIndex++;

    }


    /**
     * 删除数据
     *
     * @param index 索引
     */
    public void remove(int index) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return;
        }

        for (int i = index + 1; i < currentIndex + 1; i++) {
            elements[i - 1] = elements[i];
        }
        currentIndex--;

    }

    /**
     * 修改数据
     *
     * @param index 索引
     * @param value 值
     */
    public void set(int index, T value) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return;
        }

        elements[index] = value;
    }

    @Override
    public int getLength() {
        return this.currentIndex;
    }

    /**
     * 获取数据
     *
     * @param index 索引
     * @return
     */
    public T get(int index) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return null;
        }
        return (T) elements[index];
    }


    /**
     * 校验索引是否有效
     *
     * @param index 索引
     * @return 是否有效
     */
    boolean checkIndex(int index) {
        if (index < 0 || index > currentIndex) {
            return false;
        }
        return true;
    }


    /**
     * 扩容
     */
    public void grow() {
        // 扩容 扩2倍
        Object[] newArray = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        // 改变指针引用
        elements = newArray;
    }
}
