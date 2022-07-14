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

#### 4、多线程异步和效率

#### 5、守护线程