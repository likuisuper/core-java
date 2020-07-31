package tech.aistar.day10;

/**
 * 本类功能:子类继承抽象父类
 *
 * @author cxylk
 * @date 2020/7/31 12:04



 * 当一个普通的类去继承一个抽象的父类的时候,那么在编译期间
 * 要求普通子类强制去重写父类中的所有的抽象方法.
 * 非抽象方法,子类可以选择性重写或者不重写
 */
public class AbSubDemo extends AbstractDemo{

    @Override
    public void test() {

    }

    @Override
    public void sub() {

    }
}

//当一个抽象的子类去继承一个抽象的父类的时候,那么在编译期间,
// 抽象的子类可以选择性去重写父类中的所有的方法[包括抽象和非抽象]
abstract class AbSubDemo2 extends AbstractDemo{
    public abstract void testSub02();
}

//重写父类中的abstract方法和它父类的父类的abstract方法
class Sub02 extends AbSubDemo2 {

    @Override
    public void testSub02() {
        System.out.println("sub02...");
    }

    @Override
    public void test() {

    }

    @Override
    public void sub() {
        System.out.println("sub..");
    }
}

class TestAbSub{
    public static void main(String[] args) {
        //抽象类天生就是为了多态
        AbstractDemo sup=new AbSubDemo();
        //调用抽象方法,如果子类没有重写父类中的方法,这里调用的就是父类中的方法
        sup.test();

        AbstractDemo sup02=new Sub02();
        sup02.sub();

        //抽象类缺点 - 产生了很多个派生类,代码臃肿了...
        //匿名内部类

        AbstractDemo demo=new AbstractDemo() {//匿名内部类,创建了匿名内部类的对象
            @Override
            public void test() {
                System.out.println("demo...test...");
            }

            @Override
            public void sub() {
                System.out.println("demo...sub...");
            }
        };
        demo.test();
    }
}

