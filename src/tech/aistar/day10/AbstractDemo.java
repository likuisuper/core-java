package tech.aistar.day10;

/**
 * 本类功能:抽象类
 *
 * @author cxylk
 * @date 2020/7/31 12:00
 */
public abstract class AbstractDemo {//抽象类天生就是用来继承的
    //普通属性
    private String name;

    //普通方法
    public void add(){
        System.out.println("add...");
    }

    //定义静态方法
    public static void test3(){
        System.out.println("test3...");
    }

    //抽象方法 - 天生就是用来被子类重写的
    public abstract void test();

    public abstract void sub();

}
class TestAbstractDemo{
    public static void main(String[] args) {
        //1.抽象类不能够被实例化
        //AbstractDemo demo= new AbstractDemo();
    }
}
