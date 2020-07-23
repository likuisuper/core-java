package tech.aistar.day05.homework01;

import java.util.Arrays;

/**
 * 本类功能:利用二维数组打印杨辉三角
 *
 * @author cxylk
 * @date 2020/7/23 15:19
 */
public class TwoArrayTriangle {
    public static void main(String[] args) {
        print(5);
    }

    public static void print(int n){
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            arr[i][0]=1;//第一列永远为1
            for(int j=0;j<=i;j++){
                if(j==0){
                    System.out.print(arr[i][j]+" ");//如果第一列为1，就输出
                    continue;//跳过本次循环
                }
                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];//如果不是第一列的话，计算值
                System.out.print(arr[i][j]+" ");
            }
            //一行结束之后换行
            System.out.println();
        }
    }

}
