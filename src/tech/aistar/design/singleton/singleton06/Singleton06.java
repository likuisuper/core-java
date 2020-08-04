package tech.aistar.design.singleton.singleton06;

/**
 * 本类功能:登记式/静态内部类
 *
 * 加载外部类,但是没有使用到静态内部类的时候,静态内部类是不会被加载 - 懒
 *
 * 这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持
 *
 * @author cxylk
 * @date 2020/7/30 19:09
 */
public class Singleton06 {

    //私有化构造
    private Singleton06(){
        System.out.println("构造...");
    }

    //静态内部类
    private static class SingletonHelper{
        //JVM确保INSTANCE只被初始化一次
        private static final Singleton06 INSTANCE=new Singleton06();
    }

    public static Singleton06 getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
