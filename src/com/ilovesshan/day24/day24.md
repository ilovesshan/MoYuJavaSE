

### JavaSE 摸鱼第24天...

#### 1、集合家族介绍

##### 1.1、集合介绍

Java集合就像一个容器，可以存储任何类型的数据，也可以结合泛型来存储具体的类型对象。在程序运行时，Java集合可以动态的进行扩展，随着元素的增加而扩大。在Java中，集合类通常存在于java.util包中。

##### 1.3、集合大家族图谱

Java集合主要由2大体系构成，分别是Collection体系和Map体系，其中Collection和Map分别是2大体系中的顶层接口。

Collection主要有三个子接口，分别为List(列表)、Set(集)、Queue(队列)。其中，List、Queue中的元素有序可重复，而Set中的元素无序不可重复。

List中主要有ArrayList、LinkedLis、Vectort三个实现类；Set中则是有HashSet实现类；而Queue是在JDK1.5后才出现的新集合，主要以数组和链表两种形式存在。

Map同属于java.util包中，是集合的一部分，但与Collection是相互独立的，没有任何关系。Map中都是以key-value的形式存在，其中key必须唯一，主要有HashMap、HashTable、treeMap三个实现类。



<img src="day24.assets/image-20220729212855583.png" alt="image-20220729212855583" style="zoom: 67%;" />



#### 2、List、Set、Map接口

##### 2.1、List接口基本使用

`ArrayList`、`LinkedList` 、`Vector` 都实现了 `List` 接口，所以他们三个用法大差不差，特点 `有序可重复`



+ `List`  接口的常用方法：

  ```java
  int size();
  
  boolean isEmpty();
  
  boolean contains(Object o);
  
  Iterator<E> iterator();
  
  Object[] toArray();
  
  <T> T[] toArray(T[] a);
  
  boolean add(E e);
  
  boolean remove(Object o);
  
  boolean containsAll(Collection<?> c);
  
  boolean addAll(Collection<? extends E> c);
  
  boolean addAll(int index, Collection<? extends E> c);
  
  boolean removeAll(Collection<?> c);
  
  boolean retainAll(Collection<?> c);
  
  void clear();
  
  boolean equals(Object o);
  
  int hashCode();
  
  E get(int index);
  
  E set(int index, E element);
  
  void add(int index, E element);
  
  E remove(int index);
  
  int indexOf(Object o);
  
  int lastIndexOf(Object o);
  
  ListIterator<E> listIterator();
  
  ListIterator<E> listIterator(int index);
  
  default void replaceAll(UnaryOperator<E> operator) {
      Objects.requireNonNull(operator);
      final ListIterator<E> li = this.listIterator();
      while (li.hasNext()) {
          li.set(operator.apply(li.next()));
      }
  }
  
  default void sort(Comparator<? super E> c) {
      Object[] a = this.toArray();
      Arrays.sort(a, (Comparator) c);
      ListIterator<E> i = this.listIterator();
      for (Object e : a) {
          i.next();
          i.set((E) e);
      }
  }
  ```

  

+ `ArrayList`

  ```java
  package com.ilovesshan.day24;
  
  import java.util.ArrayList;
  import java.util.List;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/29
   * @description: List接口  ArrayList 基本使用
   */
  public class UseArrayList {
      public static void main(String[] args) {
  
          // ArrayList 基本使用
          List<String> list = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list2.add("1");
          list2.add("2");
  
          // 演示 C R U D
          list.add("a");
          list.add("b");
          list.add("c");
          list.addAll(1, list2);
  
  
          for (String s : list) {
              System.out.print(s);
          }
          System.out.println(); // a12bc
  
  
          list.set(0, "A");
  
  
          list.remove(4);
  
  
          for (int i = 0; i < list.size(); i++) {
              System.out.print(list.get(i));
          }
          System.out.println(); // A12b
  
      }
  }
  ```

  

