package tech.aistar.day12;

import java.math.BigDecimal;

/**
 * 本类功能:可以使用BigDecimal对象来处理小数运行的时候精度丢失的问题
 *
 * @author cxylk
 * @date 2020/8/5 18:01
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        double d=0.1d;

        //double ->String
        String first=String.valueOf(d);

        //String ->double
//        double d1=Double.parseDouble(first);
//        System.out.println(d1);

        //构造方法里的参数类型是String
        BigDecimal b1=new BigDecimal(first);
        BigDecimal b2=new BigDecimal("0.2");
        //b1+b2
        System.out.println(b1.add(b2));//输出为0.3

        //System.out.println(0.1+0.2);//0.30000000000000004
        //System.out.println((0.1*10+0.2*10)/10);//0.3
    }
}
