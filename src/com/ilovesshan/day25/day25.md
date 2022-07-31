### JavaSE 摸鱼第25天...

#### 1、迭代器的使用

##### 1.1、迭代器介绍

迭代器 iterator，主要用来遍历数据，例如：实现了 List、Map、Set接口的集合，其实实现了 List接口的集合我们可以通过for循环或者while来遍历，但是 实现了Map、Set接口的集合却不能使用for循环或者while来遍历，只能使用迭代器来遍历，List能用的原因是因为：List集合中提供了通过index获取数据的的方法，但是Map集合中并没有提供这样的方法，Set也一样。

Iterator是一个接口，里面主要有 `E next()`，`boolean hasNext()`两个用的最多的方法，iterator主要的工作原理就是：

A：盒子里还有饼干吗？ `hasNext()`

B：盒子里还有，给你一个。 `   E next()`

C：盒子里还有饼干吗？ `hasNext()`

B：没有了。

```java
public interface Iterator<E> {
    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}

```



##### 1.2、迭代器遍历List

使用for循环遍历List

```java
public class UseIteratorWithList {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");


        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + "\t");
        }
        System.out.println();
    }
}

```



使用while循环遍历List

```java

int size = 0;
while (size < arrayList.size()) {
    System.out.print(arrayList.get(size) + "\t");
    size++;
}
System.out.println();
```



使用Iterator循环遍历List

```java
Iterator<String> iterator = arrayList.iterator();
while (iterator.hasNext()) {
    System.out.print(iterator.next() + "\t");;
}
System.out.println();
```





##### 1.3、迭代器遍历Map

```java
package com.ilovesshan.day25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UseIteratorWithMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "11");
        hashMap.put("b", "22");
        hashMap.put("c", "33");
        hashMap.put("d", "44");


        // 方法一: 先获取所有的key,再通过key取value
        Set<String> keySet = hashMap.keySet();
        Iterator<String> keysIterator = keySet.iterator();
        while (keysIterator.hasNext()) {
            String key = keysIterator.next();
            System.out.println("key: " + key + ", value: " + hashMap.get(key));
        }


        System.out.println("***********************************************");


        // 方法二: 获取所有Entry对象,每一个Entry对象对象中保存了对应的key和value
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}




Connected to the target VM, address: '127.0.0.1:64496', transport: 'socket'
key: a, value: 11
key: b, value: 22
key: c, value: 33
key: d, value: 44
    
***********************************************
    
key: a, value: 11
key: b, value: 22
key: c, value: 33
key: d, value: 44
Disconnected from the target VM, address: '127.0.0.1:64496', transport: 'socket'

Process finished with exit code 0

```





##### 1.4、迭代器遍历Set

```java
package com.ilovesshan.day25;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UseIteratorWithSet {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("a");
        hashSet.add("b");
        hashSet.add("c");
        hashSet.add("d");


        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");;
        }
        System.out.println();

    }
}

```



#### 2、增强for循环

增强for循环是jdk提供的一个语法糖，用起来很简单，可以遍历List、set和Map

增强for循环的底层本质也是使用了迭代器

##### 2.1、增强for循环遍历List和Map

```java
package com.ilovesshan.day25;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class EnhanceFor {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("a", "11");
        hashMap.put("b", "22");
        hashMap.put("c", "33");
        hashMap.put("d", "44");


        for (String s : arrayList) {
            System.out.print(s + "\t");
        }
        System.out.println();

        
        
        System.out.println("*******************************");

        // Map 特殊一点点 先获取entrySet
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

    }
}



Connected to the target VM, address: '127.0.0.1:64608', transport: 'socket'
a	b	c	d	
*******************************
key: a, value: 11
key: b, value: 22
key: c, value: 33
key: d, value: 44
Disconnected from the target VM, address: '127.0.0.1:64608', transport: 'socket'

Process finished with exit code 0
```

