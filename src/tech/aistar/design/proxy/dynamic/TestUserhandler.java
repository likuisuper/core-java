package tech.aistar.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 20:36
 */
public class TestUserhandler {
    public static void main(String[] args) {
        //1.创建目标对象
        IUserDao userDao=new UserDaoImpl();
        //[interface tech.aistar.design.proxy.dynamic.IUserDao]
        System.out.println(Arrays.toString(userDao.getClass().getInterfaces()));

        //2.创建和目标对象关联的InvokeHandler对象
        InvocationHandler handler=new UserDaoHandler(userDao);

        //3.创建代理对象
        //1.参数 - 目标对象的类的加载器
        IUserDao userDaoProxy= (IUserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),handler);

        //4.通过代理对象来调用目标对象中的方法
        userDaoProxy.add();

        System.out.println("====");

        //1.创建目标对象
        ITeacherDao teacherDao=new TeacherDaoImpl();

        //2.创建handler
        InvocationHandler v=new UserDaoHandler(teacherDao);

        //3.创建代理对象
        ITeacherDao proxy= (ITeacherDao) Proxy.newProxyInstance(teacherDao.getClass().getClassLoader(),
                teacherDao.getClass().getInterfaces(),v);

        //4.代理对象来调用方法
        int s=proxy.find(10);
        System.out.println(s);

        //class com.sun.proxy.$Proxy1,出现$符号就是使用代理
//        System.out.println(proxy.getClass());
//
//        System.out.println(teacherDao.getClass());

        System.out.println("====");

        proxy.remove(1);
    }
}
