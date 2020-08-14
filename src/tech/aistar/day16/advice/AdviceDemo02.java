package tech.aistar.day16.advice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/14 15:30
 */
public class AdviceDemo02 {
    private Lock lock=new ReentrantLock();

    //有两个线程,创建两个队列
    //特点 - 很方便进行选择性通知某个等待队列的线程
}
