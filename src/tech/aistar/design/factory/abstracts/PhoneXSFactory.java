package tech.aistar.design.factory.abstracts;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:25
 */
public class PhoneXSFactory implements ProductFactory{
    @Override
    public Sender produceSender() {
        return new WXSender();
    }

    @Override
    public Caller produceCaller() {
        return new TenCaller();
    }
}
