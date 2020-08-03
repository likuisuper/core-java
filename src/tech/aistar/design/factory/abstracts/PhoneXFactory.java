package tech.aistar.design.factory.abstracts;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:23
 */
public class PhoneXFactory implements ProductFactory{
    @Override
    public Sender produceSender() {
        return new QQSender();
    }

    @Override
    public Caller produceCaller() {
        return new DDCaller();
    }
}
