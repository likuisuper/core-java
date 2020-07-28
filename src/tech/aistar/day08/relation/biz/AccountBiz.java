package tech.aistar.day08.relation.biz;

/**
 * 本类功能:银行账户业务类
 *
 * @author cxylk
 * @date 2020/7/28 17:59
 */
public class AccountBiz {
    /**
     * 存款
     * @param acc
     * @param money
     */
    public void deposite(Account acc,double money){
        if(money<=0){
            System.out.println("sor，存入的金额不能是负数");
            return;
        }
        acc.setBalance(acc.getBalance()+money);
    }

    public void withdraw(Account acc,double money){
        if(acc.getBalance()<money){
            System.out.println("sorry,余额不足");
            return;
        }

        double balance=acc.getBalance();
        balance-=money;
        acc.setBalance(balance);
    }
}
