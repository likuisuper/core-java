# static关键字

* static修饰方法 - 静态方法 - 类调用
* static修饰属性 - 静态属性 - 类变量 - **类拥有的,对象共享的**
* static修饰代码块 - 静态代码块
* 静态导入包
* 静态内部类 - [以后讲]



## 简介

static修饰的成员(方法或者属性)初始化的时机:当JVM加载类进内存的时候,就会优先给静态成员分配空间

以及初始化,并且赋值的机会只有一次,和创建多少个对象无关!

**static修饰的成员,在内存中的实例只有一个,属于类实例,和对象无关!!!**



## 活动过程

***JVM内存模型 - 栈,堆,方法区.***

JVM加载类进内存的活动过程.

* JVM加载需要的类进内存.
* 立即会给静态属性分配空间以及初始化[赋值]
* 接着,会给静态方法分配空间以及初始化.
* 调用静态代码块
* 如果遇到了创建对象的语法
  * 会给所有的非静态属性分配空间以及初始化
  * 接着,会给所有的非静态方法分配空间以及初始化
  * 调用普通代码块
  * 调用构造块



## 拓展

Hello.java

~~~java
public class Hello{
    static{
        id = 1;
    }

    private static int id = 5;

    public static void main(String[] args){
        System.out.println(id);//5
    }
}
~~~

~~~java
admindeMacBook-Pro:Desktop admin$ javap -c Hello
Compiled from "Hello.java"
public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: getstatic     #3                  // Field id:I
       6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       9: return

  static {};
    Code:
       0: iconst_1
       1: putstatic     #3                  // Field id:I
       4: iconst_5
       5: putstatic     #3                  // Field id:I
       8: return
}
~~~

第二种:

~~~java
public class Hello{
    private static int id = 5;
  
    static{
        id = 1;
    }
    public static void main(String[] args){
        System.out.println(id);//1
    }
}
~~~

~~~java
admindeMacBook-Pro:Desktop admin$ javap -c Hello
Compiled from "Hello.java"
public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: getstatic     #3                  // Field id:I
       6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       9: return

  static {};
    Code:
       0: iconst_5
       1: putstatic     #3                  // Field id:I
       4: iconst_1
       5: putstatic     #3                  // Field id:I
       8: return
}

~~~



## 静态导入

~~~java
package tech.aistar.day09;

//import static java.util.Calendar.YEAR;
//import static java.util.Calendar.MONTH;

import java.util.Calendar;

//静态导入静态成员.
import static java.util.Calendar.*;

/**
 * 本类用来演示:静态导入
 *
 * @author: success
 * @date: 2020/7/30 10:16 上午
 */
public class StaticImport {
    public static void main(String[] args) {
        //    public final static int YEAR = 1;
       // System.out.println(Calendar.YEAR);
        System.out.println(YEAR);

        System.out.println(MONTH);

        Calendar cal = getInstance();
    }
}

~~~



# private和static

* 父类中的private私有方法是不能够被子类重写的.

  因为私有的成员是父类自己的,它是对子类也是不可见的.

  **继承其实破坏了封装性 - 一旦子类继承了父类,相当于父类把细节暴露给子类.**



* 父类中的静态static方法是不会被子类重写的.

  静态方法是不存在多态的.



# 内部类

简介 - 不推荐你们在编程中使用,但是只要能看懂即可.

**存在的意义: 内部类可以直接访问外部类中定义的成员.**

* 成员内部类 - 把内部类作为外部类的成员.

  * 不能定义静态变量

  * 可以访问外部类的静态和非静态属性.

  * 创建对象语法:

    ~~~java
    外部类.内部类 对象名 = 外部类对象.new 内部类();
    ~~~

* 静态内部类 - 把内部类作为外部类的静态成员.使用static关键字进行修饰

  * 可以定义静态变量和非静态变量

  * 不能访问外部类中的非静态属性

  * 创建对象的语法:

    ~~~java
    外部类.内部类 对象 = new 外部类.内部类();
    ~~~

