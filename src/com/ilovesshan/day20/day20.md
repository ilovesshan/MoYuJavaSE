### JavaSE 摸鱼第20天...

#### 1、进程、线程、上下文切换

[关于进程、线程博客地址](!https://www.cnblogs.com/jiuxing/p/14098911.html)

##### 1.1、进程

+ 进程可以看作是程序的执行过程。一个程序的运行需要CPU时间、内存空间、文件以及I/O等资源。操作系统就是以进程为单位来分配这些资源的，所以说进程是分配资源的基本单位。
+ 进程是动态的，程序是静态的。
+ 程序与进程并不是一 一对应的关系。
  + 一个程序产生一个进程
  + 一个程序产生多个进程
  + 个程序可以被多个进程共用
  + 一个进程又可能要用到多个程序

##### 1.2、线程

+ 线程从属于进程，只能在进程的内部活动，多个线程共享进程所拥有的的资源。如果把进程看作是完成许多功能的任务的集合，那么线程就是集合中的一个任务元素，负责具体的功能。虽然CPU、内存、I/O等资源分配给了进程，但实际上真正利用这些资源并在CPU上执行的却是线程，即真正完成程序功能的是线程。

  ![image-20220714205809873](day20.assets/image-20220714205809873.png)

+ 现代很多操作系统支持让一个进程包含 多个线程，从而提高程序的并行程度和资源的利用率。

##### 1.3、上下文切换

##### 1.4、线程和进程关系

+ 一个进程可以有多个线程，但至少要有一个线程，并且一个线程只能在一个进程的地址空间内活动。
+ 资源分配给进程，而一个进程内的所有线程共享该进程的所有资源。
+ CPU分配给的是线程，即真正在CPU上运行的是线程。
+ 进程间通信较为复杂，同一台计算机的进程通信称为 IPC（Inter-	process communication）。而不同计算机之间的进程通信，则需要通过网络，并遵守共同的协议，例如 HTTP等。
+ 线程通信相对简单，因为它们共享进程内的内存，一个例子是多个线程可以访问同一个共享变量。
+ 线程更轻量，线程上下文切换成本一般上要比进程上下文切换低。

#### 2、创建线程的几种方式

##### 2.1、继承 `Thread` 类  

+ 继承 `Thread` 类、重写 `run` 方法。
+ 创建一个线程实例、并调用实例的`start`方法 ，注意是 `start`方法不是 `run`方法。

```java
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("继承Thread类, 开启的子线程...");
    }
}
```

```java
public class CreateMultithreading {
    public static void main(String[] args) {
        System.out.println(1);
        
        // 创建一个线程实例、并调用 start()方法 ，注意是 start方法 不是 run方法
        new MyThread1().start();
        
        System.out.println(2);
    }
}

看执行结果：有由此可见，确实开启了一个新的线程
1
2
继承Thread类, 开启的子线程...
```



##### 2.2、实现 `Runnable`接口

+ 实现 `Runnable`接口、重写 `run` 方法。
+  注意我们创建了 一个实现Runnable接口的类的实例, 但是这个实例身上没有  start方法，那怎么开启子线程呢？
+  通过创建一个 Thread类实例, 来帮助我们创建子线程。
+ 将实现Runnable接口的类的实例作为构造参数传进去， 紧接着调用这个实例start方法就ok了。

```java
class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("实现Runnable接口, 开启的子线程...");
    }
}

```

```java
public class CreateMultithreading {
    public static void main(String[] args) {

       // 注意我们创建了 一个实现Runnable接口的类的实例, 但是这个实例身上没有  start方法，那怎么开启子线程呢？
        // 通过创建一个 Thread类实例, 来帮助我们创建子线程。
        // Runnable接口的类的实例作为构造参数传进去，接着调用这个实例start方法就ok了
        
        System.out.println(1);
        MyThread2 myThread2 = new MyThread2();
        new Thread(myThread2).start();
        System.out.println(2);
    }
}

看执行结果：有由此可见，确实开启了一个新的线程
1
2
实现Runnable接口, 开启的子线程...

```

##### 2.3、创建线程的知识点补充

+ 当 `main` 方法运行时、会有一个主线程负责从上往下执行代码，遇到创建多线程时、代码并不会阻塞(特殊情况)、而是继续往下执行。

+ 主线和和创建的子线程执行先后关系：

  + 没有先后的说法、主要是看 `cpu` 来如何调度。
  + 也可以通过一些特殊办法、来将线程`挂起`、`休眠`、`让步` 等等操作、来达到想要的调用。

+ 开启线程时、注意是调用 `start` 方法、而不是 `run` 方法, 调用`run` 方法那么`jvm`就会当作调用普通方法一样处理、并不会开启多线程。

  + `Thread` 类 也是实现了 `Runnable` 接口的、

  + `Thread` 类中 有一个 `start()` 方法、这个 `start()` 方法 内部调用了 `start0()` 方法

  +  `start0()` 方法是一个本地 方法，`private native void start0();`

    ![image-20220714215215324](day20.assets/image-20220714215215324.png)

  ```java
  public class InvokeInstanceRun {
      public static void main(String[] args) {
          for (int i = 0; i < 10; i++) {
              System.out.println(Thread.currentThread().getName() + "=>" + i);
              if (i == 0) {
                  // 开启子线程
                  MyThread thread = new MyThread();
                  thread.start();
              }
          }
      }
  }
  
  class MyThread extends Thread {
      @Override
      public void run() {
          for (int i = 0; i < 10; i++) {
              System.out.println(Thread.currentThread().getName() + "=>" + i);
          }
      }
  }
  ```

  + 调用 `start` 方法得到的结果：可以看到是代码交替执行的，那么具体执行循序取决于 `CPU`

    ```java
    Connected to the target VM, address: '127.0.0.1:58939', transport: 'socket'
    main=>0
    main=>1
    main=>2
    main=>3
    main=>4
    main=>5
    main=>6
    main=>7
    Thread-0=>0
    main=>8
    main=>9
    Thread-0=>1
    Thread-0=>2
    Thread-0=>3
    Thread-0=>4
    Thread-0=>5
    Thread-0=>6
    Thread-0=>7
    Thread-0=>8
    Thread-0=>9
    Disconnected from the target VM, address: '127.0.0.1:58939', transport: 'socket'
    
    Process finished with exit code 0
    ```

    

  + 调用 `run` 方法得到的结果：可以看到是由上往下执行的，所所以 调用 `run` 并不会开启多线程。

    ```java
    Connected to the target VM, address: '127.0.0.1:58965', transport: 'socket'
    main=>0
    main=>0
    main=>1
    main=>2
    main=>3
    main=>4
    main=>5
    main=>6
    main=>7
    main=>8
    main=>9
    main=>1
    main=>2
    main=>3
    main=>4
    main=>5
    main=>6
    main=>7
    main=>8
    main=>9
    Disconnected from the target VM, address: '127.0.0.1:58965', transport: 'socket'
    ```

    

+ 通过 实现 `Runnable`接口 创建多线程时：

  + 可以通过匿名内部类和箭头函数来创建子线程、代码更加简洁。
  + `Runnable` 本身也是一个函数式接口。

  ```java
  public class CreateMultithreading {
      public static void main(String[] args) {
          // 通过匿名内部类和箭头函数来创建子线程
          new Thread(new Runnable() {
              @Override
              public void run() {
                  System.out.println("通过匿名内部类和箭头函数来创建子线程");
              }
          }).start();
      }
  }
  ```

  

#### 3、创建有返回值线程

+ 实现`Callable`接口, 并且需要实现 `call()`方法。
+ `Callable` 接口 需要传入一个泛型 这个泛型类型就是`call`方法(要返回的数据)的返回值类型。
+ 创建实现了`Callable`接口的类的实例。
+ 通过 `FutureTask` 来管理这个实例。
+ 开启线程 调用 `futureTask.run()` 。
+ `futureTask.get()` 方法获取返回值、注意 get() 方法会阻塞代码向下执行 会抛出异常。

```java
public class CreateHasReturnedThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(1);
        System.out.println(2);
        // 创建 实例
        HasReturnedThread hasReturnedThread = new HasReturnedThread();
        // 通过 FutureTask 来管理这个实例
        FutureTask<Integer> futureTask = new FutureTask<>(hasReturnedThread);
        // 开启线程
        futureTask.run();
        // 注意 get() 方法会阻塞代码向下执行 会抛出异常
        Integer value = futureTask.get();
        System.out.println(value);
        System.out.println(4);
        System.out.println(3);

    }
}

// 实现Callable接口, 并且需要实现 call()方法
// Callable 接口 需要传入一个泛型 这个泛型类型就是 all方法(你要返回的数据)的返回值类型
class HasReturnedThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 3;
    }
}


打印结果:

Connected to the target VM, address: '127.0.0.1:59131', transport: 'socket'
1
2
3
4
3
Disconnected from the target VM, address: '127.0.0.1:59131', transport: 'socket'

Process finished with exit code 0

```



#### 4、多线程异步和效率

+ 通过单线程和多线程两种方式，来计算 `1~10000000` 的和，感受一下他们的区别。

  ```java
  package com.ilovesshan.day20;
  
  import java.util.concurrent.Callable;
  import java.util.concurrent.ExecutionException;
  import java.util.concurrent.FutureTask;
  
  public class CalculateNumberTotal {
      public static void main(String[] args) throws ExecutionException, InterruptedException {
          long total = 0;
          long maxNum = 10000000;
          
          // 单线程方式
          long startTime = System.currentTimeMillis();
  
          for (int i = 0; i < maxNum; i++) {
              total += i;
          }
          long endTime = System.currentTimeMillis();
  
          System.out.println("单线程方式   计算1~" + maxNum + "总和是: " + total + ", 耗时: " + (endTime - startTime));
  
  
          // 多线程方式
          total = 0;
          startTime = System.currentTimeMillis();
  
          FutureTask[] futureTasks = new FutureTask[10];
  
          for (int i = 0; i < futureTasks.length; i++) {
              FutureTask<Long> futureTask = new FutureTask<>(new CalculateNumber(i * 10000000, (i + 1) * 10000000));
              futureTask.run();
              futureTasks[i] = futureTask;
          }
  
          for (int i = 0; i < futureTasks.length; i++) {
              Long result = (Long) futureTasks[i].get();
              total += result;
          }
  
          endTime = System.currentTimeMillis();
          System.out.println("多线程方式   计算1~" + maxNum + "总和是: " + total + ", 耗时: " + (endTime - startTime));
      }
  }
  
  
  
  class CalculateNumber implements Callable<Long> {
      int start;
      int end;
  
      public CalculateNumber() {
      }
  
      public CalculateNumber(int start, int end) {
          this.start = start;
          this.end = end;
      }
  
      @Override
      public Long call() throws Exception {
          long result = 0L;
          for (int i = start; i < end; i++) {
              result += i;
          }
          return result;
      }
  }
  
  计算结果:    单线程比多线程快??? 哈哈哈，不知道怎么回事了~~~
      
  Connected to the target VM, address: '127.0.0.1:59554', transport: 'socket'
  单线程方式   计算1~10000000总和是: 49999995000000, 耗时: 13
  多线程方式   计算1~10000000总和是: 4999999950000000, 耗时: 80
  Disconnected from the target VM, address: '127.0.0.1:59554', transport: 'socket'
  
  Process finished with exit code 0
  
  ```
  
  

#### 5、守护线程

##### 1、守护线程  和 用户线程

+  java中线程分为两类：`守护线程`和`用户线程`

+ 守护线程(daemon thread) 又被称为 "服务进程、精灵线程、后台线程" ， 它是个服务线程，一般在后台默默的为我们提供一些服务比如：
  +  java的垃圾回收机制。
  + 敲代码时，idea提供的语法提示、语法监测等等。
+ 用户线程 用户自定义的线程。
+ 守护线程 一般会默默的为用户线程服务，在java中 任何一个守护线程都是jvm中 整个非守护线程的保姆，通俗易懂点：
  + 在`用户线程`执行完毕后，main线程就会跟着结束、`main`结束之后那么 `jvm` 也就退出来了，紧接着 `守护线程`也就结束了，
  + 如果说：用户线程还没结束的情况下，那么 `守护线程` 是不会退出的，因为：`守护线程`还需要负责回收垃圾啊~

##### 2、设置一个线程为守护线程

+ `t.setDaemon(true)` 即可设置 `t` 线程为守护线程。

```java
package com.ilovesshan.day20;

public class SetDaemonThread {
    public static void main(String[] args) {

        System.out.println("mian----");

        Thread t1 = new Thread(() -> {
            Thread t2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println("t2---" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束----");
            });
            // 将 t2 线程设置成 t1的守护线程, 即t1结束 那么t2 就结束
            t2.setDaemon(true);

            t2.start();

            for (int i = 0; i < 5; i++) {
                System.out.println("t1---" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1结束----");


        });


        // 将 t1 线程设置成 main的守护线程, 即main结束 那么t1 就结束
        // t1.setDaemon(true);

        t1.start();


    }
}

```



#### 6、线程生命周期

##### 6.1、生命周期概念

+ 生命周期就好比一个人的一生，从 `出生` 到 `成人 `到 `结婚生子`  到 `晚年享福`  到 离世 的一个过程。 
+ 那么 线程也有自己的生命周期，从一个线程被创建开始 到 线程的结束，中间会经历很多种状态，那么这一系列的状态结合起来，我们就称之为 `线程的生命周期`。

##### 6.2、线程生命周期节点

+ `new`：线程被创建的初期，还没有调用 `start` 方法。

+ `runnable`：线程被调用 `start`方法之后，进入 `就绪` 状态，有可能由于某些条件导致该线程不能立即执行，原因有可能被其他线程所阻塞，也有可能该线程处于一个无限等待状态，那么具体的执行时机还是需要 `操作系统`来进行调度的。

+ `locked`：线程处于阻塞状态(一般是被动的阻塞，例如：10线程去访问一个资源，这个资源同时只允许一个线程访问，那么剩下的9个线程只能排队等，这个 `等`的状态 就是`locked`)。

+ `waiting`：处于一个无限等待状态(一般是主动的等，例如：`A线程`先执行，`A线程`执行了一会，发现需要`B线程`携带的数据，那么`A线程` 就只能等`B线程` 并且是一直等，无限的等下去，直`达B线程`到达)。

+ `timed waiting`：处于一个有限等待状态，例如我只等 5秒钟，等不到就算了，我继续执行...

+ `terminated`：线程执行完毕，退出状态。

  

##### 6.3、Thread类中的State枚举

```java
 public enum State {
        /**
         * Thread state for a thread which has not yet started.
         */
        NEW,

        /**
         * Thread state for a runnable thread.  A thread in the runnable
         * state is executing in the Java virtual machine but it may
         * be waiting for other resources from the operating system
         * such as processor.
         */
        RUNNABLE,

        /**
         * Thread state for a thread blocked waiting for a monitor lock.
         * A thread in the blocked state is waiting for a monitor lock
         * to enter a synchronized block/method or
         * reenter a synchronized block/method after calling
         * {@link Object#wait() Object.wait}.
         */
        BLOCKED,

        /**
         * Thread state for a waiting thread.
         * A thread is in the waiting state due to calling one of the
         * following methods:
         * <ul>
         *   <li>{@link Object#wait() Object.wait} with no timeout</li>
         *   <li>{@link #join() Thread.join} with no timeout</li>
         *   <li>{@link LockSupport#park() LockSupport.park}</li>
         * </ul>
         *
         * <p>A thread in the waiting state is waiting for another thread to
         * perform a particular action.
         *
         * For example, a thread that has called <tt>Object.wait()</tt>
         * on an object is waiting for another thread to call
         * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
         * that object. A thread that has called <tt>Thread.join()</tt>
         * is waiting for a specified thread to terminate.
         */
        WAITING,

        /**
         * Thread state for a waiting thread with a specified waiting time.
         * A thread is in the timed waiting state due to calling one of
         * the following methods with a specified positive waiting time:
         * <ul>
         *   <li>{@link #sleep Thread.sleep}</li>
         *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
         *   <li>{@link #join(long) Thread.join} with timeout</li>
         *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
         *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
         * </ul>
         */
        TIMED_WAITING,

        /**
         * Thread state for a terminated thread.
         * The thread has completed execution.
         */
        TERMINATED;
    }
```



##### 6.4、线程生命周期执行流程图

![image-20220717091951813](day20.assets/image-20220717091951813.png)