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
  Disconnected from th
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

##### 2.1、静态成员访问规则

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

##### 2.2、成员变量赋值问题

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

