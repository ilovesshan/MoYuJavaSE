###  JavaSE 摸鱼第9天...

#### 1、超级数组

```java
public class Main {
    public static void main(String[] args) {
        SuperArray superArray = new SuperArray(2);

        // 添加
        superArray.add(10);
        superArray.add(20);
        superArray.add(30);
        superArray.add(40);
        superArray.add(50);

        // 查询
        System.out.println(superArray.get(-1)); // 检索的索引[-1]异常
        System.out.println(superArray.get(0));

        // 更改
        superArray.set(5, -100); //检索的索引[5]异常
        superArray.set(0, 100);
        superArray.set(3, 400);

        // 删除
        superArray.remove(-1); // 检索的索引[-1]异常
        superArray.remove(0);
        superArray.remove(2);

        // 指定位置插入
        superArray.add(0, 10);
        superArray.add(1, 56);
        superArray.add(3, 500);
        superArray.add(5, 12);
        superArray.add(3, -200);

        // 排序
        superArray.sort();

        System.out.println(superArray.arrayToString());  // [-200,10,12,20,30,50,56,500]
       
    }
}

```



```java
public class SuperArray {

    private int[] elements = null;
    private int currentIndex = -1;


    SuperArray() {
        this(10);
    }


    SuperArray(int capacity) {
        elements = new int[capacity];
    }


    /**
     * 添加数据
     *
     * @param data 值
     */
    public void add(int data) {
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
    public void add(int index, int data) {
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
    public void set(int index, int value) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return;
        }

        elements[index] = value;
    }

    /**
     * 获取数据
     *
     * @param index 索引
     * @return
     */
    public Integer get(int index) {
        if (!checkIndex(index)) {
            System.out.println("检索的索引[" + index + "]异常");
            return null;
        }
        return elements[index];
    }

    /**
     * 格式化打印数组
     *
     * @return [10, 20, 30]
     */
    public String arrayToString() {
        String result = "[";
        for (int i = 0; i < currentIndex + 1; i++) {
            result += elements[i] + ",";
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    /**
     * 排序
     */
    public void sort() {
        for (int i = 0; i <= currentIndex; i++) {
            for (int j = 0; j < currentIndex - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
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
        int[] newArray = new int[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        // 改变指针引用
        elements = newArray;
    }
}

```



#### 2、超级链表

```java
public class SuperLinkedTest {
    public static void main(String[] args) {

        SuperLinked superLinked = new SuperLinked();

        // 增加
        superLinked.add(10);
        superLinked.add(20);
        superLinked.add(30);
        superLinked.add(40);
        superLinked.add(50);

        // 查询
        System.out.println(superLinked.get(0));
        System.out.println(superLinked.get(1));
        System.out.println(superLinked.get(2));

        // 修改
        superLinked.set(0, 500);
        superLinked.set(1, 400);

        // 删除
        superLinked.remove(0);
        superLinked.remove(1);

        // 指定位置插入
        superLinked.add(2, 200);
        superLinked.add(1, -300);
        superLinked.add(0, -500);

        System.out.println(superLinked.linkedToString());

        // 插入1000条数据测试排序速度
        // 1000  15
        // 2000  17
        // 5000  40
        // 10000 176
        for (int i = 0; i < 10000; i++) {
            superLinked.add((int) (Math.random() * 1000));
        }

        long startTime = System.currentTimeMillis();
        // 排序
        superLinked.sort();
        System.out.println("链表长度：" + superLinked.getLength());
        long endTime = System.currentTimeMillis();
        System.out.println("排序耗时: " + (endTime - startTime));
        System.out.println(superLinked.linkedToString());

    }
}

```

```java
public class Node {
    private int data;
    private Node next;

    public Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

```

```java
public class SuperLinked {

    private Node first = null;
    private int currentIndex = -1;

    /**
     * 插入数据
     *
     * @param data 数据
     */
    public void add(int data) {
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
    public void add(int index, int data) {
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return;
        }
        // 头插入
        if (index == 0) {
            this.add(data);
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
    public Integer get(int index) {
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return null;
        }
        Node targetNode = first;
        for (int i = 0; i < index; i++) {
            targetNode = targetNode.getNext();
        }
        return targetNode.getData();
    }

    /**
     * 更新数据
     *
     * @param index 索引
     * @param data  数据
     */
    public void set(int index, int data) {
        if (index < 0 || index > currentIndex) {
            System.out.println("索引[" + index + "]检索异常");
            return;
        }
        Node currentNode = first;

        if (index == 0) {
            first.setData(data);
            return;
        }

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setData(data);
    }

    /**
     * 打印链表
     *
     * @return [1, 2, 3, 4]
     */
    public String linkedToString() {
        Node currentNode = first;
        String result = "[" + first.getData() + ",";
        for (int i = 0; i < currentIndex; i++) {
            currentNode = currentNode.getNext();
            result += currentNode.getData() + ",";
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    /**
     * 获取长度
     *
     * @return 长度
     */
    public int getLength() {
        return currentIndex;
    }

    /**
     * 排序
     */
    public void sort() {
        Node targetNode = null;
        for (int i = 0; i < currentIndex; i++) {
            targetNode = first;
            for (int j = 0; j < currentIndex - i; j++) {
                if (targetNode.getData() > targetNode.getNext().getData()) {
                    int temp = targetNode.getData();
                    targetNode.setData(targetNode.getNext().getData());
                    targetNode.getNext().setData(temp);
                }
                targetNode = targetNode.getNext();
            }
        }
    }
}

```



#### 3、基于超级链表实现的队列

```java
```

```java
```



#### 4、基于超级链表实现的栈

```java
public class Stack {

    SuperLinked mSuperLinked = new SuperLinked();

    public void push(int data) {
        mSuperLinked.add(data);
    }

    public void pop() {
        mSuperLinked.remove(0);
    }

    public int peek() {
        return mSuperLinked.get(0);
    }

    public boolean isEmpty() {
        return mSuperLinked.getLength() == -1;
    }


    public String stackToString() {
        return mSuperLinked.linkedToString();
    }

}

```

```java
public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println(stack.isEmpty()); // true

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.stackToString()); // [50,40,30,20,10]

        stack.pop();
        stack.pop();

        System.out.println(stack.stackToString()); // [30,20,10]


        System.out.println(stack.peek()); // 30

        System.out.println(stack.isEmpty()); // false

    }
}
