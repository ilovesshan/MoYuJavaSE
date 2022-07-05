### JavaSE 摸鱼第16天...

#### 1、异常概述

##### 1.1、异常什么是

+ Java异常是Java提供的一种识别及响应错误的一致性机制。异常指的是程序在执行过程中，出现的非正常的情况，最终会导致JVM的非正常停止。
+ 如果不能处理好异常的发生，那么一旦发生异常就会导致后面的代码不执行了，整个程序就挂了！

##### 1.2、引发异常的案例

+ `ArithmeticException` 算数异常

  ```java
  int x = 0;
  int y = 10;
  int z = y / x;
  // 只是简单的举例、很有可能 x 和 y 都是外界动态传递进来的。
  System.out.println("z = " + z);
  ```

+ `ArrayIndexOutOfBoundsException` 数组下标越界异常

  ```java
  int[] ints = {1, 2, 3, 4};
  for (int i = 0; i <= ints.length; i++) {
      // 1000行代码 其他的逻辑操作 会改变i的值
      i++;
      System.out.println(ints[i]);
  }
  ```

##### 1.3、处理异常

+ 通过 手动编码、进行边界值和数据安全性判断

  ```java
  int x = 0;
  int y = 10;
  if (x != 0) {
      int z = y / x;
      System.out.println("z = " + z);
  } else {
      System.out.println("x = " + x + "不能做除数~");
  }
  ```

  ```java
  int[] ints = {1, 2, 3, 4};
  for (int i = 0; i <= ints.length; i++) {
      // 1000行代码 其他的逻辑操作 会改变i的值
      i++;
      if (i >= 0 && i < ints.length) {
          System.out.println(ints[i]);
      } else {
          System.out.println("下标越界了...");
          break;
      }
  }
  ```

  

+ 通过 java 提供的异常处理机制

  + 基本语法

    ```java
    try{
        // 可能发生异常的代码块
    }catch (Exception e) {
        // 捕获到的异常信息
        e.printStackTrace();
    }
    ```

    

  +  处理上面的异常

    ```java
    public class TryExceptionTest {
        public static void main(String[] args) {
            int x = 0;
            int y = 10;
            try {
                int z = y / x;
            } catch (Exception e) {
                System.out.println("x = " + x + "不能做除数~");
            }
    
    
            int[] ints = {1, 2, 3, 4};
            try {
                for (int i = 0; i <= ints.length; i++) {
                    // 1000行代码 其他的逻辑操作 会改变i的值
                    i++;
                    System.out.println(ints[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("下标越界了...");
            }
        }
    }
    
    ```

    

#### 2、异常和错误

##### 2.1、异常体系图

![image-20220705201959045](day17.assets/image-20220705201959045.png)

![image-20220705194941485](day17.assets/image-20220705194941485.png)

##### 2.2、异常分类

+ 编译异常

  + 通俗易懂解释就是：在写代码的时候，编译器包错了、显式红色波浪线，告诉你这行代码有问题，此时处理编译阶段，所以也叫做：编译异常。

  + 常见的编译异常：

    + `IOException`                          输入输出流异常 
    + `FileNotFoundException`         文件找不到的异常 
    + `ClassNotFoundException`       类找不到异常 

    + `DataFormatException`             数据格式化异常 
    + `NoSuchFieldException`           没有匹配的属性异常 
    + `NoSuchMethodException`          没有匹配的方法异常 
    + `SQLException`                         数据库操作异常 
    + `TimeoutException`                   执行超时异常

    ```java
    public class CommonCompileException {
        public static void main(String[] args) {
    
            // FileNotFoundException 文件找不到异常
            try {
                InputStream stream = new FileInputStream(new File("/abc/text.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    
            // ClassNotFoundException 类找不到异常
            try {
                Class<?> aClass = Class.forName("com.ilovesshan.day17.main");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    
            // 剩下的 后面介绍
        }
    }
    
    ```

    

+ 运行异常

  + 在编译期间通过了IDEA的检查，而在程序运行中、发生的异常就叫运行异常。
  + 常见的运行异常:
    + `ArrayIndexOutofBoundsException`     数组越界异常
    + `ClassCastException`                          类型转换异常  
    + `NullPointerException`                       空指针异常 
    + `IllegalAccessException`                    法的参数异常
    + `InputMismatchException`                    输入不匹配异常 
  + 相信 `ArrayIndexOutofBoundsException` 和  `NullPointerException` 不陌生了吧，哈哈~

##### 2.3、错误

+ 错误就是：在正常情况下程序运行中发生的错误、而导致jvm也停止运行，jvm停止运行就意味着 整个项目就挂了。

+ 常见的错误

  + 堆栈溢出  `StackOverflowError`
  + 内存不足 `OutOfMemoryError`
  + 方法不存在错误 `NoSuchMethodError`
  + 未找到类定义错误 `NoClassDefFoundError`

  ```java
  public class CommonException {
      public static void foo() {
          // 无限自己调用自己 必定造成内存溢出
          foo();
      }
  
      public static void main(String[] args) {
          CommonException.foo();
      }
  }
  
  ```

  

#### 3、捕获异常