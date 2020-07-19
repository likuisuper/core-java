package tech.aistar.day02.var;

/**
 * 本类功能:final关键字
 *
 * @Author: cxylk
 * @Date: 2020/7/19 16:48
 */
public class FinalDemo {
    //静态常量
    //常量命名规则：全大写，多个单词用_隔开
    static final int EMP_AGE=18;

    public static void main(String[] args) {
        //变量 - 可以多次进行赋值的量
        int a=10;
        a=20;
        a=30;
        System.out.println(a);//30

        final int B=200;
        //B=300;//error

        int age=16;//模拟的就是从页面上输入数据
        if(age>=EMP_AGE){
            System.out.println("代码中不能无故出现一个数字");
        }

        final String s1="a";

        String s2="a"+"b";//"ab"

        String s3=s1+"b";//"ab"

        System.out.println(s2=="ab");
        System.out.println(s3=="ab");
    }
}
