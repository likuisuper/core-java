package tech.aistar.day13.exception.biz;

/**
 * 本类功能:银行账户实体类
 *
 * 实体类和业务类要分离
 *
 * @author cxylk
 * @date 2020/7/28 17:59
 */
public class Account {
    public int id;

    private double balance;//账户余额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }
}
