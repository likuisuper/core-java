package tech.aistar.design.proxy2.statics;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/24 20:25
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:"+message);
        return message;
    }
}
