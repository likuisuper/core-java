package tech.aistar.day05.homework01;
import tech.aistar.util.ArraysUtil;

import java.util.Arrays;

/**
 * 本类功能:统计随机数出现的次数，并且降序排列
 *
 * @author cxylk
 * @date 2020/7/23 16:35
 */
public class CalRandomCount {
    public static void main(String[] args) {
        descendRandom(15);
    }
    public static void descendRandom(int n){
        //1.定义一个长度为15的数组
        //并将随机数放入数组
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            //获取随机数
            int random=(int)(Math.random()*5+1);
            arr[i]=random;
        }

        //输出随机数组
        System.out.println(Arrays.toString(arr));


        //3.调用方法去除重复元素
        int[] arr1=ArraysUtil.delDoubleElement01(arr);

        //输出
        System.out.println(Arrays.toString(arr1));

        //4.将元素与对应的次数放入二维数组中
        int[][] arr2=new int[arr1.length][1];

        for (int i = 0; i < arr1.length; i++) {
            int pos=0;
            for(int j=0;j<arr.length;j++){
                if(arr1[i]==arr[j]){
                    pos++;
                }
            }
            arr2[i]=new int[]{arr1[i],pos};
        }

        //输出二维数组
        System.out.println(Arrays.deepToString(arr2));

        //对二维数组排序
        for (int i = 1; i < arr2.length; i++) {
            for(int j=i;j>0;j--){
                if(arr2[j][1]>arr2[j-1][1]){
                    arr2[j][1]=arr2[j][1]^arr2[j-1][1];
                    arr2[j-1][1]=arr2[j][1]^arr2[j-1][1];
                    arr2[j][1]=arr2[j][1]^arr2[j-1][1];

                    arr2[j][0]=arr2[j][0]^arr2[j-1][0];
                    arr2[j-1][0]=arr2[j][0]^arr2[j-1][0];
                    arr2[j][0]=arr2[j][0]^arr2[j-1][0];
                }
            }
        }

        System.out.println(Arrays.deepToString(arr2));

    }
}
