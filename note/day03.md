# 方法介绍

简介:方法就是封装一段程序,方便多次调用.可以屏蔽底层的细节.

提高代码的复用性以及程序的可维护性.



# 方法的定义和使用

~~~java
最全语法:
修饰符 返回类型 方法名([参数列表]) [throws 可抛出的异常列表]{
  
}

现阶段的语法:
修饰符 返回类型 方法名([参数列表]){
  
}
~~~



## 修饰符

* 访问修饰符 - 决定这个方法可以在哪里被访问

  * ***public - 公开的,公共的.***
  * ***private - 私有的,只有在当前类中调用私有方法.***

  * **缺省的 [] - 当前包中可以被使用**
  * protected - 受保护的 - [学习到继承的时候]

* 其他修饰符
  * ***static - 静态的.使用static修饰符的方法 - 静态方法否则叫做非静态方法***
    决定了方法被调用的方式[类调用,对象调].
  * final - 不可变的.
  * abstract - 抽象的.



补充:修饰符使用的顺序是没有限制的.

~~~java
//程序的唯一的入口
//修饰符之所以可以调换顺序 - 修饰符在底层都是在进行位运算.
static public void main(String[] args) {
  System.out.println("---");
}
~~~



## 返回类型

### 带有返回类型

* ***八种基本数据类型***
  * 注意点
    * 方法体中的最后(方法的出口)处一定要存在return+返回值;
    * 方法的返回的结果的类型应该要小于或者等于方法定义时候的类型,如果比定义的类型大,那么需要手动进行强制类型转换
    * 调用方法的时候,需要使用大于或者等于方法的定义时候的类型来存储方法的结果结果.
* **对象类型[内置对象类型(比如String)**以及自定义对象类型]

### 无返回类型

* 使用void关键字

* 使用注意点:

  * 应用场景 - 专门用来处理某个流程的,不需要返回值的.

  * 也是允许出现return语句的.在无返回类型的方法体中如果出现了return语句

    那么这个**return语句的作用是用来结束整个方法**,而并不是用来返回这个方法的执行结果

    

## 方法名称

**标识符** - 给类,变量,常量,包,方法取的名字

参考 - 变量的命名



## 定义方法的注意点

* ***方法体中不能再去定义方法!!!***
* 程序的主入口始终只有1个,并且是由main方法担当!
* 方法体中是可以调用方法的.要想执行自定义的方法 - 必须在main方法中去调用.



## 方法调用的结论

* **静态方法调用 - 通过类调用.静态方法是属于类的.**
* **非静态方法调用 - 通过对象调用.非静态方法是属于对象的.**
* **非静态方法中可以直接调用静态和非静态方法**
* **静态方法中是允许直接调用静态方法,但是静态方法中是不允许直接调用非静态方法[必须通过对象]**



## 参数列表

* 形参 - 参数列表中定义的参数[变量]

  作用:就是告诉方法的调用者在调用方法的时候,需要传入的参数.

  一定要注意参数的类型以及顺序以及个数. - 没有实际的值.

* 实参 - 调用方法的时候,实际传入的值 - 实际的值

* 可变长列表



# 导包操作

**调用其他包下的类中的方法的时候**,第一步需要先导包,通过import语句.

**导包的目的是为了告诉程序具体使用的是哪个包中的哪个类!!!**

* ```java
  import tech.aistar.day03.imports.c.Demo01;//导入的具体的包下的类.
  ```

* import tech.aistar.day03.imports.c.*;



## 找包的顺序

* 本包 - 不需要导入
* java.lang包下的类在使用的时候,不需要导包,默认搜索的.



## 认识jdk中的包

* java.lang - java核心包 - 无需手动导包.

  比如System,String

* java.util - java工具包

  比如Date

* java.sql
* java.net
* java.text
* java.io



# 总结方法

* 看是否需要导包
* 看方法有没有权限被访问的 - 防止是一个私有的.
* 看方法的是否为静态的和非静态的.
* 考虑方法的参数列表
* 看方法是否带有返回类型.



# 递归算法

简介 - Recursion,在方法体中调用自己.

应用场景:当程序中遇到大量的需要重复运算的业务的时候,需要使用递归算法.

编程步骤

* 方法中调用自己

* 方法体中一定要有递归的出口.

  如果没有指定递归的出口,那么会抛出java.lang.StackOverflowError堆栈溢出错误.



注意点:能用循环算法解决的业务就不要使用递归算法去解决.因为递归算法性能比较低下.

原因是递归算法在进行运算的过程中,在内存中都会保存计算的结果.



## 斐波那契数

1 1 2 3 5 8 13 21 34 55 ...

~~~java
/**
     * 文档注释 - 解释类和方法的.
     * @param n 斐波那契数的位置
     * @return 第n个位置上对应的斐波那契数的值
     */
public static int fei(int n){
  //1.指明递归的出口
  if(n==1 || n==2){
    return 1;
  }
  //2. 方法中调用自己
  return fei(n-1) + fei(n-2);

  //fei(5) = fei(4) +          fei(3)
  //         fei(3) +      fei(2) + fei(2) + fei(1)
  //         fei(2) + fei(1) + fei(2) + fei(2) + fei(1)
  //         = 5
}
~~~



## 求俩个数的最大公约数

思路: 12%20 =12  20%12 = 8      12%8 = 4      8%4 = 0   -> 返回4

~~~java
/**
     * 求出m,n的最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int common(int m,int n){
        //1. 递归出口
        if(m % n == 0){
            return n;
        }
        return common(n,m % n);

        //common(8,4)
    }
~~~



## 作业

给定行和列,输出该行该列上对应的杨辉三角的值

~~~java
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1

//x代表行
//y代表列.
public int yangHui(int x,int y){
  
}
~~~



# 方法的重载(Overload)

简介:作用 - 简化API(应用程序接口),System.out.println();

**前提:重载的方法一定是在同一个类中.**

特征:

* 重载的方法的**名称一定要相同**
* 重载的方法的**参数列表 - 肯定不同.**
  * 参数列表的个数不一样,那么就可以不用看类型.
  * 个数一样的时候,类型必然不一样
* 重载的方法的**返回类型可以不同**



# 方法的参数传递的方式

业内有两种说法:

* **Java中只有值传递(基本数据类型还是对象数据类型)** - 正确的

* Java中基本数据类型采用值传递,对象类型采用地址传递[引用传递].

* java.lang.String字符串虽然是一个对象类型,但是在进行方法参数传递的时候,具有"值传递"的特性.

  还有一个对象java.util.Date类型.

























































