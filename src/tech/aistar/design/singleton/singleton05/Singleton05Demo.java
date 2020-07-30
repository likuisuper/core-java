package tech.aistar.design.singleton.singleton05;

/**
 * 本类功能:单例模式 - 懒汉模式(线程安全) - 双重检测
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化
 *
 * @author cxylk
 * @date 2020/7/30 19:03
 */
public class Singleton05Demo {
    //2.提供本类的一个唯一实例,但是赋值为null
    private static volatile Singleton05Demo instance=null;

    //1.私有化构造
    private Singleton05Demo(){
        System.out.println("构造...");
    }

    //3.提供一个公开的方法来返回这个类的唯一实例
    public static Singleton05Demo getInstance(){
        //是存在程序的 - 不需要控制多线程安全的,是所有的线程都行允许同时执行的,为了不影响整个性能
        //没有必要锁住整个getInstance方法的

        if(null==instance){//第一个判断的目的是避免产生太多的昂贵的"锁资源"对象

            //synchronize代码块中的程序在同一个时刻仍然只能由单个线程去执行

            //哪个线程抢到这个锁资源,那么就由这个线程进去执行,其他线程依然处于等待状态
            synchronized (Singleton05Demo.class){

                //如果A线程进来之后,对instance赋值完毕之后,A线程一旦执行完毕之后,将会释放锁资源
                //一旦A释放了锁资源之后,其他等待的线程,将会继续抢锁,假设被C抢到了,由线程C进来执行,
                //发现instance已经不为空,所以不会再进行初始化,直接返回

                if(null==instance){//第二个判断的目的,保证再次抢到锁资源进来的这个线程不会去进行初始化了
                    instance=new Singleton05Demo();
                }
            }
        }
        return instance;
    }
}