* 局部内部类 - 把外部类作为局部成员存在,局部内部类出现在外部类的方法体中.

  * 局部内部类的生命周期只存在于它所在的方法,外部是不能去创建这个内部类的对象的
  * 局部内部类中是不能去定义静态属性的

* ***匿名内部类 - 推荐掌握即可 - 讲完接口***



# 设计模式 - GOF

总体来说设计模式分为三大类：

**创建型模式**，共五种：**工厂方法模式**、**抽象工厂模式**、**单例模式**、**建造者模式**、**原型模式**。

**结构型模式**，共七种：适配器模式、**装饰器模式**、代理模式、外观模式、桥接模式、组合模式、享元模式。

**行为型模式**，共十一种：策略模式、**模板方法模式**、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

**其实还有两类：并发型模式和线程池模式**



# 单例模式

简介:单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于**创建型模式**，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

**作用:保证在整个应用程序中,某个类的具体的实例永远只有一个.**

应用场景:连接池类设计成单例的.这个类属于重量级,创建对象的成本比较昂贵,很占内存资源.创建和销毁的成本比较高.

## 饿汉模式

~~~java
package tech.aistar.design.singleton.singleton01;

/**
 * 本类用来演示: 单例模式 - 饿汉模式 - 只要类被加载到内存中,立即就会执行初始化
 *
 * 目的:保证在整个应用程序中,某个类的具体的实例永远只有一个.
 *
 * @author: success
 * @date: 2020/7/30 1:59 下午
 */
public class Singleton01Demo {//重量级对象
    //2. 提供一个该类的唯一实例
    private static Singleton01Demo instance = new Singleton01Demo();

    //1.私有化构造 - 不让外界去new
    private Singleton01Demo(){
        System.out.println("构造...");//进行初始化工作的.
    }

    //3.提供一个公开的方法,来返回这个类的唯一实例instance
    public static Singleton01Demo getInstance(){
        return instance;
    }
}
class TestSingleTon01Demo{
    public static void main(String[] args) {
        //只有第一次加载Singleton01Demo类的时候,才会实例化.
        Singleton01Demo s1 = Singleton01Demo.getInstance();

        //后面无论调用多少次getInstance方法,只是在获取之前创建好的实例.
        Singleton01Demo s2 = Singleton01Demo.getInstance();
        System.out.println(s1 == s2);
    }
}

~~~



## 懒汉模式(线程不安全)

~~~java
package tech.aistar.design.singleton.singleton02;

/**
 * 本类用来演示:单例模式 - 懒汉模式
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化.
 *
 * @author: success
 * @date: 2020/7/30 2:21 下午
 */
public class Singleton02Demo {
    //2. 提供本类的一个唯一实例,但是赋值为null
    private static Singleton02Demo instance = null;

    //1. 私有化构造
    private Singleton02Demo(){
        System.out.println("构造...");
    }

    //3. 提供一个公开的方法来返回这个类的唯一实例
    public static Singleton02Demo getInstance(){
        return instance==null?instance=new Singleton02Demo():instance;
    }
}
class Test02{
    public static void main(String[] args) {
        Singleton02Demo s1 = Singleton02Demo.getInstance();
        Singleton02Demo s2 = Singleton02Demo.getInstance();
        System.out.println(s1 == s2);
    }
}

~~~



## 懒汉模式(线程安全)

~~~java
package tech.aistar.design.singleton.singleton03;

/**
 * 本类用来演示:单例模式 - 懒汉模式(线程安全)
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化.
 *
 * @author: success
 * @date: 2020/7/30 2:21 下午
 */
public class Singleton03Demo {
    //2. 提供本类的一个唯一实例,但是赋值为null
    private static Singleton03Demo instance = null;

    //1. 私有化构造
    private Singleton03Demo(){
        System.out.println("构造...");
    }

    //3. 提供一个公开的方法来返回这个类的唯一实例
    
