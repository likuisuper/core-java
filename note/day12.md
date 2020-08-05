# 包装类型

简介:属于对象类型,***八种基本数据类型都有对应的包装类型.***

* **byte - Byte**
* **short - Short**
* **int - Integer**
* **long - Long**
* **float - Float**
* **double - Double**
* char - Character
* boolean - Boolean

上面所有的关于数字类型的包装类型都会有一个共同的抽象的父类**java.lang.Number**



# Number

提供了包装类型转换成对应的基本数据类型.

* int intValue();//Integer -> int类型 - 包装类型转换成对应的基本数据类型
* long longValue();
* float floatValue();
* double doubleValue();
* byte byteValue();
* short shortValue();



# 学习目标

* 基本数据类型和包装类型以及字符串String三者之间的相互转换.



# Integer

简介:int类型对应的包装类型Integer

## 构造

* Integer(int i);//利用int类型来构建一个Integer对象.  int类型转换成Integer类型

* Integer(String s);//利用**数字形式的字符串**来构建一个Integer对象.

  String类型转成Integer类型,

  ```
  如果传入的不是一个数字形式的字符串,将会抛出一个异常
  //java.lang.NumberFormatException - 数字格式化失败异常
  ```



## 自动解封箱

简介:jdk5.0以后才提供的自动解封箱的操作

* 封箱 - 基本数据类型可以自动转换成包装类型
* 解箱 - 包装类型可以自动转换成基本数据类型



## 常用方法

* static Integer valueOf(int i);//int -> Integer

  发现在Integer内部存在一个静态的内部类IntegerCache - Integer的常量的缓冲池.

  ~~~java
      private static class IntegerCache {
          static final int low = -128;
          static final int high;//静态代码块中进行赋值127
          static final Integer cache[];//一个缓冲池 - 维护了Integer类型的数组.
      }
  ~~~

  

  ~~~java
   public static Integer valueOf(int i) {
          if (i >= IntegerCache.low && i <= IntegerCache.high)
              return IntegerCache.cache[i + (-IntegerCache.low)];
          return new Integer(i);
      }
  ~~~

  

* static Integer vlaueOf(String s);// String -> Integer,必须是数字形式的字符串

* static int parseInt(String s);//String -> int
* 关于进制换算的三个方法



## 类型转换

* String类型和int类型

  * int类型->String类型
    * 调用java.lang.String类中提供的static String valueOf(int n);

  * String类型 -> int类型
    * 调用java.lang.Integer类中的static int parseInt(String s);

* String类型和Integer类型

  * String类型 -> Integer类型
    * 调用Integer的构造方法Integer(String s);//必须是数字形式的字符串
    * 调用Integer类中提供的static Integer valueOf(String s);

  * Integer类型 -> String类型
    * 调用String类中提供的static String valueOf(Object obj);
    * 调用Integer类中提供的String toString();

* int类型和Integer类型

  * int -> Integer
    * 调用Integer(int n)构造方法
    * jdk5.0中开始提供的自动封箱的过程
    * 调用Integer中提供的static Integer valueOf(int n);

  * Integer -> int
    * 调用java.lang.Number抽象父类中int intValue();
    * jdk5.0开始提供的自动解箱的过程.



## int和Integer之间的区别

* int是基本数据类型,Integer是对象类型,int类型的包装类型

* int类型的默认值是0,Integer的默认值是null

* int类型通常使用==比较,保存的是值,Integer使用equals方法,变量中存储的是引用地址.

* 以后推荐实体类中优先使用包装类型.

  ~~~java
  private Integer id;
  private Double price;
  ~~~



# 大数字对象类型

* java.math.BigInteger
* java.math.BigDecimal



## BigInteger

* 构造BigInteger(String val);//数字形式的字符串
* 观察方法,运算符号 -> api方法.

了解一下即可.

## 实现阶乘

~~~java
public class BigIntegerDemo {
    public static void main(String[] args) {
        System.out.println(fac(6));
    }

    public static BigInteger fac(int n){
        //1. 构建一个BigInteger对象
        BigInteger bigInteger = new BigInteger(String.valueOf(n));

        //2. 判断递归的出口
        if(n == 1){
            return BigInteger.ONE;
        }
        //return n*fac(n-1);
        return bigInteger.multiply(fac(n-1));
    }
}
~~~



## 小数精度丢失解决

~~~java
package tech.aistar.day12;

import java.math.BigDecimal;

