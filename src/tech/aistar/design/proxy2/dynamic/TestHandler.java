package tech.aistar.design.proxy2.dynamic;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/24 21:09
 */
public class TestHandler {
    public static void main(String[] args) {
        SmsService service=new SmsServiceImpl();

        SmsService smsService= (SmsService) JdkProxyFactory.getProxy(service);
        smsService.send("java");
    }
}
