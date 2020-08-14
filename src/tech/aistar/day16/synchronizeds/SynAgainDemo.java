package tech.aistar.day16.synchronizeds;

/**
 * 本类功能:可重入性
 *
 * @author cxylk
 * @date 2020/8/14 12:10
 */
public class SynAgainDemo {

    /**
     * 可重入性,调用外层函数获得对象的锁资源进入到同步代码的时候，外层函数内部又去调用同步函数
     * 那么这个时候依然是可以获得内部函数的锁,仍然是可以调用完毕的
     */
    public synchronized void test01(){
        System.out.println("test01");
        test02();
    }

    public synchronized void test02(){
        System.out.println("test02");
    }

    public static void main(String[] args) {
        SynAgainDemo s=new SynAgainDemo();
        s.test01();
    }
}
