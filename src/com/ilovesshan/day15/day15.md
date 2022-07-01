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



