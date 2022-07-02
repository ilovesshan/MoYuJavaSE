### JavaSE 摸鱼第14天...

### 1、API文档

+ `jdk文档`地址：https://www.oracle.com/cn/java/technologies/java-se-api-doc.html
+ `jdk文档` 中介绍了关于Java中各种类，接口和各种方法的使用说明，是一个帮助文档。

### 2、时区、时间戳概念

##### 2.1、时区

+ 为了解决世界各地在时间上的差异，人们定义了时区，时区是地球上的区域使用同一个时间定义。
+ 人们将时区分为24个，它们是中时区（零时区）、东1-12区，西1-12区，每个时区横跨[精度](https://so.csdn.net/so/search?q=精度&spm=1001.2101.3001.7020)15度，时间正好是1小时。
+ 其中中时区就是格林尼治标准时间，以它为基准，东加西减。
+ 我国统一采用北京时间，也就是东八区。

##### 2.2、时间戳

+ 时间戳是指格林威治时间自`1970年1月1日（00:00:00 GMT）`至当前时间的总秒数。它也被称为Unix时间戳（Unix Timestamp）。
+ 在前面测试过 超级数据和超级链表 大数据插入时的耗时时间，就可以通过`System.currentTimeMillis()`获取当前的毫秒数。

### 3、常用日期时间类

##### 3.1、Date

+ Date 这个类大部分方法都被标记以及废弃了(jdk1.8版本)，我们了解常用的(未废弃)即可，剩下的可以通过查阅`jdk文档`了解。 

+ 注意：导包是 `java.util` 下

  ```java
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  public class MyDate {
      public static void main(String[] args) throws InterruptedException {
          // 创建时间对象
          Date date = new Date();
          System.out.println(date); // Fri Jul 01 21:19:56 CST 2022
  
          // 获取时间戳
          long time = date.getTime();
          System.out.println(time); // 1656681653020
  
          // 主线程 睡1s
          Thread.sleep(1000);
  
          Date date1 = new Date();
  
          // a.compareTo(b)
          // a 大于b 1
          // a 小于b -1
          // a 等于b 0
          int compareTo = date1.compareTo(date1);
          System.out.println(compareTo);
  
          // a.after(b) a时间发是否在b时间之后
          System.out.println(date.after(date1)); // false
          System.out.println(date1.after(date)); // true
  
          // 时间格式化
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
          System.out.println(dateFormat.format(date)); // 2022-07-01 09:28:09
          System.out.println(dateFormat.format(date1)); // 2022-07-01 09:28:10
      }
  }
  ```

  

##### 3.2、Calendar

+ `Calendar`类是一个抽象类
+ 它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
+ `Calendar`类 由于修饰符是protected，所以无法直接创建该对象。需要通过别的途径生成该对象。

```java
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MyCalendar {
    public static void main(String[] args) {

        // getInstance() 不传参数、默认会根据当前的环境来选择合适的时区格式
        // Calendar calendar = Calendar.getInstance();

        // 也可以指定参数
        // 时区ID: Asia/Macau  澳门
        // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Macau"));

        // America/New_York 美国纽约
        // Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));

        // TimeZone表示时区  Asia/Shanghai 上海
        // Locale 表示地区。每一个Locale对象都代表了一个特定的地理、政治和文化地区。
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"), Locale.ENGLISH);
        System.out.println(calendar);

        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"), Locale.CHINA);
        System.out.println(calendar1);

        // calendar.getTime() 返回一个 Date对象
        //  calendar.setTime() 接收以一个 Date对象
        Date date = calendar.getTime();
        calendar.setTime(date);

        /**
         * java.util.GregorianCalendar[
         *      time=1656682396309,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
         *      zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,
         *      transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=6,
         *      WEEK_OF_YEAR=27,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=182,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=1,
         *      AM_PM=1,HOUR=9,HOUR_OF_DAY=21,MINUTE=33,SECOND=16,MILLISECOND=309,ZONE_OFFSET=28800000,DST_OFFSET=0
         * ]
         */
        System.out.println(calendar);


        // 获取年
        int year = calendar.get(Calendar.YEAR);

        // 获取月 月份默认从0开始计算 需要+1
        int mouth = calendar.get(Calendar.MONTH) + 1;

        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // 获取时 HOUR_OF_DAY 24小时制   HOUR 12小时制
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 获取分
        int minute = calendar.get(Calendar.MINUTE);

        // 获取秒
        int second = calendar.get(Calendar.SECOND);

        // 2022年7月1日 9时40分16秒
        System.out.println(year + "年" + mouth + "月" + day + "日 " + hour + "时" + minute + "分" + second + "秒");

    }
}

```



##### 3.3、Instant

+ `Instant` 表示时时间上的某一个点、`Instant` 对象和时间戳是一一对应的。

+ `Instant` 类是不可变的和线程安全的。

+ `Instant` 类 一般处理 时间戳相关问题，不处理 年月日这种单位。

  ```java
  import java.time.Duration;
  import java.time.Instant;
  
  public class MyInstant {
      public static void main(String[] args) {
  
          Instant now = Instant.now();
  
          long milli = Instant.now().toEpochMilli();
          // 获取时间戳 1656722851963
          System.out.println("milli = " + milli);
  
          // now = 2022-07-02T00:40:33.317Z UTC时间 但是和标准的北京时间相差 8h
          System.out.println("now = " + now);
  
          // 加 8h
          Instant now1 = now.plusSeconds(60 * 60 * 8);
          // now1 = 2022-07-02T08:40:33.317Z  标准时间
          System.out.println("now1 = " + now1);
  
          // 加 8h
          Instant now2 = now.plus(Duration.ofHours(8));
          // now2 = 2022-07-02T08:40:33.317Z  标准时间
          System.out.println("now2 = " + now2);
  
  
          // 减 8h
          Instant now3 = now1.minus(Duration.ofHours(8));
          System.out.println("now3 = " + now3);
  
      }
  }
  
  ```

  

##### 3.4、本地时间

+ LocalDate

  + `LocalDate` 是一个不可变的类、并且是线程安全的。
  + `LocalDate`是一个不可变的日期时间对象，表示日期，通常被视为年月日。 也可以访问其他日期字段，例如日期，星期几和星期。

  ```java
  import java.time.LocalDate;
  import java.time.Period;
  
  public class MyLocalDate {
      public static void main(String[] args) {
  
          LocalDate localDate = LocalDate.now();
          // localDate = 2022-07-02
          System.out.println("localDate = " + localDate);
  
          // 当前时间基础上 加10年
          LocalDate localDate1 = localDate.plus(Period.ofYears(10));
          // 当前时间基础上 减10年
          LocalDate localDate2 = localDate.minus(Period.ofYears(10));
  
          //localDate1 = 2032-07-02
          System.out.println("localDate1 = " + localDate1);
          // localDate2 = 2012-07-02
          System.out.println("localDate2 = " + localDate2);
  
          // LocalDate.of() 返回一个LocalDate 对象
          LocalDate date = LocalDate.of(2022, 7, 2);
          // date = 2022-07-02
          System.out.println("date = " + date);
  
          // 获取 年 月 日
          System.out.println(date.getYear());
          System.out.println(date.getDayOfMonth());
          System.out.println(date.getDayOfMonth());
         
      }
  }
  
  ```

  

+ LocalTime

  + `LocalTime` 是一个不可变的类、并且是线程安全的。

  + `LocalTime` 是一个不可变的日期时间对象，代表一个时间，通常被看作是时 - 分 - 秒。 时间表示为纳秒精度。 

  + 例如，值“13：45.30.123456789”可以存储在`LocalTime

    ```java
    import java.time.LocalTime;
    import java.time.temporal.ChronoUnit;
    public class MyLocalTime {
        public static void main(String[] args) {
            LocalTime now = LocalTime.now();
            // now = 09:09:46.339
            System.out.println("now = " + now);
    
            // 加 2h
            LocalTime plus = now.plus(2,ChronoUnit.HOURS);
            // 11:13:06.278
            System.out.println(plus);
    
            // 减 2h
            LocalTime minus = now.minus(2,ChronoUnit.HOURS);
            // 7:13:06.278
            System.out.println(minus);
    
    
            LocalTime time = LocalTime.of(12, 12, 12);
            // time = 12:12:12
            System.out.println("time = " + time);
    
            // 获取 时分秒
            System.out.println(now.getHour());
            System.out.println(now.getMinute());
            System.out.println(now.getSecond());
    
        }
    }
    
    ```

    

+ LocalDateTime

  + `LocalDateTime` 代表日期时间，通常被视为年 - 月 - 日 - 时 - 分 - 秒。 

  + 也可以访问其他日期和时间字段，例如日期，星期几和星期。 时间表示为纳秒精度。

  + 这个类是不可变的和线程安全的。

    ```java
    import java.time.LocalDateTime;
    
    public class MyLocalDateTime {
        public static void main(String[] args) {
    
    
            LocalDateTime localDateTime = LocalDateTime.now();
            // localDateTime = 2022-07-02T09:16:58.473
            System.out.println("localDateTime = " + localDateTime);
    
            // 加 10天
            LocalDateTime localDateTime1 = localDateTime.plusDays(10);
            // 2022-07-12T09:17:52.622
            System.out.println(localDateTime1);
            
            // 其他用法 和 LocalDate、LocalTime 很类似
        }
    }
    
    ```

    

+ DateTimeFormatter

  + 时间日期 格式化器，格式化器用于打印和解析日期时间对象。

  ```java
  import java.time.LocalDate;
  import java.time.LocalDateTime;
  import java.time.LocalTime;
  import java.time.format.DateTimeFormatter;
  
  public class MyDateTimeFormatter {
      public static void main(String[] args) {
          // 定义格式化规则
          DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
          DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH时mm分ss秒");
          DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
  
          LocalDate localDate = LocalDate.now();
          LocalTime localTime = LocalTime.now();
          LocalDateTime localDateTime = LocalDateTime.now();
  
          // 格式化 format
          String s1 = localDate.format(formatter1);
          String s2 = localTime.format(formatter2);
          String s3 = localDateTime.format(formatter3);
  
          System.out.println("s1 = " + s1); // 2022年07月02日
          System.out.println("s2 = " + s2); // 09时24分51秒
          System.out.println("s3 = " + s3); // 2022年07月02日 09时24分51秒
  
          // 解析 parse 需要按照规则解析
          
          // 2022-07-02
          System.out.println(LocalDate.parse("2022年07月02日", formatter1)); 
          
          // 09:24:51
          System.out.println(LocalTime.parse("09时24分51秒", formatter2)); 
      
          //2022-07-02T09:24:51
          System.out.println(LocalDateTime.parse("2022年07月02日 09时24分51秒", formatter3)); 
          
      }
  }
  ```

  



