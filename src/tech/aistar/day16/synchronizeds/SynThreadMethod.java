package tech.aistar.day16.synchronizeds;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/13 20:45
 */
public class SynThreadMethod extends Thread{

    //修饰普通方法
    //代表 - 哪个线程要想执行同步代码,必须先得到"锁",在它释放锁之前，其他线程都是不允许进入的

    //当synchronized用来修饰非静态方法的时候 - "对象锁"
    //只要是同一对象，那么共享和竞争同一个锁
    //如果是不同的对象，争抢的锁就是不同的锁

    public synchronized void add(){
        System.out.println(Thread.currentThread().getName()+":"+1);

        try {
            //睡一下其实就是实现并发
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+2);
    }

    /**
     * 修改静态方法 - "类锁" - 只要是这个类衍生出来的任何对象,抢的都是同一把"锁"
     */
    public synchronized static void add2(){
        System.out.println(Thread.currentThread().getName()+":"+1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+":"+2);
    }

    @Override
    public void run() {
        add();

        //add2();
    }

    public static void main(String[] args) {
        Thread t1=new SynThreadMethod();
        Thread t2=new SynThreadMethod();
        Thread t3=new SynThreadMethod();

        t1.start();
        t2.start();
        t3.start();
    }
}
