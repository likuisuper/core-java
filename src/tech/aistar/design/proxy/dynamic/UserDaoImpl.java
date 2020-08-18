package tech.aistar.design.proxy.dynamic;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 20:48
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
