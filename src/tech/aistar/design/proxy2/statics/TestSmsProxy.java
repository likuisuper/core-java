package tech.aistar.design.proxy2.statics;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/24 20:31
 */
public class TestSmsProxy {
    public static void main(String[] args) {
        SmsService smsService=new SmsServiceImpl();
        SmsProxy smsProxy=new SmsProxy(smsService);
        smsProxy.send("java");
    }
}
