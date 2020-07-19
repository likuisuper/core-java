package tech.aistar.day02.var;

/**
 * 本类功能:变量的作用域
 *
 * @Author: cxylk
 * @Date: 2020/7/19 18:38
 */
public class ScopeVarDemo {

    //定义一个全局变量
    //非静态变量
    int i=200;//声明由对象决定 - 实例变量

    //static -静态的
    //静态变量
    static int j=300;//生命由类决定- 类变量.


    //static关键字的作用 - 当启动程序的时候，JVM就会加载当前类进内存
    //会立即给这个类中的所有的静态成员[静态变量以及静态方法]分配空间以及初始化
    //并且初始化的时机只有一次

    public static void main(String[] args) {
        //定义在方法体中的变量 - 局部变量

        //它能够被允许访问的范围 - 它所在的{}中

        int a=10;

        System.out.println("j:"+j);//在类的任何一个方法中都是允许访问全局变量的
    }
}


//定义类
class MoreClass02{

}