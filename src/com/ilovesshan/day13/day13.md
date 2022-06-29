### JavaSE 摸鱼第12天...
#### 1、代码块

+ 代码块：没有返回值、没有方法名称、没有参数列表只有代码块`{}`。

##### 1.1、静态代码块

```java
public class User {

    // 静态代码块 可以按照实际业务需求、write your code 
    static {
        System.out.println("静态代码块执行...");
    }

}
```



##### 1.2、实例代码块

```java
public class User {

    // 实例代码块 可以按照实际业务需求、write your code 
    {
        System.out.println("实例代码块执行...");
    }

}
```



##### 1.3、代码块执行顺序

+ 创建了 3 个User 实例、卡看一下 静态代码块 和  实例代码块执行顺序

  + 一个类的静态代码块只会执行一次、当这个类从磁盘被加载到内存的时候执行。
  + 一个类的实例代码块会在这个类被构造的时候执行。

  ```java
  public class Main {
      public static void main(String[] args) {
  
          User user1 = new User();
          User user2 = new User();
          User user3 = new User();
      }
  }
  
  静态代码块执行...
  实例代码块执行...
  实例代码块执行...
  实例代码块执行...
  ```

+ 静态代码块、实例代码块、构造器执行顺序：

  ```java
  class User {
      static {
          System.out.println("静态代码块执行...");
      }
  
      {
          System.out.println("实例代码块执行...");
      }
  
      public User() {
          System.out.println("User构造器代码执行...");
      }
  }
  ```

  ```java
  public class Main {
      public static void main(String[] args) {
          User user = new User();
      }
  }
  
  静态代码块执行...
  实例代码块执行...
  User构造器代码执行...
  ```



+ 类继承时、静态代码块、实例代码块、构造器执行顺序：

  ```java
  public class Animal {
      static {
          System.out.println("Animal静态代码块执行...");
      }
  
      {
          System.out.println("Animal实例代码块执行...");
      }
  
      public Animal() {
          System.out.println("Animal构造器代码执行...");
      }
  }
  
  
  class Cat extends Animal {
      static {
          System.out.println("Cat静态代码块执行...");
      }
  
      {
          System.out.println("Cat实例代码块执行...");
      }
  
      public Cat() {
          System.out.println("Cat构造器代码执行...");
      }
  }
  ```

  ```java
  class Main {
      public static void main(String[] args) {
          Cat cat = new Cat();
      }
  }
  
  Animal静态代码块执行...
  Cat静态代码块执行...
  Animal实例代码块执行...
  Animal构造器代码执行...
  Cat实例代码块执行...
  Cat构造器代码执行...
  ```
  


#### 2、静态成员和普通成员

##### 2.1、静态成员

```java
public class User {
    // 静态变量
    public static String name = "name";
   
      // 静态方法
    public static void printName() {
        System.out.println(name);
    }
}
```

##### 2.2、静态成员访问规则

+ 无需创建对象实例、即可访问静态变量和静态方法，这些静态方法和变量直接被都存放在方法池(有且只有一份)，可以直接访问。

  + 访问静态变量通过 `类名.变量名`

  + 访问静态方法通过 `类名.方法名`

    ```java
    public class Main {
        public static void main(String[] args) {
            System.out.println(User.name1);
            User.printName1();
        }
    }
    
    ```

+ 注意：静态代码块和静态方法中没有`this`这个关键字，由于静态变量解析优先于类加载。

+ 访问规则

  + 静态方法和代码中不能使用`this` 和 `super` 关键字。
  +  静态方法中不能直接访问普通成员方法和变量、需要创建对象实例访问
  + 普通成员方法中可以直接访问静态方法和静态变量

  ```java
  // 静态方法
  public static void printName1() {
      // 静态方法中不能直接访问普通成员方法和变量、需要创建实例访问
      User user = new User();
      user.printName2();
      System.out.println(user.name2);
  
  }
  
  // 普通成员方法
  public void printName2() {
      // 普通成员方法中可以直接访问静态方法和静态变量
      printName1();
      System.out.println(name1);
  }
  ```

##### 2.3、成员变量赋值问题

+ 静态成员变量
+ 普通成员变量

```java
public class Assignment {
    
    // public static String name1 = "jack";  等同于1 2
    /* 1 */ public static String name1;

    // public String name2 = "jack";  等同于3 4
    /* 3 */public String name2;

    {
        // System.out.println("实例代码块执行..."); // 等同于 5
    }

    static {
        /* 2 */
        name1 = "jack";
        System.out.println("stack  block code");
    }

    Assignment() {
        /* 5 */
        System.out.println("实例代码块执行...");
        /* 4 */
        name2 = "jack";
        System.out.println("构造器代码块执行...");
    }

    public static void main(String[] args) {
        Assignment assignment = new Assignment();
    }
}

```

##### 2.4、静态方法和变量使用场景

