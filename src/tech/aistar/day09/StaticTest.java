package tech.aistar.day09;

/**
 * 本类功能:static中重要的坑
 *
 * @author cxylk
 * @date 2020/8/7 19:03
 */
public class StaticTest {
//    private static int i;//这里无论i是多少，下面都会对其改变
//
//    static{
//        i=5;
//        System.out.println(i);//可以访问,5
//    }

    static{
        i=5;
        //定义在静态代码块之后的静态变量,可以赋值但不能访问
        //否则会报非法向前引用
        //System.out.println(i);
    }

    //private static int i=8;//如果这里已经定义了初值,那么static中不会改变i的值
    private static int i;//如果这里没有定义初值,那么static中会给i赋值

    public static void main(String[] args) {
        //System.out.println(i);//5
        //System.out.println(i);//8
        System.out.println(i);
    }
}


