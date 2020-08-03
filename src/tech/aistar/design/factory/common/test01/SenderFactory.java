package tech.aistar.design.factory.common.test01;

/**
 * 本类功能:普通工厂模式
 * 作用:根据传入的参数,来返回具体的某个产品
 *
 *缺点:如果一旦新增一个产品的话,动SenderFactory工厂类
 * 对于工厂类而言,不符合"开闭原则"
 *
 * @author cxylk
 * @date 2020/8/3 10:44
 */
public class SenderFactory {

    public static final String QQ="QQ";

    public static final String WX="WX";

    //多态的应用 - 面向接口编程
    //方法的返回类型写成接口,方法体的返回值可以写成这个接口的任何一个实现类对象
    public Sender getInstance(String product){
        Sender sender=null;

        //一个工厂是可以创建多个产品的
        if(QQ.equals(product)){
            sender=new QQSender();
        }
        else if(WX.equals(product)){
            sender=new WXSender();
        }else{
            System.out.println("对不起,产品不存在!");
        }
        return sender;
    }
}