+ 封装工具类

+ 封装常量

  ```java
  public class Utils {
      public static int plus(int i1, int i2) {
          return i1 + i2;
      }
  
      public static int sub(int i1, int i2) {
          return i1 - i2;
      }
  }
  
  
  public class Constants {
  
      // 常量命名规范: 字母全大写通过下划线分割
  
      public static final int SUCCESS_CODE = 200;
      public static final int ERROR_CODE = -200;
  
      public static final String SUCCESS_MESSAGE = "操作成功";
      public static final String ERROR_MESSAGE = "操作失败";
  }
  
  
  public class Main {
      public static void main(String[] args) {
  
          // 调用静态常量
          System.out.println(Constants.SUCCESS_CODE);
          System.out.println(Constants.SUCCESS_MESSAGE);
  
          // 调用静态方法
          System.out.println(Utils.plus(10, 20));
          System.out.println(Utils.sub(10, 20));
      }
  }
  ```

  

#### 3、内部类

##### 3.1、成员内部类

+ 在一个类的内部再定义一个类 `Inner`，那么就称 `Inner` 是一个内部类(不使用`static`关键字修饰)，这个内部类和一个普通类没区别，可以定义成员变量成员方法，同时可以访问外部的变量和方法。

```java
public class MemberInnerClass {
    {
        System.out.println("MemberInnerClass 实例代码块执行...");
    }

    public String name1 = "MemberInnerClass name1";

    public void sayName1() {
        System.out.println(this.name1);
    }

    public void createInnerClassInstance() {
        InnerClass innerClass = new InnerClass();
        innerClass.sayName2();
    }


    /* 可以加修饰符*/  class InnerClass {
        {
            System.out.println("InnerClass 实例代码块执行...");
        }

        // 和普通类用法一样 可以定义成员变量

        public String name2 = "InnerClass name2";

        public void sayName2() {
            System.out.println(this.name2);

            // 访问外部变量和方法
            System.out.println(name1);
            sayName1();
        }

    }

    public static void main(String[] args) {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        memberInnerClass.createInnerClassInstance();
    }

}


MemberInnerClass 实例代码块执行...
InnerClass 实例代码块执行...
InnerClass name2
MemberInnerClass name1
MemberInnerClass name1
```



##### 3.2、静态内部类

+ 在`成员内部类` 的类前加一个 `static` 关键字，就变成了静态内部类，静态内部类不能直接访问外部成员变量和方法、需要通过创建实例去访问、但是可以直接访问外部的静态变量和静态方法，和当前方法是否是静态无关。

```java
public class StaticInnerClass {
    static {
        System.out.println("StaticInnerClass 静态代码块执行...");
    }

    {
        System.out.println("MemberInnerClass 实例代码块执行...");
    }

    public static String name1 = "MemberInnerClass name1";
    public String name2 = "MemberInnerClass name2";

    public static void sayName1() {
        System.out.println(name1);
    }

    public void sayName2() {
        System.out.println(name2);
    }

    public void createInnerClassInstance() {
        InnerClass.sayName3();

        System.out.println("**************************************");

        InnerClass aClass = new InnerClass();
        aClass.sayName4();
    }


    static class InnerClass {
        static {
            System.out.println("InnerClass 静态代码块执行...");
        }

        {
            System.out.println("InnerClass 实例代码块执行...");
        }

        public static String name3 = "InnerClass name3";
        public String name4 = "InnerClass name4";

        public static void sayName3() {
            // 访问外部静态成员 直接访问
            System.out.println(name1);
            sayName1();

            // 访问外部非静态成员 创建实例访问
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            System.out.println(staticInnerClass.name2);
            staticInnerClass.sayName2();
        }

        public void sayName4() {
            // 访问外部静态成员 直接访问
            System.out.println(name1);
            sayName1();

            // 访问外部非静态成员 创建实例访问
            StaticInnerClass staticInnerClass = new StaticInnerClass();
            System.out.println(staticInnerClass.name2);
            staticInnerClass.sayName2();
        }

    }

    public static void main(String[] args) {
        StaticInnerClass memberInnerClass = new StaticInnerClass();
        memberInnerClass.createInnerClassInstance();
    }

}


StaticInnerClass 静态代码块执行...
    
StaticInnerClass 实例代码块执行...
InnerClass 静态代码块执行...
StaticInnerClass name1
StaticInnerClass name1
StaticInnerClass 实例代码块执行...
StaticInnerClass name2
StaticInnerClass name2
**************************************
InnerClass 实例代码块执行...
StaticInnerClass name1
StaticInnerClass name1
StaticInnerClass 实例代码块执行...
StaticInnerClass name2
StaticInnerClass name2
```



##### 3.3、局部内部类

