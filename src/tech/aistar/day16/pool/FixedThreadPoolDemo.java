package tech.aistar.day16.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本类功能:创建一个**可重用**固定个数的线程池，以共享的无界队列方式来运行这些线程
 *
 * @author cxylk
 * @date 2020/8/15 21:57
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);//参数代表池中的线程数

        for (int i = 0; i < 3; i++) {
            //提交任务
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
