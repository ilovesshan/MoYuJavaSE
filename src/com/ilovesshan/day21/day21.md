### JavaSE 摸鱼第21天...

#### 1、synchronization 使用

##### 1.1、为什么使用synchronization

+ 前面学习过java线程争抢的问题、当多个线程去抢夺同一个资源时、会发生难以预估的问题，当时我们使用了一个关键字 `synchronization` 来解决多个线程争抢同一个资源问题。
+ `synchronization` 关键字在 java中 被称为 `元老级别` 的锁，很多人认为这个锁太过于重量级了，但是在 `JDK1.6` 之后，对 `synchronizatio` 进行了优化，有自适应自旋，锁消除，锁粗化，轻量级锁，偏向锁等等，后面讲解 synchronization 锁升级过程和原理。

##### 1.2、synchronization  使用方法

+ `synchronization`  作用于方法上面

  + 1、实例方法：锁的是 `this`
  + 2、静态方法：锁的是 `当前类 class`

  ```java
  public class UseSynchronization {
  
      public synchronized void foo() {
          System.out.println("锁的是 this");
      }
  
      public synchronized static void bar() {
          System.out.println("锁的是 UseSynchronization");
      }
  
  }
  ```

  

+ `synchronization`  作用于代码块上面

  + 传递 `this` 作为 锁
  + 传递 `当前类的.class` 作为 锁
  + 传递 `任意一个对象` 作为 锁

  ```java
  public class UseSynchronization {
      public static final Object MONITOR = new Object();
  
      public void lock() {
  
          // 锁的是 this
          synchronized (this) {
              System.out.println("锁的是 this");
          }
  
          // 锁的是 UseSynchronization
          synchronized (UseSynchronization.class) {
              System.out.println("锁的是 UseSynchronization");
          }
  
          // 锁的是 UseSynchronization成员属性
          synchronized (MONITOR) {
              System.out.println("锁的是 UseSynchronization成员属性");
          }
      }
  }
  ```



##### 1.3、总结

我们使用 `synchronized` 关键字的方法有很多，可以作用与方法上或者代码块上，代码块上又能锁不同的对象。但是万变不离其宗,我们更多的是关注：多线程取访问同一个资源时， 这个锁 是否是同一把锁，只能是同一把锁才能发挥出 `synchronized` 作用，否则无效。



#### 2、synchronization 锁升级过程和原理

##### 2.1、锁升级经历的四个阶段

+ 无锁：
  + 当只有一个线程在访问这个资源时、因为只有一个线程，所以这个资源加不加锁都无所谓。默认情况下，偏向锁是开启的。
+ 无锁到偏向锁：
  + 当线程 `A` 获取到锁时，不会修改对象头，哪怕线程 `A` 以及消亡了，之前加锁的对象头还是保持默认的对象头，这个时候线程 `B` 尝试获取锁时，首先查看 线程`A` 是否还存活，如果不存活，则将对象头清空，恢复成 无所状态再重复 `无锁到偏向锁`的过程，如果 `线程A` 还存活，但是在栈帧信息中该对象已经不需要持有该锁，那么 也会进行一次 `无锁到偏向锁`的过程。
+ 偏向锁到轻量级锁：
  + 紧接着 `无锁到偏向锁` 开始说起、如果线程 `B`尝试获取锁时、发现 线程`A` 还存活并且还持有着这把锁 ，此时线程 `B` 进行cas(乐观锁的一种实现方式)替换失败，会修改对象头，那么此时的锁就会从 `偏向锁到轻量级锁`的升级过程，此时的 线程`B` 会开启自旋模式，不断的自旋尝试去获取锁。
  + 　`java1.6`中，引入了自适应自旋锁，自适应意味着自旋 的次数不是固定不变的，而是根据前一次在同一个锁上自 旋的时间以及锁的拥有者的状态来决定。 如果在同一个锁对象上，自旋等待    刚刚成功获得过锁，并 且持有锁的线程正在运行中，那么虚拟机就会认为这次自 旋也是很有可能再次成功，进而它将允许自旋等待持续相 对更长的时间。

+ 轻量级锁到重量级锁

  + 轻量级锁替换失败次数达到一定数量是(默认10次)，就会从 `轻量级锁到重量级锁`，注意：如果在线程`B` 期间又有线程 `C`来获取锁，那么此时的轻量级锁也会膨胀成重量级锁。
  + 　关于重量级锁，其本质就是操作对象内部的监视器（monitor)

  ![image-20220721221425832](day21.assets/image-20220721221425832.png)

##### 

#### 3、死锁、重入锁

#### 4、notify和wait