    //synchronized - 给这个方法加锁
    //加锁的目的是,当多个线程同时到达想要执行getInstance方法的时候
    //那个线程先抢到这个"锁"资源,那么就由哪个线程进去执行,其他线程
    //将会进入到阻塞状态[等待状态]
    //优先执行的这个线程执行完整个方法中的程序之后,释放锁资源
    
    //曾经拥有过锁资源的线程释放锁之后,仍然还会继续争抢锁资源.
    
    //弊端
    //1. 多线程环境下 - 性能是低下的.
    //2. 只有有线程尝试调用getInstance方法成功,那么就会不断产生"锁"对象.
    //"锁"既然是对象,对象肯定是占内存.锁资源也是一个昂贵的资源.
    public synchronized static Singleton03Demo getInstance(){
        //return instance==null?instance=new Singleton02Demo():instance;

        //如果在多线程场景下,多个线程同时调用getInstance方法
        //并且同时判断出instance == null,那么就可能同时执行new Singleton02Demo()
        //所以它在多线程的场景下,不能保证类的实例永远只有1个.
        if(instance == null)
            instance = new Singleton03Demo();
        return instance;
    }
}
~~~



## 懒汉模式(双重检测) - 推荐大家掌握写到笔试试卷中的

~~~java
package tech.aistar.design.singleton.singleton04;

/**
 * 本类用来演示:单例模式 - 懒汉模式(线程安全) - 双重检测
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化.
 *
 * @author: success
 * @date: 2020/7/30 2:21 下午
 */
public class Singleton04Demo {
    //2. 提供本类的一个唯一实例,但是赋值为null
    private static Singleton04Demo instance = null;

    //1. 私有化构造
    private Singleton04Demo(){
        System.out.println("构造...");
    }

    //3. 提供一个公开的方法来返回这个类的唯一实例
    public static Singleton04Demo getInstance(){
        //是存在程序的 - 不需要控制多线程安全的,是所有的线程都是允许同时执行的.为了不影响整个性能
        //没有必要锁住整个getInstance方法的.

        if(null == instance){//第一个判断的目的是避免产生太多的昂贵的"锁资源"对象.
            
            //synchronize代码块中的程序在同一个时刻仍然只能由单个线程去执行.
            
            //哪个线程抢到这个锁资源,那么就由这个线程进去执行.其他线程依然处于等待阻塞状态
            synchronized (Singleton04Demo.class){
                
                //如果A线程进来之后,对instance赋值完毕之后,A线程一旦执行完毕之后,将会释放锁资源
                //一旦A释放了锁资源之后,其他等待的线程,将会继续抢锁,假设被C抢到了,由线程C进来执行了.
                
                if(null == instance){//第二个判断的目的,保证再次抢到锁资源进来的这个线程不会去进行初始化了.
                    instance = new Singleton04Demo();
                }
            }
        }
        return instance;
    }
}
~~~



## volatile

~~~java
package tech.aistar.design.singleton.singleton05;

/**
 * 本类用来演示:单例模式 - 懒汉模式(线程安全) - 双重检测
 * 类加载进内存的时候,不会立即对该类进行初始化工作
 * 第一次执行getInstance方法的时候,才会进行初始化.
 *
 * @author: success
 * @date: 2020/7/30 2:21 下午
 */
public class Singleton05Demo {
    //2. 提供本类的一个唯一实例,但是赋值为null
    private static volatile Singleton05Demo instance = null;

    //1. 私有化构造
    private Singleton05Demo(){
        System.out.println("构造...");
    }

    //3. 提供一个公开的方法来返回这个类的唯一实例
    public static Singleton05Demo getInstance(){
        //是存在程序的 - 不需要控制多线程安全的,是所有的线程都是允许同时执行的.为了不影响整个性能
        //没有必要锁住整个getInstance方法的.

        if(null == instance){//第一个判断的目的是避免产生太多的昂贵的"锁资源"对象.

            //synchronize代码块中的程序在同一个时刻仍然只能由单个线程去执行.

            //哪个线程抢到这个锁资源,那么就由这个线程进去执行.其他线程依然处于等待阻塞状态
            synchronized (Singleton05Demo.class){

                //如果A线程进来之后,对instance赋值完毕之后,A线程一旦执行完毕之后,将会释放锁资源
                //一旦A释放了锁资源之后,其他等待的线程,将会继续抢锁,假设被C抢到了,由线程C进来执行了.

                if(null == instance){//第二个判断的目的,保证再次抢到锁资源进来的这个线程不会去进行初始化了.
                    instance = new Singleton05Demo();
                }
            }
        }
        return instance;
    }
}

