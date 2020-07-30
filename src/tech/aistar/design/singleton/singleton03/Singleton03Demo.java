package tech.aistar.design.singleton.singleton03;

/**
 * 本类功能:单例模式 - 懒汉模式(线程安全)
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化
 *
 * @author cxylk
 * @date 2020/7/30 18:17
 */
public class Singleton03Demo {
    //2.提供本类的唯一实例,但是赋值为null
    private static Singleton03Demo instance=null;

    //1.私有化构造
    private Singleton03Demo(){
        System.out.println("构造...");
    }

    //3.提供一个公开的方法来返回该类的唯一实例

    //synchronized - 给这个方法加锁
    //加锁的目的,当多个线程同时到达想要执行getInstance方法的时候
    //哪个线程先抢到这个"锁"资源,那么就由哪个线程进去执行,其它线程
    //将会进入到阻塞状态(等待状态)
    //优先执行的这个线程执行完整个方法中的程序之后,释放锁资源

    //曾经拥有过锁资源的线程释放锁之后,仍然还会继续进行争抢锁资源

    //弊端
    //1.多线程环境下 - 性能是低下的
    //2.只有有线程尝试调用getInstance方法成功,那么就会不断产生"锁"对象
    //"锁"既然是对象,对象肯定是占内存,锁资源也是一个昂贵的资源
    public synchronized static Singleton03Demo getInstance(){
        if(null == instance)
            instance=new Singleton03Demo();
        return instance;
    }
}
