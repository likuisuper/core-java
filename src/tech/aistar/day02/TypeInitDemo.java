package tech.aistar.day02;

/**
 * @Author 箜絔lk
 * @Date 2020/7/17 21:14
 */
public class TypeInitDemo {
    public static void main(String[] args) {
        //数据类型 变量 [=初始值]

        //1.定义变量的同时进行赋值
        int i=10;

        //2.先定义一个变量
        int a;//在栈中申请并且开辟区域-大小由数据类型决定

        //再进行赋值
        a=100;

        //变量在使用之前必须要进行初始化操作
        System.out.println(a);
        //3.可以同时对多个变量进行赋值操作
        //仅仅只会对z进行了初始化操作,x和y尚未赋值
        //int x,y,z=100;

        //三个变量都进行了赋值操作
        int x=30,y=60,z=100;
        System.out.println(x);

        //4. 链式赋值
        int x1,x2,x3;
        x1 = x2 = x3 = 100;

        //5. 通过表达式进行赋值操作
        //表达式 - 由变量或者字面量以及运算符组成的合法的语句
        int x5 = x1 + 100;
        System.out.println(x5);//200

        //6. 暂时了解的
        //可以通过方法进行赋值

        //调用方法之后返回的结果赋值到变量中去.
        int result = getResult();
        System.out.println("result:"+result);
    }

    //    自定义方法
    public static int getResult(){
        return 500;
    }

}
