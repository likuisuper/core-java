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

    private Account account=new Account();

    @Override
    public void run() {
        for (int i = 10; i >1 ; i--) {
            test(10);
        }
    }

    public void test(double money){
        synchronized (account){//对象锁
            if(account.getBalance()>0){
                System.out.println(Thread.currentThread().getName()+"->正在取钱");

                //调用取钱的方法
                account.withdraw(money);
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(Thread.currentThread().getName()+"->余额还剩:"+account.getBalance());

            }
        }
    }

    public static void main(String[] args) {
        Runnable r=new AccountBiz();

        Thread t1=new Thread(r);
        Thread t2=new Thread(r);

        t1.setName("婆娘");
        t2.setName("官人");

        t1.start();
        t2.start();
    }
}
