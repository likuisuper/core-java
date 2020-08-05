package tech.aistar.day12;

/**
 * 本类功能:枚举类型
 *
 * @author cxylk
 * @date 2020/8/5 19:16
 */
public enum EnumDemo2 {//默认继承的是java.lang.Enum抽象类
    SPRING("春天"),
    SUMMER("夏天"),
    WINTER("冬天");//public final static EnumDemo02 WINTER=new EnumDemo02("冬天");

    private EnumDemo2(String sign){
        this.sign=sign;
    }

    //可以定义普通的属性
    private String sign;

    public void setSign(String sign){
        this.sign=sign;
    }

    public String getSign(){
        return sign;
    }

    private EnumDemo2(){
        System.out.println("构造方法被调用了");
    }
}
