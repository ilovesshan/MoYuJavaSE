### JavaSE 摸鱼第18天...

#### 1、泛型引入

+ Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
+ 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

```java
public class GenericsIntroduce {
    public static void main(String[] args) {
        // 注意：<> 是一个标识符 它可以自动的进行类型推断
        // Common<Boy> boyCommon 定义类型的时候声明了泛型的类型，所以后面 new Common<> 就可以不用指明泛型类型了


        // 如果实例化一个泛型类时、没有指定的声明泛型，那么jvm默认的泛型就是 Object
        // 可以传入一个 Boy类型
        Common<Boy> boyCommon = new Common<>(new Boy());
        Boy boy = boyCommon.getT();
        System.out.println(boy);

        // 可以传入一个Cat类型
        Common<Cat> catCommon = new Common<>(new Cat());
        Cat cat = catCommon.getT();
        System.out.println(cat);


    }
}


class Boy {
}

class Cat {
}


// Common 是一个泛型类、
// T 本质就是一个字母、可以随便表示，但是约定俗成吧，统一用一些字母，例如： T, K, V ,T, E 来表示泛型的类型。
// Common类 很简单 一个T类型的成员变量，并且提供了getter和setter方法。
class Common<T> {
    private T t;

    public Common(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

```



#### 2、泛型类、泛型方法、泛型接口

##### 2.1、泛型类

```java
public class GenericsClassAndMethod {
    public static void main(String[] args) {
        Stack<Dog, Integer> stack = new Stack<>();

        Dog dog1 = new Dog("小白");
        Dog dog2 = new Dog("小花");
        Dog dog3 = new Dog("小🦌");
        stack.push(dog1);
        stack.push(dog2);
        stack.push(dog3);

        System.out.println(stack.findByIndex(0).getName());
        System.out.println(stack.findByIndex(1).getName());
        
    }
}


class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Stack<T, E> {
    private Object[] elementData;
    private int currentIndex = 0;

    public Stack() {
        elementData = new Object[5];
    }
    
    public void push(T t) {
        elementData[currentIndex] = t;
        currentIndex++;
    }

    public T findByIndex(int index) {
        return (T) this.elementData[index];
    }

}
```



##### 2.2、泛型方法

```java
public class GenericsClassAndMethod {
    public static void main(String[] args) {
        Dog dog = new Dog("小🦌");

        // 传入的 Dog 类型 那么返回类型会自动进行推断 默认是Object
        Dog dog = GenericsMethod.doSomeThing(dog);
        System.out.println(dog.getName());

        // 自动类型推断
        String hello = GenericsMethod.doSomeThing("hello");

    }
}

class GenericsMethod {
    // 泛型方法 语法   public <T> T doSomeThing(T t) {}
    // T  会根据 传入的形参进行自动类型的推断
    // 一般使用泛型方法 都会和方法返回值配合使用
    public static <T> T doSomeThing(T t) {
        return t;
    }

    // 多个参数
    public static <K, V> V doSomeThing(K k, V v) {
        return v;
    }
}

```



##### 2.3、泛型接口

```java
public class GenericsInterface {
    public static void main(String[] args) {
        // 传入的泛型类型是 User 在匿名内部类中 会进行自动类型的推断
        new Compare<User>(){

            @Override
            // User 类型是自动推断的
            public Integer compare(User t1, User t2) {
                return null;
            }
        };
    }
}


interface Compare<T, V> {
    Integer compare(T t1, T t2);
}
```



#### 3、SupperArray加入泛型机制

```java
public class SuperAndLinkedTest {
    public static void main(String[] args) {

        // 指定SuperArray类 传入的泛型是User类型 那么只能接收 User 或者 User的子类型 其他类不行
        SuperArray<User> superArray = new SuperArray<>();

        // ok
        superArray.add(new User());
        superArray.add(new JackFamily());


        // 错误
        // superArray.add(new Dog());
        // superArray.add(new Object());
    }
}


// User 的子类
class JackFamily extends User {
}


```



```java
package com.ilovesshan.day18.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/6/23
 * @description:
 */
public class SuperArray<T> {

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

```



#### 4、泛型继承、通配符

#### 5、泛型擦除

#### 6、静态和泛型