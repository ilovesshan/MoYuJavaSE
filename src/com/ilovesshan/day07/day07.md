###  JavaSE 摸鱼第七天...

#### 1、面向对象写代码

##### 1.1、什么是对象？

+ 在java的世界中、任何东西都能理解成是一个对象、只不过各自拥有不同的属性和方法而已。

##### 1.2、面向对象和面向过程

+ 面向过程
  + 面向过程就是：按照一定的步骤去做某件事情，之前我们写的代码都是面向对象的。
  + 举个例子：你想吃包子、面向过程 就得自己去买面粉、买包子陷、自己调面、自己蒸才能吃到。

+ 面向对象
  + 面向对象就是：将某个物品抽象成一个对象,那么这个对象就拥有自己的行为特征的属性和方法、来描述自己。
  + 举个例子：你想吃包子、面向对象 你就直接去包子铺买，买来就能吃。

#### 2、类 和 对象

##### 2.1、对象

+ 对象是类的一个实例，有状态和行为，例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

##### 2.2、类

+ 类是一个模板，它描述一类对象的行为和状态。

#### 3、 面向对象之封装

##### 3.1、没学习面向对象之前的痛点

+ 假如你买了`1`辆车、这辆车是`宝马`类型的、颜色是`红色`，最大马力`360`，让你用代码描述一下，怎么玩？

  ```java
  public class NoLearnOO {
      public static void main(String[] args) {
          // 假如你买了1辆车、这辆车是`宝马`类型的、颜色是`红色`，最大马力`360`，让你用代码描述一下，怎么玩？
          String carType = "宝马";
          String carColor = "红色";
          int carSpeed = 360;
          System.out.println("这是我车的信息：" + carType + carColor + carSpeed);
  
      }
  }
  ```

+ 过几天我又买了`1`辆车、再用代码表示一下买的新车

  ```java
  public class NoLearnOO {
      public static void main(String[] args) {
          // 假如你买了1辆车、这辆车是`宝马`类型的、颜色是`红色`，最大马力`360`，让你用代码描述一下，怎么玩？
          String car1Type = "宝马";
          String car1Color = "红色";
          int car1Speed = 360;
          System.out.println("这是我第1辆车车的信息：" + car1Type + car1Color + car1Speed);
  
  
          String car2Type = "奥迪";
          String car3Color = "白色";
          int car3Speed = 280;
          System.out.println("这是我第2辆车车的信息：" + car2Type + car3Color + car3Speed);
  
      }
  }
  ```

  

+ 我又买了`100`辆车怎么表示？ (上面这种代码丝毫没有可维护性)，啊啊啊，这种代码看着不是很难受？？

##### 3.2、学习了面向对象之的妙点

+ 将车封装成一个对象、再用一个数组将车存放起来，不就ok了？

+ 一步一步来

  + 车 拥有 类型
  + 车 拥有 颜色
  + 车 拥有 最大马力

+ ok，搞清楚这个之后我们开始撸代码

  + 封装汽车对象

    ```java
    public class Car {
        // 类型
        String type;
    
        //颜色
        String color;
        
        // 最大马力
        int maxSpeed;
    }
    ```

  + 买了一辆车

    ```java
    public class CarProperties {
        public static void main(String[] args) {
            // 存放我买的车
            Car[] cars = new Car[10];
    
            // 买的第一辆车
            Car car1 = new Car();
            car1.type = "宝马";
            car1.color = "红色";
            car1.maxSpeed = 360;
            cars[0] = car1;
    
    
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] != null) {
                    System.out.println(cars[i].type + " " + cars[i].color + " " + cars[i].maxSpeed);
                }
            }
        }
    }
    ```

  + 又买了一辆车、这还不简单、new一个不就完了~~~~

    ```java
    public class CarProperties {
        public static void main(String[] args) {
            // 存放我买的车
            Car[] cars = new Car[10];
    
            // 买的第1辆车
            Car car1 = new Car();
            car1.type = "宝马";
            car1.color = "红色";
            car1.maxSpeed = 360;
            cars[0] = car1;
    
    
            // 买的第2辆车
            Car car2 = new Car();
            car2.type = "奥迪";
            car2.color = "白色";
            car2.maxSpeed = 280;
            cars[1] = car2;
    
    
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] != null) {
                    System.out.println(cars[i].type + " " + cars[i].color + " " + cars[i].maxSpeed);
                }
            }
        }
    }
    ```

    

