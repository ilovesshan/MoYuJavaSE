### JavaSE 摸鱼第10天...
#### 1、面向对象之继承
##### 1.1、继承是什么

+ 举个例子，你的身上某些特征肯定来自于你的父亲、那么就可以说你身上这些特征是继承了你父亲身上的特征，后面随着深入学习慢慢就了解了。

+ 需要记住：java是单继承、如果需要继承多个类，请分别继承。

+ 继承的优势：将多个类共同拥有的成员属性和成员方法抽离出来、再让这些类来继承这个抽离出来的类，提高代码复用性和可扩展。

+ 还是不太明白？我们画个图

  + 学生类

    ![image-20220625175104088](day10.assets/image-20220625175104088.png)

  + 王者荣耀-英雄

    ![image-20220625175459070](day10.assets/image-20220625175459070.png)

    

##### 1.2、子类和父类构造顺序

+ 继承某个类需要使用`extends` 关键字，例如：

  ```java
  // A类 继承B类
  
  class A extends B{
  
  }
  ```

  

+ 我们通过代码实现一下学生类的关系，以及定义成员属性、让子类来访问。

  

  + 学生类

    ```java
    public class Student {
        String name = "Student Name";
        String orderNo = "Student orderNo";
    
        public void learn() {
            System.out.println("Student learn...");
        }
    }
    ```

    

  + 男学生类

    ```java
    public class MaleStudent extends Student {
    }
    
    ```

    

  + 女学生类

    ```java
    public class FemaleStudent extends  Student {
    }
    
    ```

    

  + 测试类

    ```java
    public class Main {
        public static void main(String[] args) {
            FemaleStudent femaleStudent = new FemaleStudent();
            MaleStudent maleStudent = new MaleStudent();
    
            // 可以看出来，我们创建了学生类子类的实例，是通过子类可以访问到父类属性和方法的。
            
            System.out.println("femaleStudent.name = " + femaleStudent.name); //  Student Name
            System.out.println("maleStudent.name = " + maleStudent.name); //  Student Name
    
            femaleStudent.learn(); // Student learn...
            maleStudent.learn(); // Student learn...
    
        }
    }
    ```

  

  

+ 为啥可以访问到`Student`中的属性和方法啊? `Student`类又没有创建实例？？？

  + 事实上、父类是被创建了实例的，创建了实例的原因是：父类的默认构造法方法被调用了。

  + 代码演示：给每一个类显式的写一个默认无参构造方法

    ```java
    public class Student {
        String name = "Student Name";
        String orderNo = "Student orderNo";
    
        Student(){
            System.out.println("Student 默认无参构造器被调用...");
        }
    
        public void learn() {
            System.out.println("Student learn...");
        }
    }
    
    
    public class MaleStudent extends Student {
        MaleStudent(){
            System.out.println("MaleStudent 默认无参构造器被调用...");
        }
    }
    
    
    public class FemaleStudent extends Student {
        FemaleStudent() {
            System.out.println("FemaleStudent 默认无参构造器被调用...");
        }
    }
    ```

  +  Main方法 执行结果 

    + 可以看到是先执行了父类的构造方法，再执行子类的构造方法。

    ```java
    Student 默认无参构造器被调用...
    FemaleStudent 默认无参构造器被调用...
    Student 默认无参构造器被调用...
    MaleStudent 默认无参构造器被调用...
        
    femaleStudent.name = Student Name
    maleStudent.name = Student Name
    Student learn...
    Student learn...
    
    ```

    

  + 多个类继承时、构造器怎么执行了?

    +  A继承B，B继承C
    + new A() 之后、C的构造器被执行，紧接着B执行、最后A执行。

    

    

##### 1.3、super 关键字

+ super 关键字一般用于，子类访问父类的成员属性或者方法时使用(遵循访问修饰符)。

  ```java
  public class Car {
      String brand;
      String color;
  
      public Car() {
      }
  
      public Car(String brand, String color) {
          this.brand = brand;
          this.color = color;
      }
  
  
      public void start() {
          System.out.println("汽车启动...");
      }
  
      public void run() {
          System.out.println("汽车跑起来了...");
  
      }
      
  }
  
  ```

  

  ```java
  public class BmwCar extends Car {
  
      BmwCar() {
          // 调用父类构造器
          super("宝马", "白色");
      }
  
      public void printCarInfo() {
          // 访问父类成员属性
          System.out.println(super.brand); // 宝马
          System.out.println(super.color); // 白色
  
          // 访问父类成员方法
          super.start(); // 汽车启动...
          super.run(); // 汽车跑起来了...
      }
  }
  ```

  

  ```java
  public class CarTest {
      public static void main(String[] args) {
          BmwCar bmwCar = new BmwCar();
          bmwCar.printCarInfo();
          System.out.println("bmwCar.brand = " + bmwCar.brand); // 宝马
          System.out.println("bmwCar.color = " + bmwCar.color); // 白色
      }
  }
  ```

  

##### 1.4、super和this对比

+ `super`一般用于：子类访问父类的成员属性或者方法时使用。
+ `this`一般用于：访问当前类的成员属性或者方法时使用。

|            | this                               | super                                                |
| ---------- | ---------------------------------- | ---------------------------------------------------- |
| 访问属性   | 访问本类属性，不存在继续向上层查找 | 访问父类属性，不存在继续向上层查找                   |
| 访问方法   | 访问本类方法，不存在继续向上层查找 | 访问父类方法，不存在继续向上层查找                   |
| 访问构造器 | 访问本类构造器，只能放在第一行     | 访问父类构造器，只能放在第一行、没找到不会向上层查找 |

