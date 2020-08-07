package tech.aistar.day09.importance;

/**
 * 本类功能:类的被动引用1
 *
 * 对于静态字段,只有直接定义这个字段的类才会被初始化,因此通过其子类来引用父类中定义的静态字段
 * 只会触发父类的初始化而不会触发子类的初始化
 *
 * @author cxylk
 * @date 2020/8/7 19:22
 */
class SuperClass{
    static{
        System.out.println("SuperClass init!");
    }

    public static int value=123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
}

public class PassiveReference1 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);//SuperClass init! 123
    }
}
