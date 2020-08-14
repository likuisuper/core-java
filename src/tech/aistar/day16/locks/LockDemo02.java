package tech.aistar.day16.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本类功能:Lock重新做
 * abcABC123abcABC123abcABC123 - 三个线程依次执行
 *
 * @author cxylk
 * @date 2020/8/14 20:58
 */
public class LockDemo02 {
    private Lock lock=new ReentrantLock();

    //有三个线程,创建三个队列
    //特点 - 很方便进行选择性通知某个等待队列的线程

    //abc
    private Condition c1=lock.newCondition();
    //ABC
    private Condition c2=lock.newCondition();
    //123
    private Condition c3=lock.newCondition();

    //定义一个变量
    private int count=0;

    public void printLower(){
        lock.lock();//手动申请锁

        //lock.lock();//手动申请锁,将这句话放到循环外面提高性能
        try {
            //代码放到try里面
            while (true) {
                if (count != 0) {
                    //等待
                    c1.await();
                }
                System.out.print("abc");
                Thread.sleep(500);
                //打印完后加1
                count = 1;
                //唤醒c2这个等待队列上的线程
                c2.signal();
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();//手动释放锁
        }
    }

    public void printUpper(){
        lock.lock();//手动申请锁

        //lock.lock();//手动申请锁,将这句话放到循环外面提高性能
        try {
            //代码放到try里面
            while (true) {
                if (count != 1) {
                    //等待
                    c2.await();
                }
                System.out.print("ABC");
                Thread.sleep(500);
                //打印完后加1
                count = 2;
                //唤醒c3这个等待队列上的线程
                c3.signal();
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();//手动释放锁
        }
    }

    public void printNum(){
        lock.lock();//手动申请锁

        //lock.lock();//手动申请锁,将这句话放到循环外面提高性能
        try {
            //代码放到try里面
            while (true) {
                if (count != 2) {
                    //等待
                    c3.await();
                }
                System.out.print("123");
                Thread.sleep(500);
                count = 0;
                //唤醒c1这个等待队列上的线程
                c1.signal();
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            lock.unlock();//手动释放锁
        }
    }

    public static void main(String[] args) {
        LockDemo02 demo=new LockDemo02();

        //分别创建三个线程
        Thread t1=new Thread(()->{
            demo.printLower();
        });

        Thread t2=new Thread(()->{
            demo.printUpper();
        });

        Thread t3=new Thread(()->{
            demo.printNum();
        });

        t1.start();

        t2.start();

        t3.start();
    }
}
