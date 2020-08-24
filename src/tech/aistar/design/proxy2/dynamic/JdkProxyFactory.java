package tech.aistar.design.proxy2.dynamic;

import java.lang.reflect.Proxy;

/**
 * 本类功能:获取代理对象的工厂类
 *
 * @author cxylk
 * @date 2020/8/24 20:53
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        //newProxyInstance用来生成一个代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),//目标类的加载
                target.getClass().getInterfaces(),//代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target));//代理对象对应的自定义InvocationHandler
    }
}
