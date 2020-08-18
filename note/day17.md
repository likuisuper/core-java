# 反射
简介:在程序运行期间,通过反射技术来动态获取类的内部信息,获取属性以及调用方法.
换一种方式来构建对象,设置/获取属性,调用方法.反射技术是未来读懂框架技术的源码必备的技术.
***java.lang.Class<T>***它是反射技术的基础类.

# Class
当类加载器将类加载到JVM内存的时候,会把类映射成Class,所有被加载到内存的类,都是属于Class类型的
对象.一个类无论被实例化多少次,它在JVM中的class实例永远只有1个.java.lang.Class<T>是用来描述
类的类.

## 获取Class实例的方式
* 对象.getClass();
* 类名.class;
* Class.forName("类的全限定名");//需要抛出一个异常java.lang.ClassNotFoundException
* 基本类型.class;
  ~~~java
  System.out.println(int.class);//int
  ~~~



## 反射相关API

* Field[] getFields();//获取类中所有的公共的属性.
* Field[] getDeclaredFields();//获取类中所有的属性,包括私有的.
* Field getField(String fieldName);//根据属性的名称来获取这个属性对应的Field对象.但是也是公开的.
* Field getDeclaredField(String fieldName);//根据属性的名称来获取这个属性对应的Field对象,但是包括私有的属性.
* String getName();//获取类的全限定名
* String getSimpleName();//获取类的简称.
* Method[] getMethods();//获取类中所有的公共方法.
* Method[] getDeclaredMethods();//获取类中所有的方法,包括私有的.
* Method getMethod(String methodName);//根据方法的名称来获取这个属性对应的方法对象.但是也是公开的.
* Method getDeclaredMethod(String methodName);//根据方法的名称来获取这个属性对应的method对象,但是包括私有的属性.



# Field

***java.lang.reflect***.Field

反射获取类内部的字段(属性)的元信息.元信息包括:***属性的修饰符,属性的数据类型,属性的名称***,属性的值.



常用方法:

* int getModifiers();//属性的修饰符.
* Class<?> getType();//反射获取类型
* String getName();//获取属性的名称



# 反射在框架中的应用

~~~java
public interface IUserDao{
  
}
//dao层 - 专门和DB交互[jdbc技术,mybatis技术.].
public class UserDaoImpl implements IUserDao{
    //CRUD操作.
}

public interface IUserSerivce{
  
}

//业务逻辑层 - 进行数据统计,数据归来,数据分析,数据处理.
//业务逻辑层首先调用dao层.
public class UserServiceImpl implements IUserService{
    //需要维护一个dao对象
    //传统的写法 -
    //弊端 - 突然哪天实现类换掉了.代码是需要重新编译的.
    //谁使用组件,还必须需要程序自己去创建组件.
    //将对象的创建和对象的使用耦合在一块儿.
    //主动寻找方式 - 哪里使用,哪里new
    //private IUserDao userDao = new UserDaoImpl();
    
    //使用了spring框架之后,被动接受组件.
  	private IUserDao userDao;
  
    
}
~~~

spring框架属于IOC容器 - 控制反转 - 将bean的生命周期[创建]的权利交给了spring框架.

降低各个组件之间的耦合性.

~~~xml
俩个bean - 俩个组件.
等同于反射创建了一个UserDaoImpl对象.
<bean id="userDao" class="tech.aistar.dao.UserDaoImpl">

</bean>

<bean id="userDao2" class="tech.aistar.dao.UserDaoImpl2">

</bean>

反射创建了UserServiceImpl对象.
<bean id="userService" class="tech.aistar.service.UserServiceImpl">
	  <property name="userDao" ref="userDao2"/>
</bean>
~~~



# Method

~~~java
package tech.aistar.day17;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2020/8/18 9:55 上午
 */
