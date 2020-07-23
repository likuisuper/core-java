package tech.aistar.day05;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/23 10:05
 */
public class ArrayBinarySearchDemo {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,9,23};

        //int i= Arrays.binarySearch(arr,3);

        int index=binarySearchs(arr,3);
        System.out.println(index);
    }
    /**
     * * 二分查找 - 二分搜索法 - 每次比较完之后,都会减少一半的数据.
     *
     *   业务中有的数据是唯一的.
     *
     *   **找出数组中某个元素第一次出现的位置.**
     *
     *   前提:对排好序的数组可以采用二分查找.
     *
     *   1,2,3,4,5,6,7,8
     *
     *   * 起始索引 - startIndex - 0
     *   * 结束索引 - endIndex - 1
     *   * 中间索引 - centerIndex = (startIndex + endIndex)/2 = 3
     *
     *   确定中间索引的值是4.
     *
     *   * 正好找的值就是4,直接返回centerIndex.
     *
     *   * 如果找的目标值比中间索引处的值大.
     *
     *     startIndex = centerIndex+1;
     *
     *   * 如果找的目标值比中间索引处的值小.
     *
     *     endIndex = centerIndex-1;
     * @param arr
     * @param target
     * @return
     */
    private static int binarySearchs(int[] arr, int target) {
        //1. 起始索引
        int start = 0;
        //2. 结束索引
        int end = arr.length-1;

        //3. 循环
        while(start<=end){
            //3. 中间索引
            int mid = (start + end) >>> 1;//位运算，相当于除2

            if(target == arr[mid])
                return mid;
            else if(target>arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
}
