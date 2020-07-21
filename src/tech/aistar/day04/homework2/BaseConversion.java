package tech.aistar.day04.homework2;

/**
 * 本类功能:进制转换
 *
 * 要求：给定一个十进制的数(正整数)，输出这个十进制数的最精简的二进制数
 *
 * 比如10 -> 1010
 *
 * @author cxylk
 * @date 2020/7/21 17:34
 */
public class BaseConversion {
    public static void main(String[] args) {
        test(10);
    }
    public static void test(int n){
        if(n<0)
            System.out.println("请输入正整数");
        StringBuilder sb= new StringBuilder();
        int sum;
        for(int i=n;i>=1;i/=2){
            if(i%2==0)
                sum=0;
            else
                sum=1;
            sb.insert(0, sum);
        }
        System.out.println(sb);
    }
}
