package tech.aistar.day07;

import java.util.Arrays;

/**
 * 本类功能:测试类
 *
 * @author cxylk
 * @date 2020/7/28 13:34
 */
public class StudentTest {
    public static void main(String[] args) {
        //对属性没有封装之前，是这样操作属性的
        //1.创建Student类的对象

        //通过new关键字在JVM的内存的堆里面申请一块空间，然后进行对象的初始化
        //然后将这个对象在堆空间中的内存地址赋值给了引用s,保存在栈中

        //s的本质 - 引用
        Student s=new Student();

        System.out.println(s);

        //可以在外界直接操作对象的属性 - 非常不推荐，也是非常不安全的
        //不利用程序的可维护性，操作的系统都直接公布了，没有进行屏蔽
        s.id=100;
        s.id=200;

        System.out.println(s.id);//访问属性

        s.name="习大大";

        //对参数进行有效性判断

        System.out.println(s.name);

        System.out.println(Arrays.toString(s.hobbies));

        //对象类型如果没有进行赋值，那么默认值都是null

        System.out.println(s.classes);//null

        System.out.println("===华丽丽的的分割线===");
        //创建一个特殊的"数组"[存放不同类型的多条数据]
        Student s1=new Student();

        //往"数组中"放入值
        s1.id=100;
        s1.name="jack";

        s1.hobbies=new String[]{"sleeping","coding"};

        System.out.println(s1.id+":"+s1.name+":"+Arrays.toString(s1.hobbies));
    }
}
