package tech.aistar.design.factory.abstracts;

/**
 * 本类功能:
 * 使用者来说,并不清楚ProductFactory到底包含了多少个产品
 * 这些产品共同构成了一个产品族
 *
 * @author cxylk
 * @date 2020/8/3 18:26
 */
public class TestProductFactory {
    public static void main(String[] args) {
        ProductFactory factory=new PhoneXFactory();
        Sender s1=factory.produceSender();

        Caller c1=factory.produceCaller();

        System.out.println("=======");

        ProductFactory factory2=new PhoneXSFactory();
        factory2.produceSender();
        factory.produceCaller();
    }
}
