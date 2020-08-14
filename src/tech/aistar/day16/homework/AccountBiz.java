package tech.aistar.day16.homework;

/**
 * 本类功能:模拟每次取钱,每次只能取10元钱
 *
 * 开启两个线程 - 模拟取钱,每次只能取10元钱
 *
 * 老公取钱,剩余90元
 *
 * 小三取钱,剩余80元
 *
 * @author cxylk
 * @date 2020/8/13 21:08
 */
public class AccountBiz implements Runnable{

    public synchronized static double getMoney(){
        Account account=new Account();
        System.out.println(Thread.currentThread().getName()+":"+account.getBalance());
        return 0.0d;
    }

    @Override
    public void run() {
        getMoney();
    }
}
