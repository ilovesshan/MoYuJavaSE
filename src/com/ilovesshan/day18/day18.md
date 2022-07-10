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

##### 4.1、泛型继承

```java
public class GenericsExtends {
    public static void main(String[] args) {
        MyClass1<User> myClass1 = new MyClass1<>();
        MyClass2 myClass2 = new MyClass2();
    }
}

interface MyInterface<T> {
}

// 实现MyInterface接口时 未指明泛型类型
class MyClass1<T> implements MyInterface<T> {}

// 实现MyInterface接口时 指明泛型类型
```



##### 4.2、泛型通配符 

+ 案例需要的类

  ```java
  interface AInterface<T> {
  }
  
  class AInterfaceImpl<T> implements AInterface<T> {
  }
  
  
  class AA {
  }
  
  class BB extends AA {
  }
  
  class CC extends BB {
  }
  
  
  class Test {
      // 传入 任意类型
      void inputAny(AInterface<?> aInterface) {
      }
  
      // 传入 BB或者BB的子类
      void inputExtends(AInterface<? extends BB> aInterface) {
      }
  
  
      // 传入 BB或BB的父类
      void inputSuper(AInterface<? super BB> aInterface) {
      }
  }
  
  ```



+ `<?>` 表无限，随便传入

  ```java
  public class GenericWildcard {
      public static void main(String[] args) {
          Test test = new Test();
          
          // 传入 任意类型
          test.inputAny(new AInterfaceImpl<Object>());
          test.inputAny(new AInterfaceImpl<AA>());
          test.inputAny(new AInterfaceImpl<BB>());
          test.inputAny(new AInterfaceImpl<CC>());
          test.inputAny(new AInterfaceImpl<Integer>());
          test.inputAny(new AInterfaceImpl<User>());
      }
  }
  
  ```

  

+ `<? extends B>` 表下限，意思是：泛型类只能传入 B或者B的子类

  ```java
  public class GenericWildcard {
      public static void main(String[] args) {
          Test test = new Test();
          
          // 传入 BB或者BB的子类
  
          // 错误
          //test.inputExtends(new AInterfaceImpl<AA>());
  
          // ok
          test.inputExtends(new AInterfaceImpl<BB>());
          test.inputExtends(new AInterfaceImpl<CC>());
      }
  }
  
  ```

  

+ `<? super B>` 表上限，意思是：泛型类只能传入 B或者B的父类

  ```java
  public class GenericWildcard {
      public static void main(String[] args) {
          Test test = new Test();
          // 传入 BB或BB的父类
  
          // 错误
          // test.inputSuper(new AInterfaceImpl<CC>());
  
          // ok
          test.inputSuper(new AInterfaceImpl<Object>());
          test.inputSuper(new AInterfaceImpl<AA>());
          test.inputSuper(new AInterfaceImpl<BB>());
  
  
      }
  }
  
  ```

  

#### 5、泛型擦除

+ 泛型的概念是 `jdk1.4` 之后提出来的、在 `jdk1.4` 之前没有泛型的概念，而泛型擦除就是为了 兼容之前的代码。

##### 5.1、泛型擦除

```java
public class GenericErasure {
    // public static void printPair(Pair<User> pair) {}
    // public static void printPair(Pair<Cat> pair) {}

    // 注意 两个printPair方法 并不构成 方法的重载
    // 原因是: 经过泛型擦除之后将会是：
    // public static void printPair(Pair pair) {}
    // public static void printPair(Pair pair) {}

    // 很显然 编译器都通不过

}

// 泛型擦除的时候 T 将默认转成 Object
class Pair<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
```



##### 5.2、泛型擦除和多态产生的冲突

```java
// 泛型擦除的时候 T 将默认转成 Object
class Pair<T> {
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


class UserPicker extends Pair<User> {
    private User u;

    @Override
    public User getT() {
        return u;
    }

    // 看一个诡异的现象: 父类的set方法泛型被擦除后 public void setT(Object t) {  this.t = t;  }
    // 而 这里却传入的了 一个 User 类型, 好像违背了重写的规则

    // 其实 jvm在底层帮助我们做了很多很多的事情、底层通过一个桥接方法 来实现了 这里产生的小冲突
    @Override
    public void setT(User t) {
        this.u = t;
    }
}
```



#### 6、静态和泛型关系

+ 类中的静态成员、静态代码块中 不是使用到泛型，原因是：泛型加入机制就是，帮我我们在类被实例化或者方法被调用的时候再给予明确的类型、但是 静态变量或者静态代码块在类加载的时候就被加载到方法区去了。所以就冲突了，静态成员、静态代码块中不能使用泛型。

+ 静态方法可以使用，，原因是 方法调用的时候 我们会明确出泛型类型，所以并不冲突。

  ```java
  public class StaticAndGenerics {
      public static void main(String[] args) {
  
      }
  }
  
  
  class StaticClass<T> {
      private T t1;
  
      // 错误
      // private  static   T t2;
  
      static {
          int i3;
          
          // 错误
          // T t4;
      }
      
      
      // ok
      public static <E> E printS(E e) {
          return e;
      }
  }
  ```

  