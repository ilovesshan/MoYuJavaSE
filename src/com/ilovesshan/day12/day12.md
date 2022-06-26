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

#### 2、面向对象设计原则

##### 2.1、开闭原则

+ 对扩展开放，模块的行为可以被扩展从而满足新的需求。
+ 对修改关闭，不允许（尽量或者最小化）修改模块源代码。

##### 2.2、单一原则

+ 一个类做的事情尽可能是单一的。

+ 当你有多个原因去修改一个类时、那就应该把这些原因分离开，将这个类拆分成多个类，每一个类只负责处理一种改变，当做出某种变化时、机就只需要去修改负责该变化的类即可，当我们去改变一个具有多个职责的类时可能会影响该类的其他功能。

##### 2.3、接口隔离原则

+ 客户端不应该被迫实现一个不应该属于他们的接口。
+ 应该将这个肥胖的接口拆分成多个接口、每个接口服务于一个子模块。

##### 2.4、里氏代换原则

+ 本质也是对开闭原则的扩展，要求我们创建新的基类子类时、不应该改变基类的行为。

+ 我们必须确保子类只是扩展而没有替换父类的功能，否则当我们在已有程序模块中使用它们时将会产生不可预料的结果。

##### 2.5、依赖倒置原则

+ 面向接口编程、不要面向实现编程。
+ 每一个类都应该提供一个接口或者抽象类、或者是两者都具备。
+ 变量的声明类型尽量是接口或者抽象类。
+ 任何类都不应该从具体类派生。
+ 继承时、尽量遵循里氏代换原则。

##### 2.6、组合/聚合复用原则

+ 组合/聚合和继承是实现复用的两个基本途径。合成复用原则是指尽量使用组合/聚合，而不是使用继承。

##### 2.7、迪米特法则

+ 迪米特法则（Law of Demeter）又叫最少知识原（Least Knowledge Principle LKP），就是说一个对象应当对其他对象有尽可能少的了解。
+ 迪米特法则的目的在于降低类之间的耦合。由于每个类尽量减少对其他类的依赖，因此，很容易使得系统的功能模块相互独立，相互之间不存在依赖关系。
+ 应用迪米特法则有可能造成的一个后果就是，系统中存在的大量的中介类，这些类只所以存在完全是为了传递类之间的相互调用关系—这在一定程度上增加系统的复杂度。
+ 设计模式中的门面模式（Facade）和中介模式（Mediator）都是迪米特法则的应用的例子。

#### 3、模板设计模式

+ 模板设计模式：在一个抽象类公开定义了执行它的方法的模板，它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。该模式体现了编程的抽象思想（抽象是所有子类的共性封装）。

+ 优点：

  + 封装不变部分、扩展可变部分，将可变部分交给子类去实现、便于子类继续扩展。
  + 父类中提取了公共部分代码、便于代码复用。
  + 部分方法是子类实现、子类可以通过扩展方式增加相应功能、符合开闭原则。

+ 缺点：

  + 对于每个实现子类都需要新增加一个类，会导致类的数量个数增加，系统更庞大。
  + 如果父类新增加方法、那么所有的子类都需要去修改。

+ 看代码：

  + `Student`类

    ```java
    public abstract class Student {
        String studentType = "";
    
        /**
         * 起床
         */
        abstract void getUp();
    
        /**
         * 吃饭
         */
        abstract void eat();
    
        /**
         * 学习
         */
        abstract void study();
    
        /**
         * 休息
         */
        abstract void play();
    
        /**
         * 睡觉
         */
        abstract void sleep();
    
    
        /**
         * 学生的一天生活
         */
        public void life() {
            getUp();
    
            eat();
    
            study();
    
            play();
    
            sleep();
        }
    
    }
    
    ```

    

  + `CollegeStudent`类

    ```java
    public class CollegeStudent extends Student {
    
        CollegeStudent(String studentType) {
            this.studentType = studentType;
        }
    
        @Override
        void getUp() {
            System.out.println(this.studentType + "起床了...");
        }
    
        @Override
        void eat() {
            System.out.println(this.studentType + "干饭了...");
        }
    
        @Override
        void study() {
            System.out.println(this.studentType + "在学习...");
        }
    
        @Override
        void play() {
            System.out.println(this.studentType + "下课休息了...");
        }
    
        @Override
        void sleep() {
            System.out.println(this.studentType + "睡觉了...");
        }
    }
    
    ```

    

  + `PupilStudent`类

    ```java
    public class PupilStudent extends Student {
    
        PupilStudent(String studentType) {
            this.studentType = studentType;
        }
    
        @Override
        void getUp() {
            System.out.println(this.studentType + "起床了...");
        }
    
        @Override
        void eat() {
            System.out.println(this.studentType + "干饭了...");
        }
    
        @Override
        void study() {
            System.out.println(this.studentType + "在学习...");
        }
    
        @Override
        void play() {
            System.out.println(this.studentType + "下课休息了...");
        }
    
        @Override
        void sleep() {
            System.out.println(this.studentType + "睡觉了...");
        }
    }
    
    ```

    

  + `Visitor`类

    ```java
    public class Visitor {
        public void visit(Student student) {
            student.life();
        }
    }
    
    ```

    

  + `main`方法

    ```java
    public class Main {
        public static void main(String[] args) {
            // 小学生
            PupilStudent pupilStudent = new PupilStudent("小学生");
            // 大学生
            CollegeStudent collegeStudent = new CollegeStudent("大学生");
    
            // 拜访者
            Visitor visitor = new Visitor();
    
            // 看看小学生一天生活
            System.out.println("***********************开始体验小学生一天的生活***************************");
            visitor.visit(pupilStudent);
            System.out.println("***********************小学生一天的生活体验结束***************************");
    
            // 看看大学生一天生活
            System.out.println("***********************开始体验大学生一天的生活***************************");
            visitor.visit(collegeStudent);
            System.out.println("***********************大学生一天的生活体验结束***************************");
        }
    }
    ```

  + 输出结果：

    ```java
    Connected to the target VM, address: '127.0.0.1:59492', transport: 'socket'
    ***********************开始体验小学生一天的生活***************************
    小学生起床了...
    小学生干饭了...
    小学生在学习...
    小学生下课休息了...
    小学生睡觉了...
    ***********************小学生一天的生活体验结束***************************
        
    ***********************开始体验大学生一天的生活***************************
    大学生起床了...
    大学生干饭了...
    大学生在学习...
    大学生下课休息了...
    大学生睡觉了...
    ***********************大学生一天的生活体验结束***************************
    Disconnected from the target VM, address: '127.0.0.1:59492', transport: 'socket'
    
    Process finished with exit code 0
    ```

    

  

#### 4、策略设计模式