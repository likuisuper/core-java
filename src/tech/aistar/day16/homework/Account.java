package tech.aistar.day16.homework;

/**
 * 本类功能:实体类
 *
 * @author cxylk
 * @date 2020/8/13 21:07
 */
public class Account {
    private int id;

    private double balance=100;

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

    public Account() {
    }

    public Account(int id, double balance) {
        this.id = id;
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

    public void withdraw(double money){
        this.balance-=money;
    }
}