#### 4、成员属性

+ 成员属性、我们刚刚不知不觉的就已经玩过了、是不是很妙？
+ 上面定义的car类中、车的类型、颜色、马力就是属于车的部分属性、是车的一份子、所以叫成员属性。

#### 4、成员方法

##### 4.1、成员方法使用场景？

+ 上面我们定义的车、只有属性没有行为、那有啥意思？车买回来就是开的。所以说得给他弄一个跑的方法，那么这个方法就称之为成员方法。

##### 4.2、定义一个超级简单的成员方法

+ 定义一个汽车跑的方法 `run`、看代码、是不是很简单？？

  + public 访问修饰符 先不管后面会学习
  + void 表示这个方法没有返回值
  + run 方法名称
  + { } 里面的代码就是我们写的具体开车方法、可以有1行也可以有1000000行

  ```java
  public class Car {
      
      public void run() {
          System.out.println("嘀嘀嘀，开车了...");
      }
      
  }
  ```

+ 去开车玩一把

  ```java
  public class CarMethod {
      public static void main(String[] args) {
          Car car = new Car();
  
          // 调用方法
          car.run();
      }
  }
  ```

  

##### 4.3、方法的参数和返回值

+ 参数：有时候一些方法需要根据调用时外界传入的参数来做具体的逻辑处理。

  ```java
  public class Car {
      public void run() {
          System.out.println("嘀嘀嘀，开车了...");
      }
  
  
      // 改变车的颜色
      // color 叫做形参
      public void changeColor(String color) {
          System.out.println("给车改变成" + color + "了...");
      }
  
  
      /**
       * 打开车窗
       * 接收多个参数、形参之间就用英文的逗号隔开即可
       *
       * @param leftBefore  左边前窗
       * @param leftAfter   左边后窗
       * @param rightBefore 右边前窗
       * @param rightAfter  右边后窗
       * @param top         天窗
       */
      public void openWindow(boolean leftBefore, boolean leftAfter, boolean rightAfter, boolean rightBefore, boolean top) {
          // 实现开窗的方法...
      }
  }
  
  ```

  

  ```java
  public class CarMethod {
      public static void main(String[] args) {
          Car car = new Car();
          
          // 改变车的颜色
          // 梦幻白色 叫做实参(所知道的,实实在在的参数)
          car.changeColor("梦幻白色");
      }
  }
  ```

  

+ 返回值：外部调用这个方法后、需要根据这个方法的运行结果来做下一步的处理， 那么被调用的这个方法就需要返回出来一个结果。

+ 我们将 **改变车的颜色**这个方法改造一下、改颜色也可能改失败。如果失败了就继续改，成功了就结账开回家。

  ```java
  public class Car {
      /**
       * 注意看 之前我们定义的方法都有一个void关键字
       * void关键字 就表示没有返回值。
       * Boolean 就表示要返回一个Boolean值
       * int  就表示要返回一个int值
       * String 就表示要返回一个String值
       * 其他类型以此类推...
       *
       * @param color 车的颜色
       * @return 改色的结果
       */
      public boolean changeColorIsSuccess(String color) {
          double random = Math.random();
          System.out.println("给车改变成" + color + "了...");
          if (random > 0.5) {
              return true;
          } else {
              return false;
          }
      }
  }
  
  ```

  ```java
  public class CarMethod {
      public static void main(String[] args) {
          Car car = new Car();
          
          boolean isSuccess = car.changeColorIsSuccess("雅库黑");
          if (isSuccess) {
              System.out.println("结账开回家...");
          } else {
              System.out.println("继续改...");
          }
      }
  }
  
  ```

##### 4.4、return关键字