+ `LinkedList`

  ```java
  package com.ilovesshan.day24;
  
  import java.util.LinkedList;
  import java.util.List;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/29
   * @description: List接口  LinkedList 基本使用
   */
  public class UseLinkedList {
      public static void main(String[] args) {
  
          //ArrayList 基本使用
          List<String> list = new LinkedList<>();
          List<String> list2 = new LinkedList<>();
          list2.add("1");
          list2.add("2");
  
          // 演示 C R U D
          list.add("a");
          list.add("b");
          list.add("c");
          list.addAll(1, list2);
  
  
          for (String s : list) {
              System.out.print(s);
          }
          System.out.println(); // a12bc
  
  
          list.set(0, "A");
  
  
          list.remove(4);
  
  
          for (int i = 0; i < list.size(); i++) {
              System.out.print(list.get(i));
          }
          System.out.println(); // A12b
  
      }
  }
  
  ```

  

+ Vector

  ```java
  package com.ilovesshan.day24;
  
  import java.util.List;
  import java.util.Vector;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/29
   * @description: List接口  Vector 基本使用
   */
  public class UseVector {
      public static void main(String[] args) {
  
          //ArrayList 基本使用
          List<String> list = new Vector<>();
          List<String> list2 = new Vector<>();
          list2.add("1");
          list2.add("2");
  
          // 演示 C R U D
          list.add("a");
          list.add("b");
          list.add("c");
          list.addAll(1, list2);
  
  
          for (String s : list) {
              System.out.print(s);
          }
          System.out.println(); // a12bc
  
  
          list.set(0, "A");
  
  
          list.remove(4);
  
  
          for (int i = 0; i < list.size(); i++) {
              System.out.print(list.get(i));
          }
          System.out.println(); // A12b
  
      }
  }
  
  ```

  

##### 2.2、Set基本使用

`HashSet`、`ThreeSet(继承AbstractSet，AbstractSet实现Set)` 接口，间接性都实现了 `Set` 接口，特点 `无序 不重复`



