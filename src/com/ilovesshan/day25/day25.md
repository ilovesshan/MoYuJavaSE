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



#### 3、LinkedHashMap和LRU算法

##### 3.1、LinkedHashMap和HashMap

先看一个案例对比LinkedHashMap和HashMap

```java
package com.ilovesshan.day25;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapVsLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();


        hashMap.put("zs", "zhangsan");
        hashMap.put("ls", "lisi");
        hashMap.put("ww", "wangwu");
        hashMap.put("zl", "zhaoliu");
        hashMap.put("sq", "sunqi");


        linkedHashMap.put("zs", "zhangsan");
        linkedHashMap.put("ls", "lisi");
        linkedHashMap.put("ww", "wangwu");
        linkedHashMap.put("zl", "zhaoliu");
        linkedHashMap.put("sq", "sunqi");


        System.out.println(hashMap);
        System.out.println(linkedHashMap);

    }
}



Connected to the target VM, address: '127.0.0.1:49736', transport: 'socket'
{ww=wangwu, zl=zhaoliu, ls=lisi, zs=zhangsan, sq=sunqi}
{zs=zhangsan, ls=lisi, ww=wangwu, zl=zhaoliu, sq=sunqi}
Disconnected from the target VM, address: '127.0.0.1:49736', transport: 'socket'

Process finished with exit code 0

```

根据得到的结果发现：`hashMap` 是乱序的，获取到的数据排列顺序并不是存放时放进去的顺序，而 `LinkedHashMap` 刚好向和存放进去的顺序一致。

原因是：`hashMap` 再计算具体存放数据的槽位时、本身就不能确定会按照什么顺序去放，而是根据特定的算法算出来的，可能再1号插槽也可能在2号插槽。而`LinkedHashMap`可以做到的原因是：`LinkedHashMap` 在 `HashMap`的基础之上，在内部维护了一个 链表，用来保存数据的先后顺序。

```java
static class Entry<K,V> extends HashMap.Node<K,V> {
    Entry<K,V> before, after;
    Entry(int hash, K key, V value, Node<K,V> next) {
        super(hash, key, value, next);
    }
}
```



##### 3.2、LRU算法

LRU全称是Least Recently Used，即最近最久未使用的意思。

LRU算法的设计原则是：如果一个数据在最近一段时间没有被访问到，那么在将来它被访问的可能性也很小。也就是说，当限定的空间已存满数据时，应当把最久没有被访问到的数据淘汰。



`使用 `LinkedHashMap`来玩一玩 LRU, 先了解一下LinkedHashMap` 有一个三个参数构造器

```java
// initialCapacity  默认容量 值默认是16
// loadFactor       负载因子 默认是 0.75f
// accessOrder      默认为false，即维护插入顺序，设置为true时，维护访问顺序

public LinkedHashMap(int initialCapacity,   float loadFactor, boolean accessOrder) {
    super(initialCapacity, loadFactor);
    this.accessOrder = accessOrder;
}
```

```java
package com.ilovesshan.day25;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class MyLru {
    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>(10, 0.75F, true);

        map.put("zs", "zhangsan");
        map.put("ls", "lisi");
        map.put("ww", "wangwu");
        map.put("zl", "zhaoliu");
        map.put("sq", "sunqi");
        System.out.println(map); // {zs=zhangsan, ls=lisi, ww=wangwu, zl=zhaoliu, sq=sunqi}

        // 访问一次zl  看结果将"zl=zhaoliu"放到链表最后面
        map.get("zl");
        System.out.println(map); // {zs=zhangsan, ls=lisi, ww=wangwu, sq=sunqi, zl=zhaoliu}


        // 再访问一次ls  看结果将"ls=lisi"放到链表最后面
        map.get("ls");
        System.out.println(map); // {zs=zhangsan, ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi}


        // 新加入两个 默认会被放到链表最后面
        map.put("sb", "songba");
        map.put("lj", "laojiu");

        System.out.println(map); // {zs=zhangsan, ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi, sb=songba, lj=laojiu}
    }
}

```



自己实现一个LRU算法

核心看一下重写了父类 `removeEldestEntry` 方法

```java
package com.ilovesshan.day25;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/7/31
 * @description:
 */
public class MyLru<K, V> extends LinkedHashMap<K, V> {

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 什么时候时机开启 将最久没有被访问到的数据淘汰
        return size() > 4;
    }

    public MyLru() {
        super();
    }

    public MyLru(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }


    public static void main(String[] args) {

        Map<String, String> map = new MyLru<>(10, 0.75F, true);

        map.put("zs", "zhangsan");
        map.put("ls", "lisi");
        map.put("ww", "wangwu");
        map.put("zl", "zhaoliu");
        map.put("sq", "sunqi");
        // 由于 removeEldestEntry方法中 当链表长度大于4就删除太久未访问的数据  被删除了"zs=zhangsan"
        System.out.println(map); //{ls=lisi, ww=wangwu, zl=zhaoliu, sq=sunqi}

        // 访问一次zl  看结果将"zl=zhaoliu"放到链表最后面
        map.get("zl");
        System.out.println(map); // {ls=lisi, ww=wangwu, sq=sunqi, zl=zhaoliu}


        // 再访问一次ls  看结果将"ls=lisi"放到链表最后面
        map.get("ls");
        System.out.println(map); // {ww=wangwu, sq=sunqi, zl=zhaoliu, ls=lisi}


        // 新加入两个 默认会被放到链表最后面
        map.put("sb", "songba");
        map.put("lj", "laojiu");

        // “ww=wangwu, sq=sunqi,” 被删除了
        System.out.println(map); // {zl=zhaoliu, ls=lisi, sb=songba, lj=laojiu}
    }
}

```

