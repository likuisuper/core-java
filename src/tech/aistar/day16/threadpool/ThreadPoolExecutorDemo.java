package tech.aistar.day16.threadpool;

import sun.dc.pr.PRError;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 本类功能:使用阿里推荐的ThreadPoolExecutor构造函数来创建你线程池
 * 代码中模拟了10个任务，我们配置的核心线程数为5，等待队列为容量为100，
 * 所以每次只可能存在5个任务同时执行，剩下的5个任务会放到等待队列中去。
 * 当前的5个任务执行完成之后，才会执行剩下的5个任务
 *
 * @author cxylk
 * @date 2020/10/31 14:15
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE=5;//核心线程数
    private static final int MAX_POOL_SIZE=10;//最大线程数
    private static final int QUEUE_CAPACITY=100;//任务队列的容量
    private static final Long KEEP_ALIVE_TIME=1L;//等待时间1L

    public static void main(String[] args) {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(CORE_POOL_SIZE,MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.SECONDS,new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            Runnable runnable=new MyRunnable(""+i);
            //执行runnable
            executor.execute(runnable);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()){

        }
        System.out.println("finished all threads");
    }
}
