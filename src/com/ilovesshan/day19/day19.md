### JavaSE 摸鱼第19天...

#### 1、枚举引入

##### 1.1、使用静态常量来实现功能

+ 在某些情况下，我们表示一些 有且仅有的事物量。例如：

  + 季节只有：春夏秋冬。
  + 月份：1~12月

+ 我们就可以通过静态常量来表示他们

  ```java
  public class IntroduceEnum {
      public static final int SPRING = 1;
      public static final int SUMMER = 2;
      public static final int AUTUMN = 3;
      public static final int WINTER = 4;
  }
  ```

+ 对四个季节常量进行扩展

  ```java
  public class IntroduceEnum {
      public static final Season SPRING = new Season(1, "SPRING");
      public static final Season SUMMER = new Season(1, "SUMMER");
      public static final Season AUTUMN = new Season(1, "AUTUMN");
      public static final Season WINTER = new Season(1, "WINTER");
      
      IntroduceEnum() {}
  
  }
  
  
  class Season {
      private int code;
      private String name;
  
      public Season(int code, String name) {
          this.code = code;
          this.name = name;
      }
  
      public int getCode() {
          return code;
      }
  
      public void setCode(int code) {
          this.code = code;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  }
  ```

  

##### 2.2、使用 枚举实现功能

+ 会发现上面使用 静态常量的方式来实现代码比较繁琐，我们能不能写的更加简单点？

+ 枚举是 `jdk1.5` 的新特性，使用 `enum` 关键字来表示，举个例子：

  ```java
  enum SeasonEnum {
      SPRING, SUMMER, AUTUMN, WINTER;
  }
  ```

+ 是不是 超级简单呢？？？

  

#### 2、枚举常用方法

+ `枚举类.values()` 返回枚举中 全部枚举常量。

+ `枚举类.valueOf()` 返回具有指定名称的指定枚举类型的枚举常量。

+ `枚举常量.name ` ：返回此枚举常量的名称，与其枚举声明中声明的完全相同。

+ `枚举常量.ordinal`：返回此枚举常数的序数（其枚举声明中的位置，其中初始常数的序数为零）。

  ```java
  public class CommMethods {
      public static void main(String[] args) {
          SeasonEnum spring = SeasonEnum.valueOf("SPRING");
          
          String name = spring.name();
          int ordinal = spring.ordinal();
          System.out.println(name);
          System.out.println(ordinal);
  
          SeasonEnum[] values = SeasonEnum.values();
          for (int i = 0; i < values.length; i++) {
              System.out.println(values[i]);
          }
      }
  }
  ```



#### 3、枚举实例添加自己的属性

```java
class EnumExpendTest {
    public static void main(String[] args) {
        EnumExpend[] values = EnumExpend.values();
        for (EnumExpend value : values) {
            System.out.println(value.getName() + ": " + value.getDescribe());
            
             // 春天: 春天到了...
             // 夏天: 夏天到了...
             // 秋天: 秋天到了...
             // 冬天: 冬天到了...
        }
    }
}

public enum EnumExpend {
    SPRING("春天", "春天到了..."),
    SUMMER("夏天", "夏天到了..."),
    AUTUMN("秋天", "秋天到了..."),
    WINTER("冬天", "冬天到了...");

    
    private String name;
    private String describe;
    
    
    EnumExpend() {
    }

    EnumExpend(String message, String describe) {
        this.name = message;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
```



#### 4、枚举静态导入

+  `import com.ilovesshan.enumconatnt.*`
+  `import com.ilovesshan.enumconatnt.SPRING`