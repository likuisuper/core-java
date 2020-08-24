package tech.aistar.design.proxy2.statics;

/**
 * 本类功能:静态代理类
 *
 * @author cxylk
 * @date 2020/8/24 20:26
 */
public class SmsProxy implements SmsService{
    //维护一个被代理的目标对象
    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        System.out.println("after method send()");
        return message;
    }
}
