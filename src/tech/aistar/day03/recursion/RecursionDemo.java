package tech.aistar.day03.recursion;

/**
 * 本类功能:递归算法
 *
 * @author cxylk
 * @date 2020/7/20 10:53
 */
public class RecursionDemo {
    /**
     * 斐波那契数
     * @param n:位置
     * @return 值
     */
    public static int fei(int n){
        //1.指明递归的出口
        if(n==1||n==2)
            return 1;
        return fei(n-1)+fei(n-2);

        //fei(5)=fei(4)+                    fei(3)
        //       fei(3)+       fei(2)     + fei(2)+fei(1)
        //       fei(2)+fei(1)
        //5
    }
    /**
     * 求出m,n的最大公约数
     * @param m
     * @param n
     * @return 最大公约数
     */
    public static int common(int m,int n){
        if(m % n==0)
            return n;
        return common(n,m%n);
    }

    public static void main(String[] args) {
        System.out.println(common(12,20));
        System.out.println(fei(5));
    }
}