+ 局部内部类是指定义在一个代码块内(方法)的类，作用范围为其所在的代码块。局部类类似于局部变量一样，不能被public、protected、private以及static修饰，在局部内部类中可以访问外部类的所有成员。
+ 局部内部类访问外部类成员时、如果发现命名冲突可以使用 `OuterClass.this.变量名` 访问

```java
public class LocalClass {

    public static String name = "localClass name";
    public static String name1 = "localClass name1";
    public String name2 = "localClass name2";

    public static void printName1() {
        System.out.println(name1);
    }

    public void printName2() {
        System.out.println(this.name2);
    }

    public void createInnerClassInstance() {
        // 局部内部类
        class InnerClass {
            String name = "InnerClass name";

            {
                System.out.println("InnerClass 实例代码块执行...");
            }

            public void printName() {
                System.out.println(this.name);
                System.out.println(LocalClass.this.name);

                // 访问外部变量
                System.out.println(name1);
                System.out.println(name2);

                printName1();
                printName2();

            }
        }

        new InnerClass().printName();
    }

    public static void main(String[] args) {
        LocalClass localClass = new LocalClass();
        localClass.createInnerClassInstance();
    }

}


InnerClass 实例代码块执行...
InnerClass name
localClass name
localClass name1
localClass name2
localClass name1
localClass name2
```



##### 3.4、匿名内部类

+ 匿名内部类，是一种没有类名的内部类，不使用关键字class、extends、implements，它必须继承其他类或实现其它接口。
+ 实现方式：
  + 接口：由于接口是没有构造函数的，一定是空参数。
  + 类：调用父类的构造器，注意可以是空参数，也可以传入参数。

```java
interface ICalculate {
    int plus(int i1, int i2);
}


abstract class Plus {
    public Plus() {
    }

    public Plus(String tag) {
        System.out.println(tag);
    }

    abstract int plus(int i1, int i2);
}


class Utils {
    String name = "default class anem";

    Utils() {

    }

    Utils(String name) {
        this.name = name;
    }

    public void printClassName() {
        System.out.println(this.name);
    }
}

public class AnonymousClass {
    public static void main(String[] args) {

        // 接口 匿名内部类
        ICalculate iCalculate = new ICalculate() {
            @Override
            public int plus(int i1, int i2) {
                return i1 + i2;
            }
        };

        int res1 = iCalculate.plus(20, 30);
        System.out.println(res1);


        // 抽象类 匿名内部类  调用父类默认构造器
        // 抽象类 匿名内部类  调用父类带参数构造器
        Plus p1 = new Plus() {
            @Override
            int plus(int i1, int i2) {
                return i1 + i2;
            }
        };


        // 抽象类 匿名内部类  调用父类带参数构造器
        Plus p2 = new Plus("TAG") {
            @Override
            int plus(int i1, int i2) {
                return i1 + i2;
            }
        };

        int res2 = p2.plus(20, 30);
        System.out.println(res2);


        // 普通类  带参数构造器
        Utils util1 = new Utils() {
        };
        util1.printClassName();

        // 普通类
        Utils utils2 = new Utils("common class name") {
        };
        utils2.printClassName();

    }
}


50
TAG
50
default class anem
common class name
```



#### 4、单例模式

+ 让一个类、有且只有一个实例存在，每次获取到的类的实例都是同一个。

##### 4.1、饿汉式

+ 饿汉式：顾名思义就是很饿的意思、我上来就直接`new` 一个对象实例。
+ 饿汉模式在类被初始化时就已经在内存中创建了对象，以空间换时间。

```java
public class HungrySingletonMode {
    private static final HungrySingletonMode instance = new HungrySingletonMode();

    private HungrySingletonMode() {
    }

    public static HungrySingletonMode getInstance() {
        return instance;
    }

}
```



##### 4.2、懒汉式

+ 懒汉式：就是很懒的意思，你不使用那我就不创建实例，使用时再创建实例，但是在多线程下有线程安全问题。
+ 懒汉模式在方法被调用后才创建对象，以时间换空间，在多线程环境下存在风险。

```java
public class LazySingletonMode {
    private static LazySingletonMode instance = null;

    private LazySingletonMode() {
    }

    public static LazySingletonMode getInstance() {
        if (instance == null) {
            instance = new LazySingletonMode();
        }
        return instance;
    }

}
```



##### 4.3、基于内部类的单例模式

+ 外部类加载时、并不需要加载内部类，只有调用 `getInstance` 才加载内部类，故不占内存。
+ 内部类是一个静态内部类、第一次加载就会创建 `InnerClassSingletonMode` 实例，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。

```java
public class InnerClassSingletonMode {

    private InnerClassSingletonMode() {
    }

    public static InnerClassSingletonMode getInstance() {
        return InnerClassSingletonModeHolder.instance;
    }

    private static class InnerClassSingletonModeHolder {
        private static final InnerClassSingletonMode instance = new InnerClassSingletonMode();
    }
}
```

