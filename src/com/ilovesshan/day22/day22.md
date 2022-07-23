### JavaSE 摸鱼第22天...

##### 1、并发编程的三大特征

##### 1.1、原子性

将一个或者多个操作视为一个整体，要么不执行，要么全部执行完毕，在执行的中途不能被其他线程的调度机制所打断，而这种操作一旦开始就必须执行结束，中间不会有任何的上下文切换。

##### 1.2、可见性

在java的内存模型章节有了解到：缓存行数据引发的数据可见性，而解决可见性问题可以通过添加关键字 `volatile` 。

##### 1.3、有序性

在java的内存模型章节也有了解到：有序性(就是指令重排的问题)，通过添加内存屏障(添加关键字 `volatile` )来解决读写时指令重排。

内存屏障可以简单理解：在一次读写操作之前加一条指令，当cpu碰到这条指令时、必须等到前面的指令执行完才能执行后面的指令。

##### 1.4、synchronization和volatile 区别

`synchronization` 关键字：可以保证：原子性、可见性、有序性。

`volatile` 关键字：只能保证：可见性、有序性，不能保证原子性。



##### 2、 证明volatile不具备原子性

+ 下面这段代码，貌似每次执行的结果都是 `500`，这也许只是碰巧，因为线程执行的速度很快，并没有造成堵塞。

  ```java
  public class VolatileTest {
      private static volatile int count = 0;
  
      public static void main(String[] args) throws InterruptedException {
          for (int i = 0; i < 500; i++) {
              // 创建500个线程 每次进行count+1
              new Thread(() -> count++).start();
          }
  
          // 睡2s 查看结果
          Thread.sleep(2000);
  
          System.out.println("count= " + count);
  
      }
  }
  
  
  
  Connected to the target VM, address: '127.0.0.1:52966', transport: 'socket'
  count= 500
  Disconnected from the target VM, address: '127.0.0.1:52966', transport: 'socket'
  
  Process finished with exit code 0
  ```

  

+ 下面我们将代码改造一下，线程创建完成后，不立马改变 `count`，睡10毫秒再改变。

+ 可以看到最终的 `count` 并不是500，貌似加了 `volatile` 关键字也没有保证到原子性。

+ 主要产生的原因是：每个线程都会睡10毫秒，这个睡的过程并不是每个线程排队睡，而是创建了的线程一起睡，10ms之后，大量线程会并发的去修改这个count，但是就是这一瞬间 并不能保证谁先获取谁先修改count再刷回缓存里面。

  ```java
  public class VolatileTest {
      private static volatile int count = 0;
  
      public static void main(String[] args) throws InterruptedException {
          for (int i = 0; i < 500; i++) {
              // 创建500个线程 每次进行count+1
              new Thread(() -> {
                  try {
                      Thread.sleep(10);
                      count++;
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }).start();
          }
  
          // 睡2s 查看结果
          Thread.sleep(2000);
  
          System.out.println("count= " + count);
  
      }
  }
  
  
  Connected to the target VM, address: '127.0.0.1:52999', transport: 'socket'
  count= 488
  Disconnected from the target VM, address: '127.0.0.1:52999', transport: 'socket'
  
  Process finished with exit code 0
  
  ```

  



##### 3、 Lock锁原理-cas和aqs

##### 3.1、cas

##### 3.2、aqs

##### 4、公平锁和非公平锁区别

##### 5、lock和tryLock区别

