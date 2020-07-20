package tech.aistar.day03.returns;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/20 9:23
 */
public class NoReturnDemo {
    public static void main(String[] args) {
        //无返回类型 - 调用的时候，是不需要使用变量去接收的

        //方法定义时的返回类型是什么，就用什么类型去接收

        //变量的赋值方式 - 可以通过方法进行赋值 - 方法的返回结果赋值给了变量result
        double result=add();
        System.out.println("result:"+result);

        //我们可以使用比方法定义时候的类型大的类型去存储方法的返回结果
        int t=sub();
        System.out.println(t);
    }

    //学习阶段定义成static - 方便调用
    public static void test01(){
        int i=20;
        if(i>12){
            System.out.println("ok");
            return;//用来结束整个方法的，该方法中下面的代码将不会执行
        }
        System.out.println("执行不到");
    }

    public static double add(){
        double m=10.0d;
        double n=20.0d;

        //注意点：返回的结果的类型一定要小于或者等于方法定义时的返回类型
        //返回的结果的类型大于大于方法定义时候的返回类型的时候，那么一定要进行强制类型转换
        int result=(int)(m+n);
        return result;//符合类型自动转换int->double
    }

    public static short sub(){
        int m=10;
        return (short)m;
    }
}
