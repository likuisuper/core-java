package tech.aistar.day16.callables;

import java.util.concurrent.*;

/**
 * 本类功能:实现Callable接口来使用线程
 *x
 * @author cxylk
 * @date 2020/8/15 19:35
 */
public class CallableDemo {
}

class C1 implements Callable<Integer>{
    public static void main(String[] args) {
//        Callable<Integer> c=new C1();
//        //Callable有返回值,并且通过FutureTask进行封装
//        FutureTask<Integer> task=new FutureTask<>(c);
//
//        task.run();
//
//        try {
//            Integer result=task.get();//获取线程的执行的结果
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

        System.out.println("=====main线程======");

        //扩展一下 - 配合线程池使用
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<Integer> c = new C1();
        FutureTask<Integer> task = new FutureTask<>(c);

        //提交任务
        executorService.submit(task);

        try {
            Integer result=task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //关闭
        executorService.shutdown();

        System.out.println("========main=======");
    }


    @Override
    public Integer call() throws Exception {
        System.out.println("===子线程执行====");
        Integer sum=0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
        }
        Thread.sleep(1000);//不用添加try catch，因为call方法中已经抛出异常
        System.out.println("===子线程结束====");
        return sum;
    }
}
