package tech.aistar.design.proxy.statics;

/**
 * 本类功能:目标对象 - 完成核心的业务功能的类
 *
 * 代理模式的目的 - 都是为了扩展目标对象的功能，但是又不希望修改目标对象
 *
 * 使用一种非侵入式的方法来实现功能的扩展 - spring框架体现出来的思想AOP[面向切面编程]
 *
 * @author cxylk
 * @date 2020/8/18 20:07
 */
public class UserDaoImpl implements IUserDao{
    @Override
    public void add() {
        System.out.println("add...");//核心功能
    }

    @Override
    public void test() {
        System.out.println("test...");//核心功能
    }
}
