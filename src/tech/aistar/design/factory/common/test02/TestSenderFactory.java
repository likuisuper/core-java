package tech.aistar.design.factory.common.test02;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 17:38
 */
public class TestSenderFactory {
    public static void main(String[] args) {
        SenderFactory factory=new SenderFactory();//工厂肯定是重量级对象
        Sender qq=factory.produceQQ();

        Sender wx=factory.produceWX();
    }
}
