package tech.aistar.day16.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本类功能:创建一个单线程化的线程池
 * 它只会用唯一的工作线程来执行任务，保证所有的任务
 * 按照指定顺序(FIFO,LIFO，优先级)执行
 *
 * @author cxylk
 * @date 2020/8/15 20:51
 */
public class SingleThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
}
