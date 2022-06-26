### JavaSE 摸鱼第12天...
#### 1、抽象类和接口

##### 1.1、抽象类

+ 猫属于动物、狗也属于动物，按照前面所学的继承改概念、那么我们可以将动物封装成一个类、里面可以有成员属性和方法。

+ 这个时候、我可以将这个动物类设计成一个抽象类，将猫和狗共同拥有的方法 (比如吃、呼吸等等)，设计成一个抽象方法、但是方法的具体的实现交给他们自己去实现。

+ 看个案例就会明白许多：

  + 定义了一个抽象类`Animal`、用了`abstract` 关键字来修饰、表示这是一个抽象类，`eat`  和 `breath`方法也分别使用了 `abstract` 关键字修饰、并且这两个方法是没有方法体的，没有具体的实现。这就是抽象方法。
  + `Dog`  和  `Cat` 类都继承了 `Animal`类、并且都重写了 父类的两个抽象方法、即实现了 父类抽象方法的具体实现由实现子类来完成。

  ```java
  public abstract class Animal {
  
      abstract void eat();
  
      abstract void breath();
  
      void showName() {
      }
  }
  
  
  class Dog extends Animal {
  
      @Override
      void eat() {
          System.out.println("狗狗喜欢啃骨头...");
      }
  
      @Override
      void breath() {
  
      }
  }
  
  class Cat extends Animal {
  
      @Override
      void eat() {
          System.out.println("猫猫喜欢吃小鸟...");
      }
  
      @Override
      void breath() {
  
      }
  }
  ```

+ 注意点：

  + 抽象类中可以没有抽象方法、但是有抽象方法的类必须是抽象类。
  + 抽象类不能直接被构造、但是继承了抽象类的子类被构造时会调用抽象类的无参构造。
  + 继承抽象类的子类
    + 要么也使用`abstract`修饰，即也是一个抽象类
    + 要么必须重写抽象类中的抽象方法
  + 抽象类中的抽象方法只能使用`public` 或者 `protected` 来修饰、不写默认就是 `public`的
  + 抽象类中的成员方法对修饰符无要求

##### 1.2、接口

+ 举个例子

  + 飞机可以飞、小鸟也可以飞、他们都有一个共同的行为那就是`飞`。
  + 防盗门有个防盗报警器、车也有个防盗报警器、那么他们拥有一个共同的行为那就是`报警`。
  + 这个时候、我们可以将 `飞` 或者 `报警` 这个行为（能力）抽离出来成一个接口、让那些也拥有这个行为（能力）的类实现这个接口即可。

+ 看代码

  + `public interface CommonAction {}` 声明了一个接口，里面有一个 `fly`的抽象方法。
  +  `plane` 和  `Bird` 使用 `implements` 关键字来实现了  `CommonAction ` 接口，并且实现了里面的 抽象方法。

  ```java
  public interface CommonAction {
      void fly();
  }
  
  class plane implements CommonAction {
  
      @Override
      public void fly() {
  
      }
  }
  
  
  class Bird implements CommonAction {
  
      @Override
      public void fly() {
  
      }
  }
  ```

+ 注意点：

  + 接口中的抽象方法默认就是使用`public abstract` 修饰的

  + 接口中的成员变量是用：` public static final` 修饰的

  + 接口中也可以定义具体的方法(jdk8新特性)、使用`default` 修饰

    ```java
    public interface CommonAction {
        void fly();
    
        default void show() {
        }
    
    }
    ```

    

##### 1.3、抽象类和接口对比

+ 抽象类好比：`xx is xx` , 猫是动物、狗是动物。
+ 而接口好比：` can do/have xxx`，小鸟能够飞、飞机能够飞，防盗门拥有报警功能、车也有拥有报警功能。

+ 一个类只能继承一个抽象类，而一个类却可以实现多个接口。
+ 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 **public static final** 类型的。
+ 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。

#### 2、设计模式