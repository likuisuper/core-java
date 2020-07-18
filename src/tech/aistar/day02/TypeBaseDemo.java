package tech.aistar.day02;

public class TypeBaseDemo {
    public static void main(String[] args) {

        //当启动程序的时候，就是启动jvm这个进程
        //jvm就会调用main方法
        //当遇到int i的时候，就会立即在jvm的内存[栈区]中开辟一块区域
        //这个区域的大小是Int类型所占的字节[4个字节=32bit]
        // =是一个赋值运算符，把字面量10放到这块Int类型大小的区域中
        //因为内存中的每块区域都是拥有一个内存地址的 -对于用户是不可见的
        //jvm就为这个内存区域取了一个别名 i 变量名

        //实际上底层<变量名，内存地址>
        int i=10;

        //char类型，单个字符，使用单引号表示
        int c1='0'+1;//char类型在参加运算时，会先转换成ASCILL后，在参与运算

        //'a'对应的ascill码的数值是97
        //'A'->65
        //'0'->48
        System.out.println("c1:"+c1);//97

        //long - 长整型 -8个字节 -64bit
        long o1=123;;//ok

        //提高数字的可读性
        long o2=1_234_567;//
        System.out.println("o2:"+o2);//1234567

        //定义一个float - 单精度浮点数(第8位)
        float f=3.14f;
        System.out.println("f:"+f);

        //java中的小数在计算的时候会有精度的丢失
        float f2=0.34567846f;
        System.out.println("f2:"+f2);//0.34567845

        int n=123456789;
        //int类型是不会自动转换成float类型
        float ft=n;
        System.out.println("ft:"+ft);

        System.out.println(0.1+0.2);

        //定义一个boolean - true/false
        boolean flag=true;
        System.out.println("flag:"+flag);

        //char类型 - 单独讲解
        char c=48;
    }
}
