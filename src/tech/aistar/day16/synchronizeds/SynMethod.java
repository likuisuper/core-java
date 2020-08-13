package tech.aistar.day16.synchronizeds;

/**
 * 本类功能:synchronized进行同步代码
 *
 * 同步的代码 - 在某个时刻，只能由一个线程去执行，其他线程只能处于阻塞等待状态
 * 等到抢到"锁"资源的线程执行同步代码结束之后，释放"锁"之后，其他线程才有可能继续抢"锁"
 * 谁抢到"锁",谁进去
 *
 * @author cxylk
 * @date 2020/8/13 20:26
 */
public class SynMethod implements Runnable{

    //修饰普通方法
    //代表 - 哪个线程要想执行同步代码,必须先得到"锁",在它释放"锁"之前,其他线程都是不允许进入的

    //当synchronized用来修饰非静态方法的时候 - "对象锁"
    //只要是同一个对象,那么共享和竞争同一个"锁"

    //如果是不同的对象,争抢的"锁"就是不同的"锁"
    public synchronized void add(){
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
    }

    public static void main(String[] args) {
        Runnable r1=new SynMethod();
        Runnable r2=new SynMethod();
        Runnable r3=new SynMethod();

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(r3);

        t1.start();

        t2.start();

        t3.start();
    }
}