/**
 * 本类用来演示:可以使用BigDecimal对象来处理小数运行的时候精度丢失的问题
 *
 * @author: success
 * @date: 2020/8/5 2:21 下午
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        double d = 0.1d;

        //double -> String
        String first = String.valueOf(d);
        
        //String -> double

        BigDecimal b1 = new BigDecimal(first);
        BigDecimal b2 = new BigDecimal("0.2");
        System.out.println(b1.add(b2));

        System.out.println(0.1 + 0.2);
    }
}
~~~



# 枚举类型

简介:使用enum关键字来定义的.也是JDK5.0开始提供的新的**比较特殊的类型(class)**.正是因为比较特殊,所以

才造成了枚举类型具有这些特征:简洁,便捷,安全

作用:枚举类型中是用来管理应用程序中的常量属性的.在JDK5.0之前是交给常量接口管理的.枚举类型

中定义的常量 - 类型安全的常量.



## 反编译

~~~java
public final class hello extends java.lang.Enum<hello> {
  public static final hello SPRING;

  public static final hello SUMMER;

  public static hello[] values();
    Code:
       0: getstatic     #1                  // Field $VALUES:[Lhello;
       3: invokevirtual #2                  // Method "[Lhello;".clone:()Ljava/lang/Object;
       6: checkcast     #3                  // class "[Lhello;"
       9: areturn

  public static hello valueOf(java.lang.String);
    Code:
       0: ldc           #4                  // class hello
       2: aload_0
       3: invokestatic  #5                  // Method java/lang/Enum.valueOf:(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
       6: checkcast     #4                  // class hello
       9: areturn

  static {};//静态代码块的意思
    Code:
       0: new           #4                  // class hello
       3: dup
       4: ldc           #7                  // String SPRING
       6: iconst_0
       7: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      10: putstatic     #9                  // Field SPRING:Lhello;
      13: new           #4                  // class hello
      16: dup
      17: ldc           #10                 // String SUMMER
      19: iconst_1
      20: invokespecial #8                  // Method "<init>":(Ljava/lang/String;I)V
      23: putstatic     #11                 // Field SUMMER:Lhello;
      26: iconst_2
      27: anewarray     #4                  // class hello
      30: dup
      31: iconst_0
      32: getstatic     #9                  // Field SPRING:Lhello;
      35: aastore
      36: dup
      37: iconst_1
      38: getstatic     #11                 // Field SUMMER:Lhello;
      41: aastore
      42: putstatic     #1                  // Field $VALUES:[Lhello;
      45: return
}
~~~

* 自定义的枚举类型默认会去继承java.lang.Enum
* public static hello[] values();//返回所有的枚举实例.
* public static hello valueOf(String s)



## 安全性

为什么说枚举常量是类型安全的常量,为什么枚举类型是类型安全的.强调在多线程环境下是一种安全的状态.

需要用到的类肯定都是通过类加载器加载到JVM内存的.类加载器核心代码:

***本身类加载器加载类的过程就是多线程安全的过程.***ClassLoader.java

~~~java
protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
~~~

枚举类被加载到JVM的过程肯定是安全的过程.但是通过反编译查看每个枚举实例(枚举常量) public static final hello SPRING;都是通过static关键字修饰的,在类进内存的时候,静态的资源都会立即被分配空间和初始化,并且

只会初始化一次 . 保证了定义的这些枚举实例都是安全的.



## 特点

* 枚举类型中的每个枚举常量都是代表整个枚举类型的实例
* 枚举类型是不能再外部实例化的
* 枚举类型中是可以定义普通属性和普通方法的
* 枚举类型中的枚举常量都是类型安全的常量.
* 枚举类型中也是允许存在抽象方法,但是要求每个枚举类型都要重写这个抽象方法 - 了解即可.



## 实战

简介:一般具有特殊固定状态的属性 - 使用枚举类型.



# 再谈单例 - 拓展

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

***反射技术可以破坏这种单例的.***

完全通过反射的技术来无限创建"单例"的多个实例对象了吧!

~~~java
package tech.aistar.design.singleton.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 本类用来演示: 反射技术来破坏单例
 *
 * @author: success
 * @date: 2020/8/5 3:36 下午
 */
public class TestSingleton04Demo {
    public static void main(String[] args) {
        Singleton04Demo s1 = Singleton04Demo.getInstance();
        Singleton04Demo s2 = Singleton04Demo.getInstance();
        System.out.println(s1 == s2);//true

        System.out.println("========");

        //java.lang.Class<T> 是反射技术的基础类
        Class<?> c = Singleton04Demo.class;

        try {
            Constructor<?> constructor = c.getDeclaredConstructor();

            //反射技术同时也是可以破坏封装性的.
            constructor.setAccessible(true);

            //反射的技术来构建一个类的对象
            Singleton04Demo s3 = (Singleton04Demo) constructor.newInstance();

            System.out.println(s1 == s3);//false

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



## 枚举类单例模式

第一个版本

~~~java
public enum Singleton07{
   INSTANCE;
  
   public static Singleton07 getInstance(){
       return INSTANCE;
   }
}
~~~

~~~java
package tech.aistar.design.singleton.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2020/8/5 3:45 下午
 */
public class TestSingleton07 {
    public static void main(String[] args) {
        Singleton07 s1 = Singleton07.getInstance();
        Singleton07 s2 = Singleton07.getInstance();

        System.out.println(s1 == s2);//true

        //尝试使用反射技术来破坏...
        //1. 获取class实例
        Class<?> c = Singleton07.class;

        try {
            //每个构造方法都对应对应一个constructor实例.
            //拿到的是一个空参构造...

            //java.lang.NoSuchMethodException:
            // tech.aistar.design.singleton.enums.Singleton07.<init>()

            //父类java.lang.Enum
            //protected Enum(String name, int ordinal) {
            //        this.name = name;
            //        this.ordinal = ordinal;
            //    }

            //调用两参构造
            Constructor<?> constructor = c.getDeclaredConstructor(String.class,int.class);

            constructor.setAccessible(true);

            //仍然还是会继续报错....
            
            //newInstance方法的底层.. - Cannot reflectively create enum objects
            
            // if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            //            throw new IllegalArgumentException("Cannot reflectively create enum objects");
            
            //在底层会对类型进行判断,如果发现是枚举类型,则抛出异常...
            Singleton07 s3 = (Singleton07) constructor.newInstance("INSTANCE",0);


        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

~~~

反射技术不会破坏枚举类型的单例形式.



