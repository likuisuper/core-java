package tech.aistar.day16.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/16 10:35
 */
public class CallableDemo02 {
}

class MyCallable implements Callable<Integer>{

    public static void main(String[] args) {
        Callable<Integer> c=new MyCallable();
        //FutureTask ->RunnableFuture ->Runnable,Future
        FutureTask<Integer> task=new FutureTask<>(c);
        Thread thread=new Thread(task);
        thread.start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        return 123;
    }
}
