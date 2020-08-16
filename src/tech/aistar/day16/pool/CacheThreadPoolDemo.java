package tech.aistar.day16.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本类功能:
 * 可缓存线程池,先查看池中有没有以前建立的线程
 * 如果有,就直接使用.如果没有，就建一个新的线程加入池中，
 * 缓存型池子通常用于执行一些生存期很短的异步型任务
 *
 * @author cxylk
 * @date 2020/8/15 20:55
 */
public class CacheThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个可缓存池
        ExecutorService executor= Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            //会在应用程序中创建大量的线程对象 - 堆里面 - 占系统资源
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName());
//            }).start();

            //提交任务
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        //关闭线程池
        executor.shutdown();
    }
}
