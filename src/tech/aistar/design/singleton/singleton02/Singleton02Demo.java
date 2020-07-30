package tech.aistar.design.singleton.singleton02;

/**
 * 本类功能:单例模式 - 懒汉模式(线程不安全)
 * 类加载进内存的时候，不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候，才会进行初始化
 *
 * @author cxylk
 * @date 2020/7/30 17:52
 */
public class Singleton02Demo {
/*    //2.提供一个本类的实例，但是赋值为null
    private static Singleton02Demo instance=null;

    //1.私有化构造
    private Singleton02Demo(){
        System.out.println("构造...");
    }

    //3.提供一个公开的方法，返回这个类的唯一实例
    public static Singleton02Demo getInstance(){
        //return instance==null?instance=new Singleton02Demo():instance;

        //如果再多线程场景下,对个线程同时调用getInstance方法
        //并且同时判断出instance==null,那么就可能同时执行new Singleton02Demo()
        //所以它在多线程的场景下,不能保证类的实例永远只有1个
        if(null==instance)
            instance=new Singleton02Demo();
        return instance;
    }*/

    //2.为本类提供一个实例,但是赋值为null
    private static Singleton02Demo instance=null;

    //1.私有化构造方法
    private Singleton02Demo(){
        System.out.println("构造...");
    }

    //3.提供一个公开的方法,返回该类的唯一实例
    public static Singleton02Demo getInstance(){
        if(null==instance)
            instance=new Singleton02Demo();
        return instance;
    }
}

class Test02{
    public static void main(String[] args) {
        Singleton02Demo s1=Singleton02Demo.getInstance();
        Singleton02Demo s2=Singleton02Demo.getInstance();

        System.out.println(s1==s2);//true
    }
}
