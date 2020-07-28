package tech.aistar.day08.relation.onetomany;




/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:09
 */
public class TestCustomer {
    public static void main(String[] args) {
        Customer c=new Customer(1,"tom");

        //创建订单的数组
        Orders[] orders=new Orders[2];

        //创建订单信息
        Orders o1=new Orders(1,"1001",100.0d);
        o1.setCustomer(c);

        Orders o2=new Orders(2,"1002",200.0d);
        o2.setCustomer(c);

        orders[0]=o1;
        orders[1]=o2;

        c.setOrders(orders);

        System.out.println(c);

        for(Orders order:c.getOrders()){
            System.out.println(order);
        }
    }
}
