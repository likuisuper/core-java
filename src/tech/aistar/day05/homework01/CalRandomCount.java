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
        //创建一个长度为15的数组
        int[] arr=new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*5+1);//1-6之间的随机数
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("==============");


        descendRandom(arr);
    }
    public static void descendRandom(int[] arr){
        //1.定义一个数组，接收原数组后去重后的元素
        int[] temp=ArraysUtil.delDoubleElement01(arr);

        System.out.println(Arrays.toString(temp));

        //2.确定二维数组的长度，行数就是一维数组的长度
        int[][] counts=new int[temp.length][2];

        //定义一个下标计数器
        int pos=0;

        //3.统计每个随机数出现的次数
        for (int i = 0; i < temp.length; i++) {
            //i每次循环一次后就置零，比较下一个元素出现的次数
            int count=0;

            for (int j = 0; j < arr.length; j++) {
                if(temp[i]==arr[j]){
                    count++;
                }
            }

            //统计好了当前的temp[i]出现的次数了
            counts[pos++]=new int[]{temp[i],count};
        }

        System.out.println(Arrays.deepToString(counts));

        //4.排序，遍历counts

        for (int i = 0; i < counts.length; i++) {
            for (int j = i+1; j < counts.length; j++) {
                //如果第一行第一列的值小于第二行第一列的值，交换位置，依次循环
                if(counts[i][1]<counts[j][1]){
                    int[] tmp=counts[i];
                    counts[i]=counts[j];
                    counts[j]=tmp;
                }
            }
        }

        System.out.println(Arrays.deepToString(counts));
    }
}
