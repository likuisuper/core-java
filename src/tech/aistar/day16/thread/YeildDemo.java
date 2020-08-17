package tech.aistar.day16.thread;

/**
 * 本类功能:线程之间的礼让
 *
 * @author cxylk
 * @date 2020/8/16 13:26
 */
public class YeildDemo {
    public static void main(String[] args) {
        Thread t1=new T1();
        Thread t2=new T1();

        t1.start();

        t2.start();
    }
}
class T1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

            //t1线程先执行，运行到此处，会礼让给t2线程
            if(i==3)
                Thread.yield();
        }
    }
}

