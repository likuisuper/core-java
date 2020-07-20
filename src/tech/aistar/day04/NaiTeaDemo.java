package tech.aistar.day04;

/**
 * 本类功能:奶茶业务
 *
 * 单价:10.0d
 *
 * 第二杯半价
 *
 * @author cxylk
 * @date 2020/7/20 15:15
 */
public class NaiTeaDemo {
    public static void main(String[] args) {
        //定义奶茶的单价
        double price=10.0d;

        //定义购买的数量
        int cup=5;

        //计算出总价
        double totalPrice=price/2*(cup/2)+price*(cup/2);//偶数杯

        //判断是否为奇数,用与运算
        if((cup & 1)==1){
            totalPrice+=price;
        }

        //判断是否为奇数
        //if(cup%2!=0){
            //totalPrice+=price;
        //}
        System.out.println(totalPrice);
    }
}
