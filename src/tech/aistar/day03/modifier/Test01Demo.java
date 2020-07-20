package tech.aistar.day03.modifier;

/**
 * 本类功能:调用Test01类中定义的方法
 *
 * 方法的定义者和方法的调用者进行了分离 - 不在同一个类中了
 *
 * @author cxylk
 * @date 2020/7/20 12:56
 */
public class Test01Demo {
    //提供入口
    public static void main(String[] args) {
        //1.创建对象 - 调用谁里面的方法，就去创建谁的对象
        Test01 t=new Test01();

        t.test01();

        //t.test02();//error,因为test02是private的，不允许外部类访问

        Test01.test03();
    }
}
