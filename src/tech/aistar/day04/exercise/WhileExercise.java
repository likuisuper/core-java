package tech.aistar.day04.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本类功能:循环练习
 *
 * @author cxylk
 * @date 2020/7/21 10:36
 */
public class WhileExercise {
    public static void main(String[] args) {
        //System.out.println(test01(12,20));
        //System.out.println(commonDivisor(12,20));
        //System.out.println(commonMultiple(12,20));
        primeNumber();
    }


    /**
     * 给一个数字,返回这个数字是几位数.比如传递一个数字为324,返回值3
     *
     * 思路:
     * 1 - 将n不断除10,除一次,计数一次
     * 2 - 除到商是0结束.
     * @param n
     * @return
     */
    public static int getBitCounts(int n){
        //1.计数器
        int count=0;
        //2.推荐的while写法
        while(true){
            int s=n/10;//  324/10=32/10=3/10=0
            count++;
            if(n==0)
                break;
            n=s;
        }
        return count;
    }

    public static int getBitCounts2(int n){
        //1.计数器
        int count=1;//数字至少是1位

        while(n/10!=0){
            count++;
            n=n/10;
        }
        return count;
    }

    /**
     * 求出两个数的最大公约数
     * 让 m 对 n取余，下一步用n 对 上一步的结果取余，依次循环
     * @param m
     * @param n
     * @return
     */
    public static int commonDivisor(int m,int n){
        while(true){
            //1.获取余数
            int s=m%n;

            if(s==0)
                break;
            m=n;

            n=s;
        }
        return n;
    }


    /**
     * 最小公倍数
     * 两个数的乘积/最大公约数
     * @param n
     * @return
     */
    public static int  commonMultiple(int m,int n){
        return m*n/commonDivisor(m,n);
    }

    /**
     * 求出101-199之间所有的质数，每7个换一行
     * 思路：
     * 任意一个数 除 [2-数之前的一个数]
     *
     * 优化 ：[2~开根之前]
     */
    public static void primeNumber(){
        //定义一个计数器
        int count=0;

        for (int i = 101; i < 200; i++) {
            //定义一个标记位
            //定义一个布尔类型 - 假设的每个数都是质数
            boolean flag=true;

            //优化就是将j<i换成j<=Math.sqrt(i)
            for (int j = 2; j <=Math.sqrt(i) ; j++) {
                //判断是否为质数
                if(i%j==0){
                    flag=false;
                    break;//只要找到能证明它不是质数即可
                }
            }
            if(flag){
                System.out.print(i+"\t");
                count++;
                if(count==7){
                    System.out.println();
                    count=0;
                }
            }
        }
    }
}
