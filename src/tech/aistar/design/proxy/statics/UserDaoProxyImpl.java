package tech.aistar.design.proxy.statics;

/**
 * 本类功能:Proxy - 代理 - 代理对象
 *
 * 静态代理模式 - 需要手动真实提供一个代理类
 *
 * 代理对象和目标对象首先应该实现同一个接口
 *
 * @author cxylk
 * @date 2020/8/18 20:18
 */
public class UserDaoProxyImpl implements IUserDao{

    //private UserDaoImpl userDao;//代理对象中需要维护一个目标对象
    private IUserDao userDao;

    public UserDaoProxyImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        //完成非核心的业务功能
        System.out.println("log之前");

        //调用目标对象的方法
        userDao.add();

        System.out.println("log之后");
    }

    @Override
    public void test() {
        //完成非核心的业务功能
        System.out.println("log之前");

        //调用目标对象的方法
        userDao.test();

        System.out.println("log之后");
    }
}
