package tech.aistar.day03.transfer;

/**
 * 本类功能:方法的参数传递的方式
 *
 * @author cxylk
 * @date 2020/7/20 18:46
 */
public class TransferDemo {
    public static void main(String[] args) {
        //基本类型 - 采用的是值传递.基本类型的变量中保存的就是数据

        int a=10;
        int b=20;

        //方法 - 交换两个变量的数据

        change(a,b);

        System.out.println("a->"+a);//10
        System.out.println("b->"+b);//20
    }

    private static void change(int a, int b) {
        a=a^b;//10^20
        b=a^b;//10^20^20=10
        a=a^b;//10^20^10=20

        System.out.println("a:"+a);//20
        System.out.println("b:"+b);//10
    }
}
