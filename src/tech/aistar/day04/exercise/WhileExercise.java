package tech.aistar.day04.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 本类功能:
 *
 * 给一个数字,返回这个数字是几位数.比如传递一个数字为324,返回值3
 *
 * 思路:
 * 1 - 将n不断除10,除一次,计数一次
 * 2 - 除到商是0结束.
 *
 * @author cxylk
 * @date 2020/7/21 10:36
 */
public class WhileExercise {
    public static void main(String[] args) {
        //System.out.println(test01(12,20));
        test04(10);
    }

    public static int test(int n){
        //1.计数器
        int count=0;
        //2.推荐的while写法
        while(true){
            int s=n/10;
            count++;
            if(n==0)
                break;
            n=s;
        }
        return count;
    }

    public static String test01(int m,int n){
        int l=m*n;
        int s=m%n;
        while(true){
            int s1=n%s;
            if(s1==0)
                break;
            s=s1;
        }
        return s+" "+(l/s);
    }

    public static void test03(){
/*        int count=0;
        int m=101;
        while(m<=199){
            if(m)
        }*/
    }

    public static void test04(int n){
/*        List<Integer> list=new ArrayList<Integer>();
        int r=0;
        while(true){
            int m=n/2;
            r=n%2;
            n=m;
            list.add(0,r);
            if(m==0)
                break;
        }
        for(int x:list)
            System.out.print(x);
        System.out.println();*/

        int sum;
        StringBuilder result= new StringBuilder();
        for(int i=n;i>=1;i/=2){
            if(i%2==0)
                sum=0;
            else
                sum=1;
            result.insert(0, sum);
        }
        System.out.println(result);
    }
}
