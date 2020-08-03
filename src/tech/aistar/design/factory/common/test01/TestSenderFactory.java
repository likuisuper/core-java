package tech.aistar.design.factory.common.test01;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 13:26
 */
public class TestSenderFactory {
    public static void main(String[] args) {
        SenderFactory factory=new SenderFactory();

        //原先创建QQ产品
        //专业术语：主动去找创建的对象
        //对象的创建者
        //对象的使用者

        //目的：哪里使用,就由自己去创建对象
        //对象的创建者和对象的使用者耦合在一块儿了,不符合"单一职责原则"
        //"单一职责原则" - 对象的创建应该和对象的使用要分离
        //对象的创建专门交给"工厂",我们要想使用这个对象,直接通过传入一个参数,来获取到工厂为我们创建的这个对象

        //因为有可能这个对象的构建过程比较复杂
        //Sender qqs=new QQSender();

        Sender qq=factory.getInstance("QQ");

        //Sender wx=factory.getInstance("WX");
        Sender wx=factory.getInstance(SenderFactory.WX);
    }
}
