package tech.aistar.day16.synchronizeds;

import java.util.concurrent.TimeUnit;

/**
 * 本类功能:同步方法块,锁是括号里的对象,对给定对象加锁
 * 进入代码库前要获得给定对象的锁
 *
 * @author cxylk
 * @date 2020/8/14 12:10
 */
public class SynBlockDemo implements Runnable{

    private Object obj=new Object();

    @Override
    public void run() {
        //add();
        add2();
    }

    public void add(){
        //括号中放的是一个this[当前对象]
        synchronized (this){//不同的对象拥有不同的对象锁,同一个对象共享和竞争同一个锁
            System.out.println(Thread.currentThread().getName()+":"+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+2);
        }
    }

    public void add2(){
        //括号中放的是当前类的Class实例
        synchronized (SynBlockDemo.class){//一个类无论被实例化多少次,它在JVM中的class实例永远只有一个
                                         //当前类的所有的实例都是共享这把"类锁"
            System.out.println(Thread.currentThread().getName()+":"+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+2);
        }
    }

    public static void main(String[] args) {
        Runnable r=new SynBlockDemo();

        Thread t1=new Thread(r);
        Thread t2=new Thread(r);

        t1.start();

        t2.start();
    }
}