+ 前面我们在学习循环的时候有学习过`break`和`continue`关键字。今天我们学习`return`关键字。
+ `return` 关键字用在方法中。
  + 方法有明确要求要返回什么类型的数据、使用 return 返回即可、return之后这个方法也就不会再继续向后执行剩下的的代码了。
  + 方法没有明确要求要返回什么类型的数据、使用 return 关键字也可以阻止代码继续向后执行。

##### 4.5、方法的递归调用

+ 方法在进行递归调用时、我们需要给予一个结束时机、否则会造成栈溢出。

+ 栈溢出原因

  + 当我们调用一个方法时、再栈中就会压入一个方法执行栈、调用10次`todo方法`，就会压入10个`todo方法`执行栈。
  + 犹豫栈空间也有限的、而下面代码中不断的调用`todo`最终栈装不下 所以就栈溢出了。

  ```java
  public class Recursive {
      public static void main(String[] args) {
          // 方法递归调用
          todo();
      }
  
      public static void todo() {
          // 不断的调用自己，没有设置一个结束时机 最终会导致栈溢出 StackOverflowError
          todo();
          System.out.println("todo...");
      }
  
  }
  ```

+ 斐波那契数列

  ```java
  public class FibonacciNumbers {
      public static void main(String[] args) {
  
          long numbers = fibonacciNumbers(10);
          System.out.println(numbers);
      }
  
  
      // 0、1、1、2、3、5、8、13、21、34 第三项开始、后一个数是前两个数之和
      public static long fibonacciNumbers(int number) {
          if (number == 1 || number == 0) {
              return number;
          } else {
              return fibonacciNumbers(number - 1) + fibonacciNumbers(number - 2);
          }
      }
  }
  
  ```

  

+ 数的阶乘

  ```java
  public class FactorialNumber {
      public static void main(String[] args) {
          // 数的阶乘 1*2*3*4*5*n
          long number = factorialNumber(10);
          System.out.println(number);
      }
  
      public static long factorialNumber(int number) {
          if (number > 1) {
              return number * factorialNumber(number - 1);
          } else return 1;
      }
  }
  
  ```

  

##### 4.6、方法重载

+ 方法重载(overload) 构成的条件

  + 方法名称相同
  + 和方法返回值没关系
  + 方法形参不同(个数、位置、类型)

+ 看案例

  ```java
  public class OverLoadMethod {
  
      public double add(int a, int b) {
          return a + b;
      }
  
      public double add(double a, double b) {
          return a + b;
      }
  
      public double add(double a, int b) {
          return a + b;
      }
  
      public double add(int a, double b) {
          return a + b;
      }
  
  
      public static void main(String[] args) {
          OverLoadMethod loadMethod = new OverLoadMethod();
  
          System.out.println(loadMethod.add(10, 20));
          System.out.println(loadMethod.add(10.0, 20.0));
          System.out.println(loadMethod.add(10.0, 20));
          System.out.println(loadMethod.add(10, 20.0));
      }
  }
  
  ```

  

##### 4.7、可变长参数

+ 可变长参数注意点

  + 一个方法形参中、只能有一个可变长参数
  + 可变长参数 只能放在方法形参的最后

+ 看案例

  ```java
  public class OverLoadMethod {
      // 可变长参数
      public double add(int... nums) {
          // nums 本质是一个int[]
          int res = 0;
          for (int i = 0; i < nums.length; i++) {
              res += i;
          }
          return res;
      }
  
  
      public static void main(String[] args) {
          OverLoadMethod loadMethod = new OverLoadMethod();
          System.out.println(loadMethod.add(10, 20, 30, 40, 50, 60));
      }
  }
  
  ```

  



##### 4.8、作用域

+ 作用域介绍：
  + 在类中声明的变量叫做全局变量、可以在整个类中使用。
  + 在类中成员方法中声明的变量叫做局部变量、只能在当前方法中使用。
  + for循环中声明的变量也只能在当前代码块中使用。
+ 全局变量 可以不初始化，声明了就会有默认值
  + byte、short、int、long 默认值 0
  + char 默认值 空字符串
  + boolean 默认值 false
  + 引用数据类型 默认值 null

+ 局部变量必须初始化。