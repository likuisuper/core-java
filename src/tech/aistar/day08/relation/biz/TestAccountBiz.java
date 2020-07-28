package tech.aistar.day08.relation.biz;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 17:59
 */
public class TestAccountBiz {
    public static void main(String[] args) {
        Account account=new Account();
        account.setId(1);
        account.setBalance(500.0d);

        //创建业务类对象
        AccountBiz accountBiz=new AccountBiz();
        accountBiz.deposite(account,100.0d);

        System.out.println(account.getBalance());

        accountBiz.withdraw(account,200.0d);

        System.out.println(account.getBalance());
    }
}
