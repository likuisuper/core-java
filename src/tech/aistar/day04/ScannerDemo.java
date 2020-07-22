package tech.aistar.day04;

import java.util.Scanner;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/22 8:25
 */
public class ScannerDemo {
    public static void main(String[] args) {
        //1.创建Scanner对象
        Scanner sc=new Scanner(System.in);

        System.out.println("请你输出姓名:>");
        String name=sc.nextLine();//从键盘输入获取字符串
        System.out.println("name:"+name);

        System.out.println("请你输入年龄:>");

        //当程序执行到此处的时候，将会进入到阻塞状态，等待用户进行输入
        //当用户输入完毕后，按下enter之后，那么程序才会继续向前进行

        //nextInt方法只能接受整数
        //否则会抛出异常

        int age=sc.nextInt();

        System.out.println("age:"+age);

        //nextDouble是支持接受整数和小数的 - 符合类型的自动转换
        double height=sc.nextDouble();

        System.out.println("height:"+height);

        //场景：在使用nextLine之前如果使用了nextInt或者nextDouble
        //那么将会导致nextLine失效[就不会进入阻塞状态等待用户进行输入]

//        System.out.println("请输入你的姓名:->");
//        String name=sc.nextLine();//从键盘输入字符串
//        System.out.println("name:"+name);
    }
}
