package tech.aistar.day02;

public class ChangeVarDemo {
    public static void main(String[] args) {
        //1.垃圾版本
        //使用中间变量
        int a=10;
        int b=20;

        //程序
        int temp=a;
        a=b;
        b=temp;

        System.out.println("a:"+a);
        System.out.println("b:"+b);

        //升华 - 异或的特性
        //一个数连续异或同一个数两次，结果是它本身
        int m=100;
        int n=200;

        m=m^n;//m=100^200
        n=m^n;//n=100^200^200=100
        m=m^n;//m=100^200^100=200

        System.out.println("m:"+m);//200
        System.out.println("n:"+n);//100

        //更进一步升华
        int x=500;
        int y=600;
        y=x^(x=y)^y;
        System.out.println("x:"+x);
        System.out.println("y:"+y);

        System.out.println(~9);
        System.out.println(-10>>>2);//不带符号的右移
        System.out.println(-10>>2);//带符号的右移
        System.out.println(2<<2);//左移，左移2位就变成了原来的4倍
    }
}
