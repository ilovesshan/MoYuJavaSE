### JavaSE 摸鱼第四天...

#### 1、顺序结构语句

+ 这个没啥说的，很多语言都是一样，代码的执行顺序都是从上往下...

#### 2、条件(分支)结构语句
##### 2.1、单分支

+  语法  `if(condiction){ /*我们写的逻辑代码 */ } ` 如果` condiction`结果为`true` 那就会执行大括号中的代码。
+ 类似于：如果明天怎么怎么样，那我我们就会怎么怎么杨

+ 举个例子，我们利用键盘输入自己成绩，如果大于60就提示及格，否则就提示不及格。

  ```java
  public class ConditionsStructure {
      public static void main(String[] args) {
          // 单分支
          Scanner scanner = new Scanner(System.in);
          int score = scanner.nextInt();
          if (score >= 60) {
              System.out.println("及格了,牛批...");
          }
          System.out.println("没及格,继续努力吧...");
      }
  }
  
  // 上面的代码其实存在问题，不管怎么输入成绩 始终都会打印"没及格,继续努力吧..."
  // 我们使用 多分支来解决这个问题
  ```

  

##### 2.2、多分支

+  语法  `if(condiction){ /*逻辑代码1*/ } `else{/*逻辑代码2*/} 
+ 如果` condiction`结果为`true` 那就会执行`逻辑代码1`,否则就执行`逻辑代码2`,
+ 记住一句话 执行到else的情况是，前面的if条件都不满足

+ 还是老问题，把上面需求完善一下

  ```java
  public class ConditionsStructure {
      public static void main(String[] args) {
          // 多分支
          Scanner scanner = new Scanner(System.in);
          int score = scanner.nextInt();
          if (score >= 60) {
              System.out.println("及格了,牛批...");
          }else{
              System.out.println("没及格,继续努力吧...");
          }
      }
  }
  ```

  

+ 考虑一下，如果大于60算及格、大于80算优秀、否则不及格怎么玩呢？、

  ```java
  // 很简单...
  public class ConditionsStructure {
      public static void main(String[] args) {
          // 多分支
          Scanner scanner = new Scanner(System.in);
          int score = scanner.nextInt();
          // 此时应该考虑考虑边界值 成绩不能大于100吧，不能小于0吧!
          if (score >= 80) {
              System.out.println("优秀");
          }else if(score >= 60){
              System.out.println("及格");
          }else{
               System.out.println("不及格");
          }
      }
  }
  ```

  

##### 2.3、嵌套分支

+ 嵌套分支就是`if`里面再嵌套`if`

+ 温馨提示：嵌套最好不要超过三层，要是在公司会被diao的

+ 还是骚举一个小例子，感受感受吧

  ```java
  import java.util.Scanner;
  
  public class ConditionsStructure {
      public static void main(String[] args){ 
  
          // 动物园买门票 儿童免票、学生打五折、老人打三折。
          // 旺季门票价格: 票价80
          // 淡季门票价格: 票价50
          // 编写程序 根据输入季节和年龄 来计算票价
  
          Scanner scanner = new Scanner(System.in);
          System.out.print("请输入季节:(旺季/1 淡季/2)");
          int reason = scanner.nextInt();
          if (reason == 1) {
              // 旺季
              double price = 80;
              System.out.print("请输入年龄:");
              int age = scanner.nextInt();
              if (age >= 0 && age <= 6) {
                  price = 0;
              } else if (age >= 6 && age <= 22) {
                  price = price * 0.5;
              } else if (age >= 60 && age <= 150) {
                  price = price * 0.3;
              }
              System.out.println("您的年龄是: " + age + ", 对应票价是: " + price);
  
          } else if (reason == 2) {
              // 淡季
              double price = 50;
              System.out.print("请输入年龄:");
              int age = scanner.nextInt();
              if (age >= 0 && age <= 6) {
                  price = 0;
              } else if (age >= 6 && age <= 22) {
                  price = price * 0.5;
              } else if (age >= 60 && age <= 150) {
                  price = price * 0.3;
              }
              System.out.println("您的年龄是: " + age + ", 对应票价是: " + price);
          } else {
              System.out.println("错误季节...");
          }
      }
  }
  
  ```

##### 2.4、玩一玩 switch

+ `switch case` 能做的 `if else` 也可以做。

+ 举个例子：

  ```java
  import java.util.Scanner;
  
  public class SwitchCase {
      public static void main(String[] args) {
          // 输入1、2、3、4、5、5、6、7 则打出对应星期几
          //  哈哈哈 很简单吧... 用if 不是分分钟搞定!
  
          Scanner scanner = new Scanner(System.in);
          int day = scanner.nextInt();
  
          switch (day) {
              case 1:
                  System.out.println("星期1");
                  break;
              case 2:
                  System.out.println("星期2");
                  break;
              case 3:
                  System.out.println("星期3");
                  break;
              case 4:
                  System.out.println("星期4");
                  break;
              case 5:
                  System.out.println("星期5");
                  break;
              case 6:
                  System.out.println("星期6");
                  break;
              default:
                  System.out.println("星期7");
          }
      }
  }
  
  ```

+ 注意啊：`break`关键字别忘记写了, 不然就会一直往下走，直到碰到`break`或者程序退出了...

+ case 后面只能跟6种数据类型：byte、short、int、char、枚举、String

+ 其他数据类型是完不转的、那么就交给 if 吧

#### 3、循环结构语句

##### 3.1、for 循环

+ 简单的需求，打印10句话 `好好学习~`

  ```java
  public class ForCycle {
      public static void main(String[] args) {
          // 简单的需求，打印10句话 `好好学习~`
          for (int i = 0; i < 10; i++) {
              System.out.println(i + "好好学习~");
          }
  
          // 更高级的写法 本质和上面是一样的，只不过换了位置.
          int i = 0;
          for (; ; ) {
              if (i < 10) {
                  System.out.println(i + "好好学习~");
                  i++;
              } else {
                  break;
              }
          }
      }
  }
  ```

+ 玩一玩嵌套for循环

  ```java
  package com.ilovesshan.day04;
  
  public class ForCycle {
      public static void main(String[] args) {
          // 打印 一个5*5的**正方形
          for (int i = 0; i < 5; i++) {
              for (int j = 0; j < 5; j++) {
                  System.out.print("*");
              }
              System.out.println();
          }
          
          // 打印 100-999 中间的水仙花数
          for (int i = 100; i <= 999; i++) {
              int a = i / 100;
              int b = i / 10 % 10;
              int c = i % 10;
  
              if (i == a * a * a + b * b * b + c * c * c) {
                  System.out.println(i);
              }
          }
          
          // 打印 九九乘法表
          for (int i = 1; i < 10; i++) {
              for (int j = 1; j <= i; j++) {
                  System.out.print(j + "*" + i + "=" + j * i + "\t");
              }
              System.out.println();
          }
      }
  }
  ```

+ for循环打标签

  ```java
  package com.ilovesshan.day04;
  
  public class ForCycle {
      public static void main(String[] args) {
         outerFor: for (int i = 0; i < 5; i++) {
              for (int j = 0; j < 5; j++) {
                  // break 默认只会打断当前循环 并不会打断外层的for
                  // 如果在某个条件下 想打断外层for循环 可以使用打标签的方式
                  
                  if(/*条件*/){
                      break outerFor;
                  }
              }
          }
      }
  }
  ```

  

##### 3.2、while 循环

##### 3.3、do..while  循环