package tech.aistar.design.factory.common.test03;

/**
 * 本类功能:静态方法简单工厂 - 每个产品对应一个创建方法
 *
 * 当新增一个产品的时候,还是动工厂类 - 不符合"开闭原则"
 *
 * @author cxylk
 * @date 2020/8/3 17:50
 */
public class SenderFactory {
    public static Sender produceQQ(){
        return new QQSender();
    }
    public static Sender produceWX(){
        return new WXSender();
    }
}
