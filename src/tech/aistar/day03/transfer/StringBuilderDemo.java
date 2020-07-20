package tech.aistar.day03.transfer;

/**
 * 本类功能:值传递
 *
 * @author cxylk
 * @date 2020/7/20 17:53
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder x=new StringBuilder("A");
        StringBuilder y=new StringBuilder("B");

        //将x,y的副本传递给方法
        appenStr(x,y);

        System.out.println("x:"+x);//不变，依然是A
        System.out.println("y:"+y);//变为BB
    }
    public static void appenStr(StringBuilder x1,StringBuilder y1){
        //将y1的值(即y1的地址)赋值给x1,x1现在指向y1
        x1=y1;//一个引用在同一时刻只能指向一个对象
        y1.append("B");//y1的内容变了
        System.out.println("x1->"+x1);//x1中的内容现在变成BB
        System.out.println("y1->"+y1);//y1中内容变为BB

        //过程
        // x------>A<-------x1
        // y------>B<-------y1

        //方法调用后
        //x------->A(不变)

        //y------->B<-------y1,x1也指向B
    }
}
