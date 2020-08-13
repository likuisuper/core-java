package tech.aistar.day16.thread;

/**
 * 本类功能:synchronized可以保证可见性和原子性
 *
 * @author cxylk
 * @date 2020/8/13 19:20
 */
public class PlusPlusDemo implements Runnable{
    public int i=0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            add();
            //直接将i++写在这里也是可以的
        }
    }

    /**
     * 因为i++操作不是一个原子性操作,不是一气呵成的
     *
     * jvm缓存机制 - 每个线程在执行的过程中都会拥有独立的线程栈
     *
     * i++不是原子性操作 - 分三步走,这三个步骤在任何一个步骤,其它线程都是可以插进来的
     * ①从jvm的主存中将i=0拉取到自己那个独立的线程本地缓存中
     * ②将i的值+1，是每个线程在自己的本地缓存中进行修改操作，对其它线程是不可见的
     * ③将i回写到主存中[线程切换,线程释放锁]
     *
     * 总结为什么最终的i值小于200000
     *
     * 比如A线程执行到①②,A在本地缓存中刚刚修改了i+1,在A还没有来得及进行③的时候,
     * B线程也发动了,执行顺序①(i=0) - ② - ③ 全部执行完毕
     *
     * 主存的i是1，然后A线程才慢吞吞的把i回写到主存[i=1]
     *
     * 这个时候加了2次,最后实际只加了1次
     *
     * synchronized可以保证原子性和可见性
     */
    public synchronized void add(){//加了synchronized后变成了200000
        i++;
    }
}

class Test{
    public static void main(String[] args) throws InterruptedException {
        PlusPlusDemo p=new PlusPlusDemo();

        Thread t1=new Thread(p);

        Thread t2=new Thread(p);

        t1.start();

        t2.start();

        Thread.sleep(5000);

        System.out.println(p.i);
    }
}
