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

#### 3、基于超级数组的队列和栈
