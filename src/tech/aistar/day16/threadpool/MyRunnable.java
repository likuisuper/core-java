package tech.aistar.day16.threadpool;

import java.util.Date;

/**
 * 本类功能:线程池要提交的任务
 *
 * @author cxylk
 * @date 2020/10/31 14:31
 */
public class MyRunnable implements Runnable{
    private String command;
    public MyRunnable(String s){
        this.command=s;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start.Time=:"+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End.Time=:"+new Date());
    }

    private void processCommand(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
