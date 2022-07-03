### JavaSE 摸鱼第15天...

#### 1、Math类

+ `Math` 类主要提供发了一些关于数学方面的常量和运算的方法。

+ 介绍几个常用的，遇到了查查文档就ok了。

  ```java
  public class MathTest {
      public static void main(String[] args) {
  
          // 返回一个随机double 值
          double random = Math.random();
  
          // 向上取整 返回一个double 值
          Math.ceil(2.3);
  
          // 向下取整 返回一个double 值
          Math.floor(2.3);
  
          // 四舍五入 返回一个int 值
          Math.round(2.4);
  
          // 最大值
          Math.max(10, 20);
  
          // 最小值
          Math.min(10, 20);
  
          // 绝对值
          Math.abs(-10);
  
          // 平方
          Math.pow(2, 3);
      }
  }
  ```
  
  

#### 2、BigDecimal类

+  两个`doucle` 类型的数进行运算时、会出现精度丢失，原因是：计算机使用二进制表示十进制小数时，会出现无限循环或超出浮点数尾部的长度。

+ 解决办法：使用 `BigDecimal` 

  ```java
  public class BigDecimalTest {
      public static void main(String[] args) {
          double i1 = 0.1;
          double i2 = 0.2;
          System.out.println(i1 + i2); // 0.30000000000000004
      }
  }
  ```

  

+ `BigDecimal` 类 提供了常用的方法

  +  构造 `BigDecimal 时尽量传入 `String` 类型的数值

  + `add `加
  + `subtract` 减
  + `multiply` 乘
  + `divide` 除

+ 封装一个 `BigDecimal` 工具类

  ```java
  import java.math.BigDecimal;
  public class BigDecimalUtils {
  
      // 加
      static double add(double d1, double d2) {
          BigDecimal i1 = new BigDecimal(Double.toString(d1));
          BigDecimal i2 = new BigDecimal(Double.toString(d2));
          return Double.parseDouble(i1.add(i2).toString());
      }
  
  
      // 减
      static double subtract(double d1, double d2) {
          BigDecimal i1 = new BigDecimal(Double.toString(d1));
          BigDecimal i2 = new BigDecimal(Double.toString(d2));
          return Double.parseDouble(i1.subtract(i2).toString());
      }
  
  
      // 乘
      static double multiply(double d1, double d2) {
          BigDecimal i1 = new BigDecimal(Double.toString(d1));
          BigDecimal i2 = new BigDecimal(Double.toString(d2));
          return Double.parseDouble(i1.multiply(i2).toString());
      }
  
      // 除
      static double divide(double d1, double d2) {
          BigDecimal i1 = new BigDecimal(Double.toString(d1));
          BigDecimal i2 = new BigDecimal(Double.toString(d2));
          return Double.parseDouble(i1.divide(i2).toString());
      }
  }
  ```

  

  ```java
  public class BigDecimalTest {
      public static void main(String[] args) {
          // 0.3
          System.out.println(BigDecimalUtils.add(i1, i2));
  
          // -0.1
          System.out.println(BigDecimalUtils.subtract(i1, i2));
  
          // 0.02
          System.out.println(BigDecimalUtils.multiply(i1, i2));
  
          // 0.5
          System.out.println(BigDecimalUtils.divide(i1, i2));
  
      }
  }
  ```

  

#### 3、Random类

+ 构造 `Random`时 带参和不带参区别

  + 带参：这个参数叫做  `种子`， 每一次产生的随机数都是一样的。
  + 不带参：默认取当前时间戳作为 `种子`, 每一次产生的随机数都是不一样的(理论上)。

  ```java
  package com.ilovesshan.day16;
  
  import java.util.Random;
  
  /**
   * Created with IntelliJ IDEA.
   *
   * @author: ilovesshan
   * @date: 2022/7/3
   * @description:
   */
  public class RandomTest {
      public static void main(String[] args) {
          System.out.println("*************不带参数构造*************");
          for (int i = 0; i < 5; i++) {
              Random r1 = new Random();
              for (int j = 0; j < 5; j++) {
                  System.out.print(r1.nextInt(100) + ", ");
              }
              System.out.println();
          }
  
          System.out.println("*************带参数构造*************");
          for (int i = 0; i < 5; i++) {
              Random r2 = new Random(100);
              for (int j = 0; j < 5; j++) {
                  System.out.print(r2.nextInt(100) + ", ");
              }
              System.out.println();
          }
      }
  }
  
  
  
  *************不带参数构造*************
  47, 58, 38, 14, 10, 
  9, 18, 24, 33, 69, 
  26, 57, 40, 60, 7, 
  19, 88, 64, 61, 22, 
  59, 72, 92, 25, 17, 
  *************带参数构造*************
  15, 50, 74, 88, 91, 
  15, 50, 74, 88, 91, 
  15, 50, 74, 88, 91, 
  15, 50, 74, 88, 91, 
  15, 50, 74, 88, 91, 
  ```

  

+ 常用的方法

  ```java
  public class RandomTest {
      public static void main(String[] args) {
          // 产生一个随机数
          Random random = new Random();
  
          // 生成随机boolean值
          boolean aBoolean = random.nextBoolean();
  
          //  生成随机 bytes
          byte[] bytes = new byte[10];
          random.nextBytes(bytes);
  
          //  生成随机 int
          int anInt = random.nextInt(10);
  
          //  生成随机 double
          double aDouble = random.nextDouble();
  
      }
  
  ```

  

#### 4、Arrays类

#### 5、System类 

#### 6、StringBuffer和StringBuilder

