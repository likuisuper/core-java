package tech.aistar.day16.thread;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 本类功能:线程安全和线程不安全
 *
 * 线程安全 :  StringBuffer     Vector      Hashtable
 *
 * 线程不安全:  StringBuilder   ArrayList    HashMap
 *
 * @author cxylk
 * @date 2020/8/13 17:44
 */
public class ThreadDemo02 extends Thread{
    //线程非安全的类是不能设置成静态的成员的变量的
    //静态成员属于类,只会初始化一次,多线程下执行添加就会出现下标越界
    //public static ArrayList<Integer> list=new ArrayList<>();

    //public ArrayList<Integer> list=new ArrayList<>();

    //public Vector<Integer> list=new Vector<>();//结果为 100000 100000
    public static Vector<Integer> list=new Vector<>();

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        System.out.println(list.size());
    }
}

class ThreadDemo02Test{
    public static void main(String[] args) {
        ThreadDemo02 t1=new ThreadDemo02();

        ThreadDemo02 t2=new ThreadDemo02();

        t1.start();
        t2.start();
    }
}
