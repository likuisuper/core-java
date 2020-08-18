package tech.aistar.design.proxy.statics;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 20:24
 */
public class TestUserProxy {
    public static void main(String[] args) {
        //1.创建目标对象
        IUserDao userDao=new UserDaoImpl();

        //2.创建代理对象
        IUserDao userDaoProxy=new UserDaoProxyImpl(userDao);

        //3.利用代理对象来进行方法的调用
        userDaoProxy.add();

        System.out.println("===");

        userDaoProxy.test();
    }
}
