package tech.aistar.day09;

/**
 * 本类功能:
 * static修饰的成员在内存中的实例永远只有一个
 * 就是类进内存的时候分配和初始化
 *
 * @author cxylk
 * @date 2020/7/30 19:46
 */
public class StaticIdDemo {
    //它是JVM加载类的时候,分配空间和初始化好了的
    //无论创建多少次对象，它在内存中的实例[快照]仍然只有一个
    //静态属性 - 类属性,是类拥有的,和对象无关

    //来自于这个类的所有实例都是允许共享这个静态属性的
    //所有的对象操作的都是同一个静态属性
    private static int guid=100;

    //对象是不会共享别的对象中的非静态属性,对象的区域是独立隔开的
    //不会共享.本身非静态成员就是属于各个对象独有的

    //非静态属性 - 实例属性
    private int id=1;

    public StaticIdDemo(){
        //this.id=id++;
        this.id=guid++;
    }
    public int getId(){
        return id;
    }

    public static void main(String[] args) {
        StaticIdDemo s1=new StaticIdDemo();
        System.out.println(s1.getId());

        StaticIdDemo s2=new StaticIdDemo();
        System.out.println(s2.getId());

        StaticIdDemo s3=new StaticIdDemo();
        System.out.println(s3.getId());
    }
}
