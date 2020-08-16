package tech.aistar.day16.pool;

import java.util.concurrent.*;

/**
 * 本类功能:创建一个定长线程池，支持定时及周期性任务执行
 *
 * @author cxylk
 * @date 2020/8/15 22:32
 */
public class ScheduledThreadDemo {
    public static void main(String[] args) {
        //参数，要保留在池中的线程数，即使他们处于空闲状态，也要
        ScheduledExecutorService executorService= Executors.newScheduledThreadPool(2);

        /*
         public ScheduledFuture<?> scheduleAtFixedRate(Runnable command,
                                                  long initialDelay,
                                                  long period,
                                                  TimeUnit unit);
         */

       executorService.scheduleAtFixedRate(()->{
           System.out.println(Thread.currentThread().getName());
       },5,2,TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
