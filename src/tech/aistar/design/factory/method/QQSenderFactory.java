package tech.aistar.design.factory.method;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:00
 */
public class QQSenderFactory implements SenderFactoryable{
    @Override
    public Sender produce() {
        return new QQSender();
    }
}
