package tech.aistar.day05;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/23 10:54
 */
public class ArraySortDemo {
    public static void main(String[] args) {
        int[] arr={3,6,14,29,3,25,5};
        ArraySortDemo a=new ArraySortDemo();

        //System.out.println(Arrays.toString(a.selectSort(arr)));
        //System.out.println(Arrays.toString(a.bubbleSort(arr)));
        System.out.println(Arrays.toString(a.quickSort(arr,0,arr.length-1)));
        //System.out.println(Arrays.toString(a.directInsertSort(arr)));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序算法
     * @param arr
     * @return
     */
    public int[] selectSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    arr[i]=arr[i]^arr[j];
                    arr[j]=arr[i]^arr[j];
                    arr[i]=arr[i]^arr[j];
                }
            }
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //设置标识位避免无意义的判断(比如一个有序的数组)
            boolean flag=false;
            //j<length-1是因为要比较j>j+1,-i的话是因为一趟排序之后，最右边的是最大值，不用再排序，即减掉排好序的值
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j+1]^(arr[j+1]=arr[j])^arr[j];
                    flag=true;
                }
            }
            if(!flag)
                break;
        }
        return arr;
    }

    /**
     * 将数组总剩余的值(从数组中第2个位置开始)依次直接插入到前面
     * 保证前面的序列仍然是一个有序的序列
     * @param arr
     * @return
     */
    public int[] directInsertSort(int[] arr){
        //从第二个位置，假设的是第一个位置就是有序序列

        if(null==arr||arr.length==0)
            return new int[0];
        for (int i = 1; i <arr.length ; i++) {
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                        arr[j]=arr[j-1]^(arr[j-1]=arr[j])^arr[j];
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序
     * @param arr 待排数组
     * @param low 左边开始
     * @param high 右边开始
     * @return
     */
    public int[] quickSort(int[] arr,int low,int high){
        if(null==arr||arr.length==0)
            return new int[0];
        int pos=0;
        if(low<high){
            pos=getPos(arr,low,high);
            quickSort(arr,low,pos-1);
            quickSort(arr,pos+1,high);
        }
        return arr;
    }

    public int getPos(int[] arr,int low,int high){
        int i=low;
        int j=high;
        //把数组的第一个元素作为基准数
        int val=arr[i];
        while(i<j){
            while(i<j&&arr[j]>=val)
                --j;
            arr[i]=arr[j];
            while(i<j&&arr[i]<val)
                ++i;
            arr[j]=arr[i];
        }
        //终止while循环后a[low]的值和a[high]的值一定是相等的
        arr[i]=val;
        return i;
    }
}
