package tech.aistar.day16.cas;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/10/31 14:57
 */
public class CasDemo implements Runnable{

    private static AtomicInteger atomicInteger=new AtomicInteger(1);

    @Override
    public void run() {
        increment();
    }

    /**
     * 就为了一个i++就加上synchronized难免有点大材小用
     */
//    public synchronized static void increment(){
//        for (int j = 0; j < 10; j++) {
//            i++;
//        }
//        System.out.println(i);
//    }

        public void increment() {
            for (int j = 0; j < 3; j++) {
                atomicInteger.incrementAndGet();//这里的atomicInteger就是i

            }
            System.out.println(atomicInteger);
        }

    public static void main(String[] args) {
        Runnable runnable=new CasDemo();
        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        t1.start();
        t2.start();
    }
}
