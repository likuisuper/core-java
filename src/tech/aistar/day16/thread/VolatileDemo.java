package tech.aistar.day16.thread;

/**
 * 本类功能:
 * volatile关键字
 *
 * 没有它的时候 - jvm底层进行指令优化重拍操作
 *
 * 正常的步骤
 * 1.申请空间
 * 2.初始化
 * 3.将内存地址赋值给引用
 *
 * 重排之后的指令
 * 1-3-2
 *
 * @author cxylk
 * @date 2020/8/13 20:01
 */
public class VolatileDemo {
    //private int x=0;

    private volatile int x=0;//确保可见性

    //写
    private void writeX(){
        x=5;
    }

    //读
    private void readX(){
        while(x!=5){

        }

        if(x==5){
            System.out.println("===stopped");
        }
    }

    public static void main(String[] args) {
        VolatileDemo v=new VolatileDemo();

        //创建两个线程 - 匿名内部类
//        Thread t1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                v.writeX();
//            }
//        });
//
//
//        Thread t2=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                v.readX();
//            }
//        });

        //Lambda写法
        Thread t1=new Thread(()->v.writeX());

        Thread t2=new Thread(()->v.readX());

        //1.先写再读 -> 写x=5 [本地缓存]

        //2.切换读的线程,切换线程的动作,把第一个线程的x=5回写到主存中

        //读线程自然可以读到的
//        t1.start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        t2.start();

        //先读
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //后写
        t1.start();
    }
}
