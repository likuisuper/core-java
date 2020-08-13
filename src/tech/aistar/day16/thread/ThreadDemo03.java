package tech.aistar.day16.thread;

/**
 * 本类功能:第一种实现方式 - 共享代码,但是不共享资源
 * 因为new了两次Thread进程对象，每个进程之间是独立的
 *
 * @author cxylk
 * @date 2020/8/13 18:22
 */
public class ThreadDemo03 extends Thread{
    private int ticket=10;

    @Override
    public void run() {
        for (int i = 10; i >0; i--) {
            if(ticket>0){
                System.out.println(Thread.currentThread().getName()+"->剩余:"+(--ticket));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class TestThreadDemo03{
    public static void main(String[] args) {
        Thread t1=new ThreadDemo03();
        t1.setName("windows01");

        Thread t2=new ThreadDemo03();
        t2.setName("windows02");

        t1.start();

        t2.start();

    }
}