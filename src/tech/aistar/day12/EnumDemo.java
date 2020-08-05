package tech.aistar.day12;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/5 19:04
 */
public enum EnumDemo {//默认继承的是java.lang.Enum抽象类
    //1.每个枚举常量都是代表整个枚举类型的一个实例
    SPRING,//背后等同于public final static EnumDemo SPRING = new EnumDemo();

    //如果定义多个枚举常量,使用逗号隔开
    SUMMER,//public final static EnumDemo SUMMER=new EnumDemo();

    WINTER;

    //2.可以定义普通的属性
    private String sign;

    //3.可以定义普通的方法
    public void setSign(String sign){
        this.sign=sign;
    }

    public String getSign(){
        return sign;
    }

    //4.可以提供构造方法的,但是不能设置public
    private EnumDemo(){
        System.out.println("构造方法被调用了...");
    }
}