+ `HashSet`和`ThreeSet` 用法差不多，下面演示 `UseHashSet`

  ```java
  package com.ilovesshan.day23;
  
  import java.util.HashSet;
  import java.util.Iterator;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/29
   * @description: HashSet基本使用
   */
  public class UseHashSet {
      public static void main(String[] args) {
          HashSet<String> hashSet = new HashSet<>();
  
          // 添加元素
          hashSet.add("5");
          hashSet.add("4");
          hashSet.add("5");
          hashSet.add("3");
          hashSet.add("2");
          hashSet.add("1");
          hashSet.add("0");
          hashSet.add("a");
          hashSet.add("a");
          hashSet.add("b");
          hashSet.add("c");
          hashSet.add("d");
          hashSet.add("e");
          hashSet.add("f");
  
          // 无序 不重复
          System.out.println(hashSet); // [0, 1, a, 2, b, 3, c, 4, d, 5, e, f]
  
  
          hashSet.remove("a");
          hashSet.remove("5");
  
          System.out.println(hashSet); // [0, 1, 2, b, 3, c, 4, d, e, f]
  
  
          // 长度
          System.out.println(hashSet.size()); // 10
  
          // 使用 Iterator 遍历
          Iterator<String> iterator = hashSet.iterator();
          while (iterator.hasNext()) {
              System.out.println(iterator.next());
          }
      }
  }

##### 2.3、Map基本使用

`Map`又称为 `映射`，由 `A` 映射到 `B`，好比读小学做的连线题一样，`Map` 的数据的存储结构是键值对(Key:Value)的形式。

`HashMap`、`TreeMap继承AbstractMap，AbstractMap实现Map`、`Hashtable` 都实现了 `Map`接口。

`Map`再进行插入数据时、如果 key相同时、后面的会覆盖前面的



+ 演示 `HashMap` 的用法

  ```java
  package com.ilovesshan.day24;
  
  import com.ilovesshan.day24.entity.User;
  
  import java.util.*;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/29
   * @description: HashMap 基本使用
   */
  public class UseHashMap {
  
      public static void main(String[] args) {
          HashMap<String, User> hashMap = new HashMap<>();
          TreeMap<String, User> treeMap = new TreeMap<>();
          Hashtable<String, User> hashtable = new Hashtable<>();
  
  
          // 插入数据 key相同时、后面的会覆盖前面的
          hashMap.put("u1", new User("u1", "u1!@#"));
          hashMap.put("u2", new User("u2", "u2!@#"));
          hashMap.put("u3", new User("u1", "u3!@#"));
          hashMap.put("u2", new User("u1", "u4!@#"));
  
  
          // 根据Key获取Value
          User user = hashMap.get("u2");
          System.out.println(user); // User{username='u1', password='u4!@#'}
  
  
          // 删除元素
          hashMap.remove("u1");
  
          // 长度
          System.out.println("hashMap.size() = " + hashMap.size()); // hashMap.size() = 2
  
          // 获取所有的value
          Collection<User> values = hashMap.values();
          System.out.println("values = " + values); // values = [User{username='u1', password='u4!@#'}, User{username='u1', password='u3!@#'}]
  
          // 获取所有的Key
          Set<String> keys = hashMap.keySet();
          System.out.println("keys = " + keys); // keys = [u2, u3]
  
  
      }
  }
  
  
  
  Connected to the target VM, address: '127.0.0.1:61875', transport: 'socket'
      
  User{username='u1', password='u4!@#'}
  hashMap.size() = 2
  values = [User{username='u1', password='u4!@#'}, User{username='u1', password='u3!@#'}]
  keys = [u2, u3]
  Disconnected from the target VM, address: '127.0.0.1:61875', transport: 'socket'
  
  Process finished with exit code 0
      
  
  ```

  



#### 3、List接口源码

##### 3.1、ArrayList 源码分析

+ **成员属性**

  

  ```java
  // 默认容量
  private static final int DEFAULT_CAPACITY = 10;
  
  // 空元素
  private static final Object[] EMPTY_ELEMENTDATA = {};
  
  // 默认空元素
  private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  
  // 存放数据的数组
  transient Object[] elementData;
  
  // 数组长度
  private int size;
  ```

  

+ **构造器 主要有三个构造器**

  

  ```java
  // initialCapacity 初始化容量
  public ArrayList(int initialCapacity) {
      if (initialCapacity > 0) {
          this.elementData = new Object[initialCapacity];
      } else if (initialCapacity == 0) {
          this.elementData = EMPTY_ELEMENTDATA;
      } else {
          throw new IllegalArgumentException("Illegal Capacity: "+  initialCapacity);
      }
  }
  
  ```

  ```java
  public ArrayList() {
      this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }
  ```

  ```java
  public ArrayList(Collection<? extends E> c) {
      elementData = c.toArray();
      if ((size = elementData.length) != 0) {
          // c.toArray might (incorrectly) not return Object[] (see 6260652)
          if (elementData.getClass() != Object[].class)
              elementData = Arrays.copyOf(elementData, size, Object[].class);
      } else {
          // replace with empty array.
          this.elementData = EMPTY_ELEMENTDATA;
      }
  }
  
  ```

  

+ **`add` 两个重载方法**

  

  插入元素

  ```java
  public boolean add(E e) {
      ensureCapacityInternal(size + 1);  // Increments modCount!!
      elementData[size++] = e;
      return true;
  }
  
  ```

  

  指定位置插入元素

  ```java
  public void add(int index, E element) {
      rangeCheckForAdd(index);
      ensureCapacityInternal(size + 1);  // Increments modCount!!
      System.arraycopy(elementData, index, elementData, index + 1,  size - index);
      elementData[index] = element;
      size++;
  }
  
  ```

  

+ **`ensureCapacityInternal` 方法处理 是否需要扩容**

  

  ```java
  // 2 计算容量(取elementData 和 minCapacity的最大值)
  private static int calculateCapacity(Object[] elementData, int minCapacity) {
      if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
          return Math.max(DEFAULT_CAPACITY, minCapacity);
      }
      return minCapacity;
  }
  
  
  
  // 1 计算出内部数据需要的容量
  // minCapacity 最小容量
  private void ensureCapacityInternal(int minCapacity) {
      ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
  }
  
  
  
  // 3 调用 grow 方法进行扩容
  private void ensureExplicitCapacity(int minCapacity) {
      modCount++;
      // 确实需要扩容了 可以这样理解(elementData.length - minCapacity < 0)
      if (minCapacity - elementData.length > 0) grow(minCapacity);
  }
  ```



+ **`grow`** 具体的扩容实现方法

  

  ```java
  private void grow(int minCapacity) {
      
      int oldCapacity = elementData.length;
      
      // oldCapacity >> 1  相当于oldCapacity除以2   
      int newCapacity = oldCapacity + (oldCapacity >> 1);
     
     
      // 满足条件,第一次扩容时：
      // newCapacity = elementData.length + elementData.length / 2 = 0
      // minCapacity = size + 1 = 1
      // newCapacity - minCapacity < 0 ==>  0 - 1 < 0  推断成功
      if (newCapacity - minCapacity < 0) 
          // newCapacity = 1
          newCapacity = minCapacity;
      
      
      //  private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
      
      if (newCapacity - MAX_ARRAY_SIZE > 0)  
          // 此时需要扩的容量已经超级大了 需要特殊方法处理 hugeCapacity
          newCapacity = hugeCapacity(minCapacity);
     
      
      // 数组拷贝 elementData老元素 newCapacity新的容量
      elementData = Arrays.copyOf(elementData, newCapacity);
  }
  ```

  

  分析一下：`if (newCapacity - MAX_ARRAY_SIZE > 0) ` 写法

  ```java
  int oldCapacity = Integer.MAX_VALUE - 8;
  int newCapacity = oldCapacity + 500;
  
  System.out.println("oldCapacity = " + oldCapacity); // 2147483639
  // 超出int的范围了，直接变成负数
  System.out.println("newCapacity = " + newCapacity);  // -2147483157
  
  System.out.println(newCapacity - 1000);  // 2147483139
  
  // 两种写法 得到了两种不同结果
  System.out.println(newCapacity - 1000 > 0); // true
  System.out.println(newCapacity > 1000); //false
  
  ```

+ `hugeCapacity` **方法** 

  

  ```java
  private static int hugeCapacity(int minCapacity) {
      // overflow  数据容量已经大于 MAX_ARRAY_SIZE 直接提示OOM
      if (minCapacity < 0) throw new OutOfMemoryError();
      
      // 这里可以知道 ArrayList 数组容量最长是: Integer.MAX_VALUE
      return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
  }
  ```

  

##### 3.2、LinkedList 源码分析

`LinkedList` 底层维护了一个双向链表，通过一类内部类 `Node` 将其关联起来。

+ **成员变量**

  ```java
  transient int size = 0;
  transient Node<E> first;
  transient Node<E> last;
  ```



+ **2个构造方法**

  ```java
  // 无参构造
  public LinkedList() {
  }
  
  
  // 可传入一个 实现Collection接口类
  public LinkedList(Collection<? extends E> c) {
      this();
      addAll(c);
  }
  ```



+ **add方法( 头插、尾插)**

  ```java
  public boolean add(E e) {
      linkLast(e);
      return true;
  }
  ```

  

  ```java
  // 头插
  public void addFirst(E e) {
      linkFirst(e);
  }
  
  
  private void linkFirst(E e) {
      final Node<E> f = first;
      final Node<E> newNode = new Node<>(null, e, f);
      first = newNode;
      if (f == null)
          last = newNode;
      else
          f.prev = newNode;
      size++;
      modCount++;
  }
  
  ```

  ```java
  
  // 尾插
  public void addLast(E e) {
      linkLast(e);
  }
  
  
  void linkLast(E e) {
      final Node<E> l = last;
      final Node<E> newNode = new Node<>(l, e, null);
      last = newNode;
      if (l == null)
          first = newNode;
      else
          l.next = newNode;
      size++;
      modCount++;
  }
  ```

  

  **remove方法**

  

  ```java
  public E remove(int index) {
      // 校验 index
      checkElementIndex(index);
      
      // 根据Index获取元素 进行unlink
      return unlink(node(index));
  }
  
  
  E unlink(Node<E> x) {
      // assert x != null;
      final E element = x.item;
      final Node<E> next = x.next;
      final Node<E> prev = x.prev;
  
      if (prev == null) {
          first = next;
      } else {
          prev.next = next;
          x.prev = null;
      }
  
      if (next == null) {
          last = prev;
      } else {
          next.prev = prev;
          x.next = null;
      }
  
      x.item = null;
      size--;
      modCount++;
      return element;
  }
  
  
  ```

  

  ```java
  
  public E removeFirst() {
      final Node<E> f = first;
      if (f == null)  throw new NoSuchElementException();
      return unlinkFirst(f);
  }
  
  
  
  private E unlinkFirst(Node<E> f) {
      // assert f == first && f != null;
      final E element = f.item;
      final Node<E> next = f.next;
      f.item = null;
      f.next = null; // help GC
      first = next;
      if (next == null)
          last = null;
      else
          next.prev = null;
      size--;
      modCount++;
      return element;
  }
  
  ```

  

  

  ```java
  public E removeLast() {
      final Node<E> l = last;
      if (l == null)   throw new NoSuchElementException();
      return unlinkLast(l);
  }
  
  
  private E unlinkLast(Node<E> l) {
      // assert l == last && l != null;
      final E element = l.item;
      final Node<E> prev = l.prev;
      l.item = null;
      l.prev = null; // help GC
      last = prev;
      if (prev == null)
          first = null;
      else
          prev.next = null;
      size--;
      modCount++;
      return element;
  }
  ```

  

#### 4、Set接口源码

`HashSet` 底层本质就是使用 `HashMap`做了一层封装.

`HashSet` 不能保证元素的顺序，元素是无序的。

**可以通过`HashSet`构造函数看出来**

```java
public HashSet() {
    map = new HashMap<>();
}


