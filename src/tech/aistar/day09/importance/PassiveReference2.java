package tech.aistar.day09.importance;

/**
 * 本类功能:被动使用类字段演示2
 *
 * @author cxylk
 * @date 2020/8/7 19:31
 */

class SuperClass1{
    static{
        System.out.println("SuperClass1 init!");
    }

    public static int value=123;
}

public class PassiveReference2 {
    public static void main(String[] args) {
        //并没有输出 "SuperClass init",说明并没有触发类SuperClass的初始化阶段
        //但是触发了另外一个名为Lorg.fenixsoft.class.SuperClass类的初始化
        SuperClass1[] sca=new SuperClass1[10];
    }
}
