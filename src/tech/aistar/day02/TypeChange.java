package tech.aistar.day02;

/**
 * @Author 箜絔lk
 * @Date 2020/7/17 20:45
 */
public class TypeChange {
    public static void main(String[] args) {
        /*
        //自动类型转换
        //byte->short->int->long
        //byte->short
        byte b=100;

        //可以使用short类型的变量来存储byte类型的变量中的值
        short s=b;

        //int->double
        int n=123456789;
        double d=n;
        System.out.println(d);

        //char->int
        int c='A';
        System.out.println(c);

        //2.强制类型转换
        //大的数据类型 变量max=初始值
        //小的数据类型 变量min=(小的数据类型)变量max

        int m=100;
        byte b2=(byte)m;
        System.out.println("b2:"+b2);//100

        //java中看到一个整数，默认的就是int类型
        byte b1=100;

        //面试题
        short s1=100;

        //类型小的数据和类型大的数据在计算的时候，计算的结果是偏向类型大的一方

        //alt+enter
        s1=(short)(s1+200);

        //无穷包含所有可能性
        double dd=3.64;

        int t=(int)dd;
        System.out.println(t);

        //3.隐式转换
        //推荐定义long
        long time=1203456L;//int+L=int->long

        //场景...int类型在计算机的过程中，并且这种计算尚未结束的时候
        //long a1=123*897*98424289858*456*983*3784L;//不是真实的应用
        //因为前面计算，到最后才转换为L的话可能会超出Long所表示的范围

        //long a2=123L*897*987*456*983*3675;//真实的应用场景，先在前面转换为L

        //3.14是double类型

        //推荐定义double类型
        double price=22.34d;//为了提高可读性
        System.out.println("price:"+price);

        double d2=100;
        System.out.println(d2);//100.0

        System.out.println(10/3);

        System.out.println(9.0/2);//4.5,因为double类型大于int类型

         */
        byte b=10;
        short s=b;
        System.out.println(s);

        int n=123456789;
        double d=n;
        System.out.println(d);

        int c='A';
        System.out.println(c);


        //强制类型转换
        int m=128;
        byte b2=(byte)m;
        System.out.println(b2);

        double d1=299.33;
        int a=(int)d1;
        System.out.println(a);

        int m1=293;
        float f=m1;
        System.out.println(f);

        byte b3=100;
        //b3=b3+1;//会报错
        System.out.println("b3:"+b3);

        //java中，看到小数默认是double类型
        float f1=293.0f;//不加f的话，293.0默认是double类型，转换成float就会报错

        //a2是变量，65535是字面量，jvm就会判断当前字面量是否在char表示的范围中，如果这里是65536，就会报错
        char a2=65535;
        System.out.println(a2);//结果就是65535对应的unicode编码

        //3.隐式转换
        //推荐定义Long
        long time=192993L;//int+L=int->long
        System.out.println(time);

        short s1=3;
        //s1=s1+1;//报错，因为不能隐式的将类型转型为short类型
        s1+=1;//+=会隐式转换
        s1++;//++也会隐式转换
        //上面的语句其实就是将s1+1的计算结果进行了向下转换
        //s1=(short)(s1+1)
        int i=1;
        long j=3;
        //i=i+j;//会报错
        //i+=j;
        i=(int)(i+j);
        System.out.println("i="+i);

        //场景...int类型在计算的过程中,并且这种计算尚未结束的时候
        //long a1 = 123*897*987998987654*456*983*5678L;//不是真实的应用场景

        //long a2 = 123L*897*987*456*983*5678;//真实的应用场景

        //float比较特殊的
        float f2=3.14f;//因为3.14默认是double类型，转换为float会精度丢失

        //推荐定义double类型
        double price=22.34d;//为了提高可读性
        System.out.println("price:"+price);

        double d2=100;
        System.out.println(d2);//100.0

        System.out.println(10/3);
        System.out.println(9.0/2);//4.5
    }
}
