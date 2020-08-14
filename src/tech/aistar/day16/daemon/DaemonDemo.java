package tech.aistar.day16.daemon;

/**
 * 本类功能:守护线程
 *
 * 守护线程 - 后台守护现线程
 *
 * 什么时候进程运行结束?  -当后台只剩下后台守护线程在执行的时候,就可以认为进程已经结束了
 *
 * 一个进程的结束,是不需要等待后台守护线程结束才退出
 *
 * JVM进程启动  - Main线程以及GC线程[后台守护线程]
 * 当main线程执行结束,JVM进程就可以结束了
 *
 * @author cxylk
 * @date 2020/8/14 18:56
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread t1=new NonDaemonDemo01();
        Thread t2=new DaemonDemo02();

        t1.setName("数字线程");

        t2.setName("字母线程");

        t2.setDaemon(true);//将t2设置成守护线程

        t1.start();
        t2.start();
    }
}

//非守护线程
class NonDaemonDemo01 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//守护线程
class DaemonDemo02 extends Thread{
    @Override
    public void run() {
        for (int i = 97; i <=123 ; i++) {
            System.out.println((char)i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
