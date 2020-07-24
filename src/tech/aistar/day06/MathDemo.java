package tech.aistar.day06;

/**
 * 本类功能:java.lang.Math
 *
 * @author cxylk
 * @date 2020/7/24 12:50
 */
public class MathDemo {
    public static void main(String[] args) {
        //返回小于或等于参数的最大(最接近正无穷大)double值，等于一个数学整小数
        System.out.println(Math.floor(3.5));//3.0
        System.out.println(Math.floor(3.0));//3.0
        System.out.println(Math.floor(-3.5));//-4.0

        //round底层调用floor - >Math.floor(a+1/2)
        //Math.floor(-3.5+0.5)=Math.floor(-3.0)=-3
        System.out.println(Math.round(-3.5));//返回的是long值
        System.out.println(Math.round(3.3));//3

        //绝对值
        System.out.println(Math.abs(-10));//10

        //平方
        System.out.println((int)Math.pow(2,3));//8
        System.out.println(2<<2);//也可通过左移两位，变为原来的4倍

        //开根号
        System.out.println((int)Math.sqrt(9));//3

        //最大值
        System.out.println(Math.max(10,5));//10
    }
}
