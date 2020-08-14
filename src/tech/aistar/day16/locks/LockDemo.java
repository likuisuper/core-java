package tech.aistar.day16.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本类功能:Lock - 高并发,性能优于synchronized
 *
 * @author cxylk
 * @date 2020/8/14 20:42
 */
public class LockDemo extends Thread{

    //lock是显示锁
    private Lock lock =new ReentrantLock();

    public void add(){
        //出现异常的时候是不会释放锁的
        //显示锁  -手动申请锁以及手动释放锁[finally]

        //对象锁
        lock.lock();//开始申请锁
        //同步代码 - 某个时刻只能由一个线程进入执行,然后直到运行unlock才会主动释放锁
        try {
            System.out.println(Thread.currentThread().getName()+":"+1);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+":"+2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//手动释放锁
        }
    }

    public static void main(String[] args) {
        LockDemo demo=new LockDemo();

        Thread t1=new Thread(()->{
            demo.add();
        });
        t1.setName("one");

        Thread t2=new Thread(()->{
            demo.add();
        });
        t2.setName("two");

        t1.start();
        t2.start();
    }
}
