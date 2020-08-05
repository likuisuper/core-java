package tech.aistar.day12;

import java.math.BigInteger;

/**
 * 本类功能:用BigInteger实现阶乘
 *
 * @author cxylk
 * @date 2020/8/5 17:49
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        System.out.println(fac(6));
    }

    public static BigInteger fac(int n){
        //1.构建一个BigInteger对象
        BigInteger bigInteger=new BigInteger(String.valueOf(n));//构造方法里的参数是String类型的

        //2.判断递归的出口
        if(n==1){
            return BigInteger.ONE;//返回1
        }
        //return n*fac(n-1)
        return bigInteger.multiply(fac(n-1));
    }
}
