package tech.aistar.day04.homework2;

/**
 * 本类功能:求数的阶乘
 *
 * @author cxylk
 * @date 2020/7/21 18:31
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(-9));
    }
    public static int factorial(int n){
        if(n<0)
            return 0;
        if(n==1||n==2)
            return 1;
        return n*factorial(n-1);
    }
}
