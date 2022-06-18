### JavaSE 摸鱼第六天...

##### 1、冒泡排序(BubbleSort)

+ 冒泡排序思路就是：

  + 前一个和后一个比较、谁大谁靠后，一轮结束总有一个会排在最后
  + 经过多轮下来、那么数组中的数据就会按照从小大进行排列
  + 一共要比数组长度-1 次、一次要比数组长度-1-i轮

+ 废话不多说、上案例

  ```java
  public class BubbleSort {
      public static void main(String[] args) {
          int[] nums = {10, 30, 4, 0, -20, 45, 100, 23, 49, -100};
  
          for (int i = 0; i < nums.length - 1; i++) {
              // 每比较一次之后、就会确定一个最大的数 那么下次进行下一轮比较时、就可以 -i、减少没必要的比较
              for (int j = 0; j < nums.length - 1 - i; j++) {
                  // 如果前一个比后一个大、那么就交换位置
                  if (nums[j] > nums[j + 1]) {
                      int temp = nums[j + 1];
                      nums[j + 1] = nums[j];
                      nums[j] = temp;
                  }
              }
          }
  
          for (int i = 0; i < nums.length; i++) {
              System.out.println(nums[i]);
          }
      }
  }
  
  ```

  

##### 2、二分查找(BinarySearch)

+ 使用二分查找需要有一个前提，数组中的元素需要是有序的

+ 二分查找思路是：

  + 确定两个边界值、通过边界值找出中间值
  + 先判断一下目标值是否在两个边界值之间，再通过目标值与中间值进行比较
  + 如果相等就找到了，直接退出程序
  + 如果目标值大于中间值、那么 左边界值等于中间值索引+1，如果目标值小中间值、那么 右边界值等于中间值索引-1
  + 一直循环查找、直到找到

+ 废话不多说、上案例

  ```java
  public class BinarySearch {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          int[] nums = {-100, -30, 0, 3, 10, 23, 56, 89, 120, 520};
          int findIndex = -1;
          int leftIndex = 0;
          int rightIndex = nums.length - 1;
          int middleIndex = (leftIndex + rightIndex) / 2;
  
  
          System.out.print("请输入要查找的元素：");
          int targetValue = scanner.nextInt();
  
  
          if (targetValue < nums[leftIndex] || targetValue > nums[rightIndex]) {
              System.out.println("查找的元素不在数组中...");
              return;
          }
  
          if (targetValue == nums[leftIndex]) {
              findIndex = leftIndex;
              System.out.println("找到的索引是:" + findIndex);
              return;
          }
          if (targetValue == nums[rightIndex]) {
              findIndex = rightIndex;
              System.out.println("找到的索引是:" + findIndex);
              return;
          }
  
  
          while (leftIndex < rightIndex) {
              if (nums[middleIndex] == targetValue) {
                  findIndex = middleIndex;
                  System.out.println("找到的索引是:" + findIndex);
                  break;
              } else if (targetValue < nums[middleIndex]) {
                  rightIndex = --middleIndex;
              } else {
                  leftIndex = ++middleIndex;
              }
          }
      }
  }
  ```

  

##### 3、时间和空间复杂度

+ 衡量一段程序的性能好坏、可以通过两个维度来区分
  + 时间：运行的时间长度
  + 空间：运行所占用的空间大小

+ 数据结构和算法 [参考连接](!http://data.biancheng.net/intro/)

##### 4、归并思路

+ 有两个按循序排列好的数组，要求将两个数组合并成一个数组，按照从小到大排

  + 方法一

    ```java
    public class MergeArray {
        public static void main(String[] args) {
            int[] nums1 = {1, 2, 4, 8, 10, 18, 23,};
            int[] nums2 = {3, 5, 6, 7, 8, 18};
            int[] nums3 = new int[nums1.length + nums2.length];
    
            int i = 0;
            int j = 0;
    
            while ((i < nums1.length) && (j < nums2.length)) {
                if (nums1[i] < nums2[j]) {
                    nums3[i + j] = nums1[i];
                    i++;
                } else {
                    nums3[i + j] = nums2[j];
                    j++;
                }
            }
    
            while (i < nums1.length) {
                nums3[i + j] = nums1[i];
                i++;
            }
    
            while (j < nums2.length) {
                nums3[i + j] = nums2[j];
                j++;
            }
        }
    }
    ```

    

  + 方法二

    ```java
    public class MergeArray {
        public static void main(String[] args) {
            int[] nums1 = {1, 2, 4, 8, 10, 18, 23,};
            int[] nums2 = {3, 5, 6, 7, 8, 18};
            int[] nums3 = new int[nums1.length + nums2.length];
    
            int i = 0;
            int j = 0;
    
            while ((i < nums1.length) || (j < nums2.length)) {
                if (i == nums1.length) {
                    nums3[i + j] = nums2[j];
                    j++;
                    continue;
                }
    
                if (j == nums2.length) {
                    nums3[i + j] = nums1[i];
                    i++;
                    continue;
                }
    
                if (nums1[i] < nums2[j]) {
                    nums3[i + j] = nums1[i];
                    i++;
                } else {
                    nums3[i + j] = nums2[j];
                    j++;
                }
            }
        }
    }
    ```

    

##### 5、二维数组

+ 知道用法，了解即可

  ```java
  public class DoubleDimensionalArray {
      public static void main(String[] args) {
  
          // 初始化 给ints在堆空间中声明3个长度 二层长度没有明确规定、可以动态添加元素
          int[][] ints = new int[3][];
  
          ints[0] = new int[]{1};
          ints[1] = new int[]{1, 2};
          ints[2] = new int[]{1, 2, 3};
  
  
          // 遍历二维数组
          for (int i = 0; i < ints.length; i++) {
              for (int j = 0; j < ints[i].length; j++) {
                  System.out.print(ints[i][j]);
              }
              System.out.println();
          }
  
          System.out.println("***********************************************");
  
          int[][] ints1 = new int[2][2];
          ints1[0] = new int[]{1, 2, 3, 4, 5};
          ints1[1] = new int[]{1, 2};
  
  
          // 遍历二维数组
          for (int i = 0; i < ints1.length; i++) {
              for (int j = 0; j < ints1[i].length; j++) {
                  System.out.print(ints1[i][j]);
              }
              System.out.println();
          }
  
  
      }
  
  }
  ```

  

##### 6、杨辉三角

```java
public class YangHuiTriangle {
    public static void main(String[] args) {
        int layer = 10;

        // 初始化二维数组(三角形)
        int[][] triangle = new int[layer][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
        }

        // 将两边全部填充1
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }


        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

```