public class MethodDemo {
    public static void main(String[] args) {
        //1. 获取class实例
        try {
            Class<?> c = Class.forName("tech.aistar.day17.Point");
            Method[] methods = c.getDeclaredMethods();
            System.out.println(methods.length);

            for (Method method : methods) {
                //System.out.println(method);

                //获取方法的元信息
                //1. 获取方法的修饰符
                System.out.print(Modifier.toString(method.getModifiers())+" ");

                //2. 获取方法的返回类型
                System.out.print(method.getReturnType().getSimpleName()+" ");

                //3. 获取方法的名称
                System.out.print(method.getName()+"(");

                //4. 获取方法的形参列表
                Class<?>[] types = method.getParameterTypes();

                for (int i = 0; i < types.length; i++) {
                    System.out.print((i!=types.length-1)?(types[i].getSimpleName()+","):(types[i].getSimpleName()));
                }
                System.out.println(")");

                System.out.println("===获取指定的方法===");
                //反射创建Point对象
                Point p = (Point) c.newInstance();

                //1. 获取空参的test方法
                Method m1 = c.getDeclaredMethod("test");
                //1-1. 反射调用
                m1.invoke(p);

                //2. 反射调用一参test方法
                Method m2 = c.getDeclaredMethod("test",int.class);
                m2.invoke(p,100);

                //3. 反射调用两参test方法
                Method m3 = c.getDeclaredMethod("test",int.class,String.class);
                m3.invoke(p,200,"tom");

                //4. 调用静态方法
                Method m4 = c.getDeclaredMethod("testStatic");
                m4.invoke(null);

                //5. 调用私有的方法 - 反射可以破坏封装性.
                Method m5 = c.getDeclaredMethod("testPrivate");
                m5.setAccessible(true);
                m5.invoke(p);

                //6. 调用带有返回类型的方法
                Method m6 = c.getDeclaredMethod("getResult");
                String result = (String) m6.invoke(p);
                System.out.println(result);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

~~~



# Constructor

简介:反射调用构造.

~~~java
package tech.aistar.day17;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * 本类用来演示:反射调用构造方法
 *
 * @author: success
 * @date: 2020/8/18 10:38 上午
 */
public class ConstructorDemo {
    public static void main(String[] args) {
        //获取class实例
        Class<?> c = Point.class;

        //获取所有的构造
        Constructor<?>[] constructors = c.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            //System.out.println(constructor);
            System.out.print(Modifier.toString(constructor.getModifiers())+" ");
            System.out.print(constructor.getName()+"(");

            Class<?>[] types = constructor.getParameterTypes();

            for (int i = 0; i < types.length; i++) {
                System.out.print((i!=types.length-1)?(types[i].getSimpleName()+","):(types[i].getSimpleName()));
            }

            System.out.println(")");

            System.out.println("===反射调用构造==");
            //1. 调用空参构造有两种方式
            //a. 直接通过java.lang.Class<T>中提供的newInstance();
            try {
                Point p = (Point) c.newInstance();

            //b. 通过java.lang.reflect.Constructor提供的newInstance
            Constructor<?> c1 = c.getDeclaredConstructor();
            Point p2 = (Point) c1.newInstance();

            //2. 调用带参构造只有一种
            Constructor<?> c2 = c.getDeclaredConstructor(int.class,String.class);
            Point p3 = (Point) c2.newInstance(200,"java");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}

~~~



# Array

java.lang.reflect.Array - 反射技术操作数组.

笔试题:Array和Arrays有什么区别.

~~~java
package tech.aistar.day17;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 本类用来演示:反射技术操作数组
 *
 * @author: success
 * @date: 2020/8/18 10:48 上午
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40};

        String[] arr2 = {"java","python","php"};

        //对上面的数组进行扩容操作.
        int[] temp = (int[]) exchange(arr1);
        System.out.println(Arrays.toString(temp));

        String[] temp2 = (String[]) exchange(arr2);
        System.out.println(Arrays.toString(temp2));
    }

    /**
     * 反射的技术来操作数组 - 完成数组的扩容操作.
     * @param arr
     */
    private static Object exchange(Object arr) {
        //1. 确定一个新的数组,首先要先确定新的数组的元素类型以及数组的长度
        int len = Array.getLength(arr);

        //2. 反射获取数组的组件类型 - 元素类型
        Class<?> type = arr.getClass().getComponentType();

        //3. 通过反射的技术来构建新的数组
        Object temp = Array.newInstance(type,len<<1);

        //4. 遍历arr,然后将arr中的原始的数据放入到反射创建出来的新的数组temp中.
        for (int i = 0; i < len; i++) {
            //4-1. 依然通过下标来获取原始数组对应下标的数据
            Object value = Array.get(arr,i);

            //4-2. 将value这个数据存放到temp数组中去
            //反射设置数组的值
            Array.set(temp,i,value);
        }
        return temp;
    }
}

~~~



# 笔试题

给定某个类的全限定名.统计每个类型的字段的个数,降序排.



# 代理模式

简介:静态代理和动态代理(***jdk动态代理和cglib动态代理***)

什么时候需要使用到代理模式.

目标对象 - 真正的对象,真正的核心功能的对象.

代理对象 - 拓展目标对象功能的对象.



***目的:都是为了在不修改目标对象的前提之下,能够拓展目标对象的功能.***



## 在没有使用代理之前

~~~java
public interface IUserDao{
  void add();
  
  void test();
}
public class UserDaoImpl implements IUserDao{
  @Override
  public void add(){
    //核心业务功能
    System.out.println("add...");
  }
  
  @Override
  public void test(){
    //核心业务功能
     System.out.println("test...");
  }
}
~~~

核心的业务功能完成之后,突然项目中需要给每个dao方法加入日志功能.

只能对UserDaoImpl进行直接的修改操作,**但是不符合"开闭原则".不利于程序的拓展性和维护**

会使核心的类变得非常***"臃肿"***,把大量的核心功能和大量的非核心功能全部耦合在一块儿了.

~~~java
public class UserDaoImpl implements IUserDao{
  @Override
  public void add(){
    //与业务无关的核心功能 - 日志
    System.out.println("log之前...");
    
    //核心业务功能
    System.out.println("add...");
    
    //与业务无关的核心功能 - 日志
    System.out.println("log之后...");
  }
  
  @Override
  public void test(){
    //与业务无关的核心功能 - 日志
    System.out.println("log之前...");
    //核心业务功能
     System.out.println("test...");
    
    //与业务无关的核心功能 - 日志
    System.out.println("log之后...");
  }
}
~~~

## 静态代理

**就是代理类需要真实提供,并且真实生成.java文件和一个.class文件**,它的效率是高于动态代理的方式.

在项目中,应用程序的功能归类为与业务相关的核心功能和与业务核心无关的功能[事务,***日志***]

目标对象和代理对象都应该实现同一个接口.

缺点:会产生大量的代理类.



## 动态代理

简介:J***DK的动态代理 - 只能代理接口***.CGLIB代理 - 既可以代理接口,代理实现类.

在程序的运行期间,在内存中生成这么一个代理对象.然后我们可以获取这个对象.

~~~java

~~~

