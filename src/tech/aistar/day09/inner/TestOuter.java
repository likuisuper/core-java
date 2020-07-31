package tech.aistar.day09.inner;

/**
 * 本类功能:测试类
 *
 * @author cxylk
 * @date 2020/7/30 20:20
 */
public class TestOuter {
    public static void main(String[] args) {
        System.out.println("1.创建成员内部类对象===");

        //1.成员内部类的修饰符不能是私有的
        //2.创建外部类对象
        Outer outer=new Outer();

        //外部类.内部类 对象名=外部类对象.new 内部类();
        Outer.MemberInner m1=outer.new MemberInner();

        m1.test();

        System.out.println("========");

        Outer.MemberInner m2=outer.member();

        m2.test();

        System.out.println("=====2.静态内部类=====");

        //如果静态内部类是public,那么它可以上升成为"顶级类"
        Outer.staticInner s=new Outer.staticInner();

        s.test();

        System.out.println("======3.局部内部类======");

        outer.testLocalInner();

    }

}
