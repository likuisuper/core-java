package tech.aistar.day16.homework;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/13 21:11
 */
public class TestAccountBiz {
    public static void main(String[] args) {
        Account account=new Account();
        account.setBalance(100);
        Runnable r1=new AccountBiz();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);

        t1.setName("老公");
        t2.setName("小三");
    }
}
