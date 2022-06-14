###  JavaSE 摸鱼第三天...

##### 1、认识数据类型
+ 数据类型分为四类八种

  | 类型名称 | 表示类型 | 占位大小 | 表示范围                               | 默认值 |
  | :------- | -------- | -------- | -------------------------------------- | ------ |
  | byte     | 整形     | 1        | -2^7 ~ 2^7-1                           | 0      |
  | short    | 整形     | 2        | -2^15 ~ 2^15-1                         | 0      |
  | int      | 整形     | 4        | -2^31 ~ 2^31-1                         | 0      |
  | long     | 整形     | 8        | -2^63 ~ 2^63-1                         | 0      |
  | float    | 浮点型   | 4        |                                        | 0.0F   |
  | double   | 浮点型   | 8        |                                        | 0.0D   |
  | char     | 字符型   | 2        | 使用unicode存储\u0000~\uFFFF (0-65535) | 空串   |
  | boolean  | 布尔型   | 1        | true / false                           | false  |

+ 再了解了解一些编码格式

  + ASCII

    + 单个英文(含标点符号)占用 字节数     1

  + UNICODE 

    + 单个英文(含标点符号)占用 字节数     2
    + 单个中文(含标点符号)占用 字节数     2

  + GBK/GB2312

    + GB2312是对GBK的扩展 支持繁体字

    + 单个英文(含标点符号)占用 字节数     1
    + 单个中文(含标点符号)占用 字节数     2

  + UTF-8

    + UTF-8是现在用的最多的最广泛的编码格式

    + 单个英文(含标点符号)占用 字节数     2
    + 单个中文(含标点符号)占用 字节数     3

##### 2、定义变量、变量的命名规范

+ 定义变量的格式 `数据类型 标识符 = 值`

  ```java
  int i = 1;
  double d = 1.1;
  boolean b = true;
  char c = '好';
  ```

+ 变量的命名规范
  + 不能用数字开头
  + 对大小写敏感，每日有长度限制 (但也别太长了)
  + 遵循小驼峰命名，做到见名知意
  + $或者_可以放到任意位置，但不建议放在第一位
  + 不使用汉字作为变量名(程序上可以通过，但是被公司发现直接跑路)

##### 3、数据类型的运算和转换

  + 算术运算

    ```java
    // 算术运算
    byte b = 1;
    short s = 1;
    int i = 1;
    long l = 1L;
    float f = 1.0F;
    double d = 1.0;
    
    // IDEA会报警 要么使用int接收 要么将结果强转成byte
    // byte res1 = b + s;
    int res2 = b + s;
    
    // IDEA会报警 要么使用double接收 要么将结果强转成int
    // int res3 =  b  + d;
    double res4 = b + d;
    
    // IDEA会报警 要么使用long接收 要么将结果强转成int
    // int res5 =  l + i;
    long res5 = l + i;
    
    // 当数值类进行运算时(增加自减不进行转化外)记住以下规则: 
    // 1、没有long类型就将非int类型转int类计算并且返回int
    // 2、有long类型就将非long类型转成long类型计算 并且返回long
    ```

    

  + 逻辑运算

    ```java
    // 逻辑或 &   短路或 &&
    boolean flag1 = true;
    boolean flag2 = false;
    
    System.out.println(flag1 & flag2); // false
    System.out.println(flag1 && flag2); // false
    
    // 逻辑与 |   短路与 ||
    
    System.out.println(flag1 | flag2);  // true
    System.out.println(flag1 || flag2);  // true
    
    
    // 逻辑非 !
    
    System.out.println(!flag1); // false
    System.out.println(!flag2); // true
    ```

| 运算符 | 含义   | 用法       | 说明                                                    |
| ------ | ------ | ---------- | ------------------------------------------------------- |
| &      | 逻辑或 | a & b      | ab都为true结果为true、否则为false                       |
| &&     | 短路或 | a && b     | ab都为true结果为true、否则为false                       |
| \|     | 逻辑与 | a \|  b    | ab都为false结果为false、否则为true                      |
| \|\|   | 短路与 | a  \|\|  b | ab都为false结果为false、否则为true                      |
| !      | 逻辑非 | !a         | 对a进行取反，a为true取反就是false，a为false取反就是true |



  + 赋值运算

    ```java
    // 赋值运算
    int a = 10;
    
    a += 10; // a = a + 10;
    a -= 10; // a = a - 10;
    a *= 10; // a = a * 10;
    a /= 10; // a = a / 10
    ```

    

  + 三目运算

    ```java
    //三目运算语法   表达式 ? 表达式等于true : 表达式等于false
    int i1 = 10;
    int i2 = 20;
    boolean c = true;
    
    int i3 = i1 > i2 ? i1 : i2;
    int i4 = i1 * 10 > i2 - 100 ? i1 : i2;
    int i5 = c ? i1 : i2;
    ```

    

  + 位移运算

    ```java
    // 了解即可
    ```

    

+ 类型转换

  ```java
  // 记住  
  // 所占空间大的转向所占空间小的 需要强转(向下转型)
  // 所占空间小的转向所占空间大的 不需要手动转(jvm帮你转)
  ```

  
