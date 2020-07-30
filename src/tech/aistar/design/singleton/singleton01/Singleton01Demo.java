package tech.aistar.design.singleton.singleton01;

/**
 * 本类功能:单例模式 - 饿汉模式(线程安全的) - 只要类被加载到内存中，立即就会执行初始化
 *
 * 目的:保证在整个应用程序中,某个类的具体实例永远只有一份
 *
 * @author cxylk
 * @date 2020/7/30 15:22
 */
public class Singleton01Demo {//重量级对象
//    //2.提供一个该类的唯一实例
//    private static Singleton01Demo instance=new Singleton01Demo();
//
//    //1.私有化构造 - 不让外界去new
//    private Singleton01Demo(){
//        System.out.println("构造...");//进行初始化工作的
//    }
//
//    //3.提供一个公开的方法,来返回这个类的唯一实例instance
//    public static Singleton01Demo getInstance(){
//        return instance;
//    }

/*    //2.提供一个该类的唯一实例
    private static Singleton01Demo instance=new Singleton01Demo();

    //1.私有化构造 - 不让外界去new
    public Singleton01Demo{
        System.out.println("构造...");//进行初始化工作的
    }

    //3.提供一个公开的方法,来返回该类的唯一实例
    public static Singleton01Demo getInstance(){
        return instance;
    }*/

    //2.提供一个该类的唯一实例
    private static Singleton01Demo instance=new Singleton01Demo();

    //1.私有化构造 - 不让外界去new
    private Singleton01Demo(){
        System.out.println("构造...");
    }

    //提供一个公开的方法，来返回该类的唯一实例
    public static Singleton01Demo getInstance(){
        return instance;
    }

}

class TestSingleTon01Demo{
    public static void main(String[] args) {
/*        //只有第一次加载Singleton01Demo类的时候,才会实例化
        Singleton01Demo s1=Singleton01Demo.getInstance();

        //后面无论调用多少次getInstance方法,只是在获取之前创建好的实例
        Singleton01Demo s2=Singleton01Demo.getInstance();
        System.out.println(s1==s2);//true*/



/*        //只有第一次加载Singleton01Demo类的时候，才会实例化
        Singleton01Demo s1=Singleton01Demo.getInstance();

        //后面无论调用多少次getInstance方法,只是在获取之前创建好的实例
        Singleton01Demo s2=Singleton01Demo.getInstance();
        System.out.println(s1==s2);//true*/

        //Singleton01Demo s1=new Singleton01Demo(); //new 一个private的构造方法会报错
        Singleton01Demo s1=Singleton01Demo.getInstance();
    }
}
