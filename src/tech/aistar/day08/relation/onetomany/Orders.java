package tech.aistar.day08.relation.onetomany;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:09
 */
public class Orders {
    private int id;

    private String orderNo;

    private double price;

    private Customer customer;

    public Orders() {
    }

    public Orders(int id, String orderNo, double price) {
        this.id = id;
        this.orderNo = orderNo;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orders{");
        sb.append("id=").append(id);
        sb.append(", orderNo='").append(orderNo).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
