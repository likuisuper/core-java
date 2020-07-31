package tech.aistar.day10.inter.relation;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 18:10
 */
public class TestCimpl {
    public static void main(String[] args) {
        //接口是不能实例化的
        //多态的特征 - 对象的编译时类型写成接口,对象的运行时类型写成这个接口
        //的任何一个实现类对象
        IC ic=new Cimpl();
        ic.find();
        ic.add();
        ic.update();

        //调用普通方法
        ic.a();
    }
}
