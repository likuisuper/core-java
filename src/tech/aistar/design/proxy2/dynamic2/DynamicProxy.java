package tech.aistar.design.proxy2.dynamic2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/9/2 18:58
 */
public class DynamicProxy {
    public static void main(String[] args) {
//        JavaDeveloper lk=new JavaDeveloper("cxylk");
//        Developer lkProxy= (Developer)Proxy.newProxyInstance(lk.getClass().getClassLoader(),
//                lk.getClass().getInterfaces(), new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        if(method.getName().equals("code")){
//                            System.out.println("lk is praying for the code");
//                            //当代理类的方法没有参数时可以省略args
//                            return method.invoke(lk,args);
//                        }
//                        if(method.getName().equals("debug")){
//                            System.out.println("lk's have no bug,no need to debug");
//                            return null;
//                        }
//                        return null;
//                    }
//                });
//        lkProxy.code();
//        lkProxy.debug();

        JavaDeveloper lk=new JavaDeveloper("cxylk");
        Developer lkProxy= (Developer)Proxy.newProxyInstance(lk.getClass().getClassLoader(),
                lk.getClass().getInterfaces(),(proxy, method, agrs) ->{//这里写agrs是因为main方法中已经定义了args
                    //当外面调用了code方法后，这里便能获取到方法名
                    if(method.getName().equals("code")){
                        System.out.println("lk is praying for the code");
                        //当代理类的方法没有参数时args可以省略
                        return method.invoke(lk,agrs);
                    }
                    if(method.getName().equals("debug")){
                        System.out.println("lk's have no bug,no need to debug");
                        return null;
                    }
                    return null;
                });
        lkProxy.code();
        lkProxy.debug();
    }
}