~~~



* 人理解的顺序
  * 申请区域①
  * 调用构造方法② - 完成对象的初始化的工作
  * 把这个对象的内存地址赋值给了引用,放到栈③

* JVM内部会进行编译指令优化,所以它会进行指令的重排.

  * 申请区域①

  * 把这个对象的内存地址赋值给了引用,放到栈③

  * 调用构造方法② - 完成对象的初始化的工作

    构造对象的过程比较繁重,比较费时.

* JVM的本地缓存协议

  每个线程都拥有一个独立的线程空间[每个线程都有一个本地缓存区域].

  那么这个线程就会从JVM的主存中把使用到的这个变量拉取到自己的本地缓存中.

  然后在本地缓存中对这个变量进行修改,修改完毕之后,还需由当前修改的线程把自己本地缓存中的

  此次的修改同步到JVM的主存中.

  ~~~java
  public static Singleton05Demo getInstance(){
    if(null == instance){①
      synchronized (Singleton05Demo.class){②
        if(null == instance){③
          instance = new Singleton05Demo();④
        }
      }
    }
    return instance;
  }
  ~~~

  JVM会对指令进行优化.

  * A从主存中拉取instance到自己本地缓存中.
  * 其他线程也会从主存中拉取instance到自己本地缓存中.

  * A到达第④,就有可能在构造对象还没完毕之前,就已经把这个对象的内存地址赋值给了instance,

    A会将instance写到主存中去了.

    * 灾难1

      * 后面的其他线程仍然会执行① - 从主存中拿instance

        instance是不为null,指向的有可能是一个尚未完成初始化工作的对象.

        .其他线程就可能使用到了一个不完整的instance指向的对象.出现bug

    * volatile

      * 其他线程拿到了一个不完整的instance指向的对象.每个线程在使用这个变量的时候

        都会从本地缓存拿到instance接着使用.

        在其他线程仍然使用这个错误的instance的时候,我们A线程有可能已经完成了构造工作.

        构造好的对象->主存.

        对于其他线程来说,并不知道主存中已经修改了,还是会继续错误的使用instance.

      * 目的:只要主存中的数据发生了改变,那么涉及到的线程在使用数据的时候,就会强制

        从主存中再次拉取.



## 登记式/静态内部类

号称:懒汉模式下的优雅的写法 - 同时也能保证线程安全.

~~~java
package tech.aistar.design.singleton.singleton06;

/**
 * 本类用来演示: 登记式/静态内部类.
 *
 * 加载外部类,但是没有使用到静态内部类的时候,静态内部类是不会被加载 - 懒
 * 
 * 多线程安全
 *
 * @author: success
 * @date: 2020/7/30 4:30 下午
 */
public class Singleton06 {

    //私有化构造
    private Singleton06(){
        System.out.println("构造..");
    }

    //静态内部类
    public static class SingletonHelper{
       
        private static Singleton06 instance = new Singleton06();
    }

    public static Singleton06 getInstance(){
        return SingletonHelper.instance;
    }
}
~~~



## 单例模式优缺点

主要优点：

1. 提供了对唯一实例的受控访问。

2. 由于在系统内存中只存在一个对象，因此可以节约系统资源，对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能。

3. 允许可变数目的实例。

 

主要缺点：

1. 由于单利模式中没有抽象层，因此单例类的扩展有很大的困难。

2. 单例类的职责过重，**在一定程度上违背了“单一职责原则”。**

3. 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这将导致对象状态的丢失。



























