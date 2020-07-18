package tech.aistar.day03;

/**
 * 本类用来演示:
 *
 * @Author cxylk
 * @Date 2020/7/18 15:56
 */
public class TestMethod01 {

    //程序的唯一的入口
    public static void main(String[] args) {
        //如何调用自定义的方法 - 关心方法调用的方式

        //调用的方式 -1.直接使用类调用(静态方法)，2.使用对象调用（非静态方法）
        //原则：它是属于谁的，就是谁调用。

        //static登场
        //静态成员初始化的时机
        //当启动程序的时候，JVM加载类进内存的时候，就会立即给静态方法分配空间以及初始化，并且
        //初始化的次数只有一次.静态的方法依赖于类。
        //静态方法可以直接使用类名.方法名调用


        //非静态成员
        //初始化的时机：当每次只要创建对象的时候，就会给非静态方法分配空间以及初始化。
        //非静态方法是依赖于对象的，属于对象
        //非静态方法是使用对象.方法名调用

        //如何创建对象?调用谁(类)里面的方法,就去创建谁的对象
        //语法:类名 对象名=new 类名();

        TestMethod01 t1=new TestMethod01();
        t1.test01();

        //调用静态方法...静态方法属于类的
        TestMethod01.test02();

        test02();//error,因为无法从静态上下文中引用非静态变量this


    }

    public void test01(){
        //test02();ok,因为test02在启动程序的时候已经初始化了，也即是test02出现的时机早
        System.out.println("test01...");
    }

    public static void test02(){

        System.out.println("test02...");


    }
}
