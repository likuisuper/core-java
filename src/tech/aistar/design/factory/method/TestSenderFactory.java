package tech.aistar.design.factory.method;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:02
 */
public class TestSenderFactory {
    public static void main(String[] args) {
        //创建一个QQ工厂
        SenderFactoryable s1=new QQSenderFactory();
        Sender qq=s1.produce();

        SenderFactoryable s2=new WXSenderFactory();
        Sender wx=s2.produce();

        //增加某一类东西并不需要修改工厂类,只需要添加生产这类"东西"的工厂即可
        //遵守了"开闭原则"
        SenderFactoryable s3=new DDSenderFactory();
        Sender dd=s3.produce();
    }
}
