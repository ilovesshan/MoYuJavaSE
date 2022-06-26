### JavaSE 摸鱼第11天...
#### 1、面向对象之多态
##### 1.1、多态概述和代码实例

+ 先看总结，再看生活举例和代码实操、你就能够从宏观上理解`多态`是个啥玩意~

  + 有`继承`、有`重写`、有`父类引用指向子类实例对象`，三者都满足就构成了`多态`。

+ 有点懵逼？没关系，举个例子。

  + 有几个类

    + 有一个汽车类-Car
    + 有个继承了Car的奥迪车类-AudiCar
    + 有个继承了Car的奔驰车类-BenZCar

  + 提问？

    + 奥迪车是车吗？ 是
    + 奔驰车是车吗？ 是
    + 奥迪车是奔驰车吗？ 不是

  + 搞清楚这个问题之后、看代码

    ```java
    public class Boy {
    
        public void buyCar(Car car) {
            this.showCarInfo(car);
        }
    
        public void showCarInfo(Car car) {
            car.showType();
        }
    }
    
    ```

    ```java
    public class Car {
    
        /**
         * 查看汽车的驾驶挡类型
         */
    
        public void showType() {
        }
    
    }
    
    ```

    ```java
    
    class AudiCar extends Car {
    
        @Override
        public void showType() {
            System.out.println("BenZCar 是手动挡...");
        }
    }
    ```

    ```java
    class BenZCar extends Car {    
    
        @Override
        public void showType() {
            System.out.println("BenZCar 是自动挡...");
        }
    }
    
    
    ```

    ```java
    public class Car {
        public static void main(String[] args) {
    
            // 男孩想买车并且看一下各自的配置信息 下面有两辆车
            Car benZCar = new BenZCar();
            Car audiCar = new AudiCar();
    
            Boy boy = new Boy();
            // 可以买 奔驰车 也可以买奥迪车
            boy.buyCar(benZCar); // BenZCar 是自动挡...
            boy.buyCar(audiCar); // BenZCar 是手动挡...
        }
    }	
    ```

  + 注意看细节

    + 两个汽车类都继承了Car类并且重写了父类的`showType` 方法
    + man方法中、创建两个汽车子类时、用的是父类类型作为子类实例对象类型接收的
    + Boy类的的两个方法形参都是使用`Car`类作为参数类型的、但是你买车的时候传入的是`Car`类的实现子类，当传入同一类型的参数却得到了不同的结果

  + 上诉条件就是 `多态`的体现，当然这只是宏观上的理解、更深层次理解需要结合底层字节码来理解~~

##### 1.2、多态深层理解

+ 看下面代码

  ```java
   Car car = Math.random() > 0.5 ? new BenZCar() : new AudiCar();
  ```

+ 可以看到，等号左侧的类型是`Car` 这个是很明确的知道、但是右侧到底是 `BenZCar` 还是  `AudiCar`，显然没法确定、只有运行时才能知道具体的类型。

+ 那我们就可以说：

  + 等号左侧的类型叫做 `静态类型`或者`编译类型`、在编译阶段就可以确定其类型。
  + 等号右侧的类型叫做 `动态类型`或者`运行类型`、只能在运行阶段才可以确定类型。

##### 1.3、属性没有多态

+ 在三个类中分别添加了一个`name` 属性

  ```java
  // Car 类
  String name = "Car";
  
  // BenZCar 类
  String name = "BenZCar";
  
  // AudiCar 类
  String name = "AudiCar";
  
  ```

  ```java
  // 多态：父类引用指向之类对象
  // 运行时类型是Car, 因为属性没有多态 
  Car benZCar = new BenZCar();
  Car audiCar = new AudiCar();
  
  System.out.println(benZCar.name); // Car
  System.out.println(audiCar.name); // Car
  
  // 运行时类型是BenZCar
  BenZCar benZCar1 = new BenZCar();
  // 运行时类型是AudiCar
  AudiCar audiCar1 = new AudiCar();
  
  System.out.println(benZCar1.name); // BenZCar
  System.out.println(audiCar1.name); // AudiCar
  ```



##### 1.4、方法重载和重写

+ 方法重载和重写
  + 重载：选择了调用方法的版本
  + 重写：明确了调用谁的方法

+ 方法重载：在编译期间就确定了具体需要调用的方法版本

  ```java
  public class Human {
  
  }
  
  class Man extends Human {
  
  }
  
  class Woman extends Human {
  }
  
  
  class Part {
      public void play(Human human) {
          System.out.println("Human开part...");
      }
  
  
      public void play(Man man) {
          System.out.println("Man开part...");
      }
  
  
      public void play(Woman woman) {
          System.out.println("Woman开part...");
      }
  
  
      public static void main(String[] args) {
          Part part = new Part();
  
          Human human = new Human();
          Human man = new Man();
          Human woman = new Woman();
  
          part.play(human); // Human开part...
          part.play(man); // Human开part...
          part.play(woman); // Human开part...
  
      }
  }
  ```

+ 方法重写：先进静态解析再进行动态分派

  ```java
  public class Animal {
      public void eat() {
          System.out.println("Animal eat");
      }
  
      public void eat(String food) {
          System.out.println("Animal eat: " + food);
      }
  }
  
  class Dog extends Animal {
      public void eat() {
          System.out.println("Dog eat");
      }
  
      public void eat(String food) {
          System.out.println("Dog eat: " + food);
      }
  }
  
  class Main {
      public static void main(String[] args) {
          Animal dog1 = new Dog();
          Dog dog2 = new Dog();
  
          dog1.eat(); // Dog eat
          dog1.eat("骨头"); // Dog eat: 骨头
  
          dog2.eat(); // Dog eat
          dog2.eat("骨头"); // Dog eat: 骨头
      }
  }
  
  ```

  

##### 1.5、对象转型

+ `向上转型`：可能会丢失掉自身特有的方法和属性

+ `向下转型`：

+ `instanceof` 关键字

+ 看一个案例

  ```java
  public class Animal {
      public void eat() {
          System.out.println("Animal eat");
      }
  }
  
  class Dog extends Animal {
      public void eat() {
          System.out.println("Dog eat");
      }
  
      public void run() {
          System.out.println("Dog running...");
      }
  }
  
  
  class Cat extends Animal {
      public void eat() {
          System.out.println("Cat eat");
      }
  
      public void play() {
          System.out.println("Dog playing...");
      }
  }
  
  class TestAnimal {
  
      public static void main(String[] args) {
          TestAnimal animal = new TestAnimal();
          animal.t(new Animal());
          // Animal eat
  
  
          animal.t(new Dog());
          // Dog eat
          // Dog running...
  
          animal.t(new Cat());
          // Cat eat
          // Dog playing...
      }
  
      // 向上转型
      public void t(Animal animal) {
          animal.eat();
  
          // 传入的是Dog类型 调用run方法
          if (animal instanceof Dog) {
              // 向下转型
              Dog dog = (Dog) animal;
              dog.run();
          }
          // 传入的是Cat类型 调用play方法
          if (animal instanceof Cat) {
              // 向下转型
              Cat cat = (Cat) animal;
              cat.play();
          }
      }
  }
  ```

  
