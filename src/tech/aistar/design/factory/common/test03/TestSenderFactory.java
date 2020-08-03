package tech.aistar.design.factory.common.test03;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 17:53
 */
public class TestSenderFactory {
    public static void main(String[] args) {
        Sender qq=SenderFactory.produceQQ();

        Sender wx=SenderFactory.produceWX();
    }
}
