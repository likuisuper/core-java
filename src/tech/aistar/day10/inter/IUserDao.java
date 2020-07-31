package tech.aistar.day10.inter;

/**
 * 本类功能:接口 - 制定业务功能,不要求有具体的实现
 *
 *  - 告诉程序员需要完成哪些事情
 *
 * @author cxylk
 * @date 2020/7/31 19:21
 */
public interface IUserDao {
    //定义普通方法 - 在jdk8.0以后可以使用default关键字来定义一个普通方法
    //由于在接口中,所有的方法默认都是使用public来进行修饰的，所以可省略
//    public default void add(){
//        System.out.println("add...");
//    }

    //不推荐定义
    default void add(){
        System.out.println("add..");
    }

    //接口中是可以定义抽象方法的
    //public abstract void delete();//没有方法体的方法

    //可以简写
    void delete();

    void update();

    //常量接口 只提供公开的静态的常量属性接口
    //接口中可以定义公开的静态的常量属性
    //public static final int CAT=1;

    //可以简写 - 后期将会全部移植到枚举类型中
    int CAT=1;
}
