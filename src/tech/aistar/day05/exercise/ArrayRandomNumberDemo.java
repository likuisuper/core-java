package tech.aistar.day05.exercise;

import java.util.Arrays;

/**
 * 本类功能:数组长度5个，里面存放1-6之间的随机整数，要求是不能有重复的数据
 *
 * @author cxylk
 * @date 2020/7/24 20:35
 */
public class ArrayRandomNumberDemo {
    public static void main(String[] args) {
        int[] arr=new int[5];
        insert(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void insert(int[] arr){
        //1.对数组进行赋值
        for (int i = 0; i < arr.length; i++) {
            int n=(int)(Math.random()*6+1);//产生一个随机数

            //先把当前的随机数放入数组，而不是全把随机数都放入数组中
            arr[i]=n;

            //判断n在arr中之前是否曾经出现过
            //如归出现过 - "后悔"
            for(int j=0;j<i;j++){
                if(arr[j]==n){
                    //"后悔了..."
                    i--;
                    break;
                }
            }
        }

    }
}
