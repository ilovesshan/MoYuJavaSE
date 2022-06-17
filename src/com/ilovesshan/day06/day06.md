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

+ 使用二分查找需要有一个前提，就是数组中的元素需要是有序的

+ 二分查找思路是：
  + 确定两个边界值、通过边界值找出中间值，
  + 再通过目标值与中间值进行大小比较
  + 如果相等就找到了，直接退出
  + 如果目标值大于中间值、那么 左边界值等于中间值索引+1，如果目标值小中间值、那么 右边界值等于中间值索引-1

##### 3、时间和空间复杂度

