package tech.aistar.design.factory.method;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:10
 */
public class DDSenderFactory implements SenderFactoryable{
    @Override
    public Sender produce() {
        return new DDSender();
    }
}