public HashSet(Collection<? extends E> c) {
    map = new HashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
    addAll(c);
}


public HashSet(int initialCapacity, float loadFactor) {
    map = new HashMap<>(initialCapacity, loadFactor);
}


public HashSet(int initialCapacity) {
    map = new HashMap<>(initialCapacity);
}

```



**`HashSet`部分方法源码**

其实可以看得出来，`HashSet` 底层源码表面上不是太复杂，都是同过调用被封装一层的`HashMap` 的方法，学习 `HashSet`主要是得学习 `HashMap`，`HashMap` 搞定那么 `HashSet` 自然就OK了。

```java
// 返回Set长度
public int size() {
    return map.size();
}

// 是否是空
public boolean isEmpty() {
    return map.isEmpty();
}

// 是否包含某个元素
public boolean contains(Object o) {
    return map.containsKey(o);
}

// 添加元素 
public boolean add(E e) {
    return map.put(e, PRESENT)==null;
}

// 移除元素
public boolean remove(Object o) {
    return map.remove(o)==PRESENT;
}

// 清空元素
public void clear() {
    map.clear();
}
```



#### 5、HashMap源码



##### 5.1、HashMap源码存储过程

+ hashMap据存储结构

![image-20220731120111470](day24.assets/image-20220731120111470.png)



+ hashMap存储过程(大概)

​	第一步：`HashMap`会生成一个长度为16的hash表(hashTable)，用来存放数据。

​	第二步：第一次向`HashMap` 中插入数据时、会根据 `Key`计算 对应的 `HashCode`。

​		模拟一下计算的过程(真实的算计并不是这样)，通过key得到一个hashCode，再用hashCode除16取余。

​		取到的余数是一个 `1 - 15`之间的数，正好就对应了hash表的下标。得到下标之后，就能够确定一个槽位来存放数据。

​	第三步：槽位确定之后，封装一个`Node` 节点用来保存数据，里面存放了 hash值、`key`、`value`、`next`。

​	第四步：在下一次添加数据时、如果发现槽位已经有数据了，那么数据就会用链表的形式存储，这种现象也叫hash碰撞。

​	第五步：当链表长度大于8并且hashTable的长度等于64，hashTable就会进行树化，转成红黑树。



##### 5.2、HashMap重要点总结

+ hashMap的key可以为 `null`吗？

  ```java
  // 调用 put方法时
  public V put(K key, V value) {
      return putVal(hash(key), key, value, false, true);
  }
  
  // hashMap的key可以为null, 为null 返回0
  static final int hash(Object key) {
      int h;
      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
  ```

​		

+ hashMap的key的hash怎么计算?

  ```java
  static final int hash(Object key) {
      int h;
      return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
  ```

  

+ hashMap的hash表什么情况下会扩容?

  

  1、第一次调用`put` 方法时

  ```java
  public V put(K key, V value) {
      return putVal(hash(key), key, value, false, true);
  }
  
  final V putVal(int hash, K key, V value, boolean onlyIfAbsent,  boolean evict) {
      Node<K,V>[] tab; Node<K,V> p; int n, i;
      if ((tab = table) == null || (n = tab.length) == 0)
          // 调用 resize() 扩容
          n = (tab = resize()).length;
      if ((p = tab[i = (n - 1) & hash]) == null)
          tab[i] = newNode(hash, key, value, null);
      
      // 省略剩余代码 ....
  }
  ```

  

  2、调用 `treeifyBin` 进行树化

  ```java
  final void treeifyBin(Node<K,V>[] tab, int hash) {
      int n, index; Node<K,V> e;
      if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
          // 调用 resize() 扩容
          resize();
      else if ((e = tab[index = (n - 1) & hash]) != null) {
          TreeNode<K,V> hd = null, tl = null;
          do {
              TreeNode<K,V> p = replacementTreeNode(e, null);
              if (tl == null)
                  hd = p;
              else {
                  p.prev = tl;
                  tl.next = p;
              }
              tl = p;
          } while ((e = e.next) != null);
          if ((tab[index] = hd) != null)
              hd.treeify(tab);
      }
  }
  ```

  

  3、当hashTable长度大于阈值时、会扩容

  ```java
  final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
      int s = m.size();
      // 省略剩余代码 ....
      else if (s > threshold)
          resize();
      // 省略剩余代码 ....
  }
  
  
  
  // 省略剩余代码 ....
  if (size > threshold || (tab = table) == null ||  (n = tab.length) == 0){
      n = (tab = resize()).length;
  }
  // 省略剩余代码 ....
  ```



​		

+ hashMap中什么时候会树化?

  当链表长度大于8并且hashTable的长度等于64

  

+ 为什么选择0.7为负载因子，8为树化阈值?

  + 0.7为负载因子原因：

    加载因子是哈希表在其容量自动增加之前可以达到多满的一种尺度，它衡量的是一个散列表的空间的使用程度，负载因子越大表示散列表的装填程度越高，反之愈小，如果你看过源代码，你会发现在初始条件下，HashMap在时间和空间两者间折中选择了0.75。

    ```java
    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    ```

    

+ 选择8为树化阈值原因：

  + 泊松分布是最重要的离散分布之一，它多出现在当X表示在一定的时间或空间内出现的事件个数这种场合。	

    

    源码：

    ```java
    * rarely used.  Ideally, under random hashCodes, the frequency of
    * nodes in bins follows a Poisson distribution
    * (http://en.wikipedia.org/wiki/Poisson_distribution) with a
    * parameter of about 0.5 on average for the default resizing
    * threshold of 0.75, although with a large variance because of
    * resizing granularity. Ignoring variance, the expected
    * occurrences of list size k are (exp(-0.5) * pow(0.5, k) /
    * factorial(k)). The first values are:
    *
    * 0:    0.60653066
    * 1:    0.30326533
    * 2:    0.07581633
    * 3:    0.01263606
    * 4:    0.00157952
    * 5:    0.00015795
    * 6:    0.00001316
    * 7:    0.00000094
    * 8:    0.00000006
    * more: less than 1 in ten million
    ```

​				翻译过来说的是，在理想情况下,使用随机哈希码，节点出现的频率在 hash 桶中遵循泊松分布。对照桶中元素个数和概率的		表，可以看到当用 0.75 作为加载因子时，桶中元素到达 8 个的时候，概率已经变得非常小，因此每个碰撞位置的 链表长度超过 8     		个是几乎不可能的，因此在链表节点到达 8 时才开始转化为红黑树。
