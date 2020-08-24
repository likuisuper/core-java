package tech.aistar.design.proxy2.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 本类功能:动态代理实现类
 *
 * @author cxylk
 * @date 2020/8/24 20:43
 */
public class DebugInvocationHandler implements InvocationHandler {
    //代理类中的真实对象
    private Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前添加自己的操作
        System.out.println("before method:"+method.getName());
        //反射调用目标的方法
        Object result=method.invoke(target,args);//核心业务
        //调用方法之后一样可以添加自己的操作
        System.out.println("after method:"+method.getName());
        return result;
    }
}
