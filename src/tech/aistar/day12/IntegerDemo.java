package tech.aistar.day12;

/**
 * 本类功能:Integer类型的使用
 *
 * @author cxylk
 * @date 2020/8/5 10:42
 */
public class IntegerDemo {
    public static void main(String[] args) {
        //int -> Integer类型
        //构造
        Integer m1=new Integer(10);
        Integer m2=new Integer(10);

        System.out.println(m1==m2);//false

        //利用一个数字形式的字符串来构建一个Integer对象

        //如果传入的不是一个数字形似的字符串,将会抛出一个异常
        //java.lang.NumberFormatException
        //Integer s1=new Integer("AB");

        Integer s1=new Integer("10");//10

        //包装类型是允许进行计算的
        //当包装类型在和基本类型进行计算的时候,底层调用包装类型,s1.intValue()
        System.out.println(s1+20);//30

        //包装类型Integer -> int类型
        //调用的抽象的父类Number中提供的int intValue();
        int n=s1.intValue();
        System.out.println(n);//10

        // 封箱 - 基本数据类型可以自动转换成包装类型
        // 解箱 - 包装类型可以自动转换成基本数据类型

        Integer t=10;//int -> Integer
        int m=t;//Integer -> int
        System.out.println(m);//10

        System.out.println("=======各种比较========");

        Integer p1=new Integer(200);
        int p2=200;
        //当包装类型和基本数据类型进行比较的时候,同样包装类型也会转成基本类型之后再进行比较
        System.out.println(p1==p2);//true

        //[-128-127]之间比较的结果是true,直接从Integer的缓存池中直接拿的
        // 否则返回的是false - 底层重新new 了新的Integer
//        Integer t3=Integer.valueOf(-129);
//        Integer t4=Integer.valueOf(-129);
//        System.out.println(t3==t4);//false

        Integer t3=Integer.valueOf(127);
        Integer t4=Integer.valueOf(127);
        System.out.println(t3==t4);//true
        System.out.println(t3.equals(t4));//true

        //自动封箱的过程实际上底层static Integer valueOf(int i)
        Integer t5=128;
        Integer t6=128;
        System.out.println(t5==t6);//false

        //对象类型要想比较属性的值,推荐是使用equals比较
        System.out.println(t5.equals(t6));//true

        //String ->Integer
        Integer o1=Integer.valueOf("10");
        System.out.println(o1);

        //String ->int
        int o2=Integer.parseInt("120");
        System.out.println(o2);

        System.out.println("===进制转换====");

        //转换成二进制
        System.out.println(Integer.toBinaryString(10));

        //转化成十六进制
        System.out.println(Integer.toHexString(178));

        //转换成八进制
        System.out.println(Integer.toOctalString(26));

        //字段 - int类型的范围
        System.out.println(Integer.MAX_VALUE);//2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648

        System.out.println(o1.toString());

        System.out.println("=====类型转换========");

        //1.String类型和 int 类型
        String str1=String.valueOf(23);

        int n1=Integer.parseInt("34");

        //2.String 和 Integer类型
        Integer n2=new Integer("23");
        System.out.println(n2);
        Integer n3=Integer.valueOf("23");//换成int也可以
        System.out.println(n3);

        String str2=String.valueOf(n3);
        String str3=n3.toString();

        //3.int 类型和 Integer
        Integer n4=new Integer(5);
        int n5=Integer.valueOf(n1);
        System.out.println(n5);

        int n6=n4.intValue();
        System.out.println(n6);

    }
}

