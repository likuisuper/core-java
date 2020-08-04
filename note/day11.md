# 字符串处理类

* java.lang.String
* java.lang.StringBuilder
* java.lang.StringBuffer



## String类

简介:它是一个不可变的字符串,**字符串的本质是字符数组,**底层源码

~~~java
//使用final进行修饰的,final关键字修饰的类,不能够被子类继承.
public final class String{
    /** The value is used for character storage. */
    private final char value[];//不可变的字符数组.
  
    //String str = "good";
    //如何进行存储,把"good"存储到char value[]中,'g','o','o','d';
}
~~~



### 创建方式

* 利用new关键字来构建一个字符串对象

  ~~~java
  String s = new String("ok");
  面试题问:此处创建了几个对象? - 2个[面试官期望得到的答案],实际情况其实是1个或者2个.
  String s1 = new String("ok");
  原因如下:
  * 如果是第一次执行上面的代码String s = new String("ok");就会创建2个对象.
    分别是new String("ok")以及"ok".它会在堆里面申请区域,初始化字符串对象("ok"->底层的字符数组中).
    同时还会将"ok"对象放一份到常量池中 - 堆和字符串常量池中都会存在对象!
    
  * 当程序执行到String s1 = new String("ok");
    仍然会在堆空间中创建字符串对象,但是轮到常量池的时候,会先到常量池中寻找是否已经存在"ok",发现是存在的. 
    所以在常量池中是不会再次创建重复的"ok"对象的.
    s1默认保存的是堆空间中的内存地址,当然也是有办法让它重新指向串池中的字符串对象的.
  ~~~

  ~~~java
  String s1 = new String("ok");
  String s2 = new String("ok");
  System.out.println(s1 == s2);//false,比较的是值(地址)
  ~~~

* 通过串池的方式[字符串常量池]来构建一个字符串对象

  ~~~java
  String s3 = "abc";//此处就仅仅只会1个对象,并且将这个对象扔到JVM内存的常量池区域中.
  String s4 = "abc";//其实是每次通过串池的方式创建字符串的时候,优先先到字符串常量池中去寻找是否已经存在字符串"abc",如果找到,直接将"abc"的地址赋值给s4,如果没有了,那么就在常量池扔一个对象"abc",把地址赋值给s4.
  System.out.println(s3 == s4);//true
  ~~~



### 字符串的拼接

字符的拼接使用的是+进行拼接.性能比较低下.why?

结论:因为字符串每次拼接的时候,都会产生一个新的对象(StringBuilder).

然后接下来+,就是代表StringBuilder类中提供的append方法.

~~~java
String s1 = "a"+"b"+"c";//此处在串池中创建了几个对象 - 5个
"a" "b" "ab" "c" "abc"
~~~

~~~java
public class StringDemo{
    public static void main(String[] args){
        String s3 = "abc";

        //StringBuilder b1 = new StringBuilder(s3);

        //b1.append("aa");
        String s4 = s3 + "aa";
        String s5 = s4 + "cc";
    }
}
admindeMacBook-Pro:Desktop admin$ javap -c StringDemo
Compiled from "StringDemo.java"
public class StringDemo {
  public StringDemo();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: ldc           #2                  // String abc
       2: astore_1
       3: new           #3                  // class java/lang/StringBuilder
       6: dup
       7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      10: aload_1
      11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      14: ldc           #6                  // String aa
      16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      19: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      22: astore_2
      23: new           #3                  // class java/lang/StringBuilder
      26: dup
      27: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
      30: aload_2
      31: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      34: ldc           #8                  // String cc
      36: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      39: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      42: astore_3
      43: return
}
~~~



# 设计模式

## 设计模式概念

设计模式（Design Pattern）**是一套被反复使用、多数人知晓的、经过分类的、代码设计经验的总结**。

使用设计模式的目的：为了**代码可重用性**、让代码更容易被他人理解、保证代码可靠性。 设计模式使代码**编写真正工程化**；设计模式是软件工程的基石脉络，如同大厦的结构一样。

项目中合理地运用设计模式可以完美地解决很多问题，每种模式在现实中都有相应的原理来与之对应，**每种模式都描述了一个在我们周围不断重复发生的问题，以及该问题的核心解决方案**，这也是设计模式能被广泛应用的原因。



总体来说设计模式分为三大类：

**创建型模式**，共五种：**工厂方法模式**、**抽象工厂模式**、**单例模式**、**建造者模式**、**原型模式**。

**结构型模式**，共七种：适配器模式、**装饰器模式**、代理模式、外观模式、桥接模式、组合模式、享元模式。

**行为型模式**，共十一种：策略模式、**模板方法模式**、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

**其实还有两类：并发型模式和线程池模式**



## 简单工厂

简单工厂模式是属于创建型模式，**但不属于23种GOF设计模式之一**。简单工厂模式是由一个工厂对象决定创建出哪一种产品类的实例。简单工厂模式是工厂模式家族中最简单实用的模式，可以理解为是不同工厂模式的一个特殊实现。简单工厂一般分为：**普通简单工厂**、**多方法简单工厂**、**静态方法简单工厂**。 



### 普通简单工厂

~~~java
package tech.aistar.design.factory.common.test01;

/**
 * 本类用来演示:普通简单工厂
 * 作用:根据传入的参数,来返回具体的某个产品
 *
 * @author: success
 * @date: 2020/8/3 9:58 上午
 */
public class SenderFactory {

    //多态的应用 - 面向接口编程
    //3 - 方法的返回类型写成接口,方法体的返回值可以写成这个接口的任何一个实现类对象
    public Sender getInstance(String product){
        Sender sender = null;
        //一个工厂是可以创建多个产品的.
        if("QQ".equals(product)){
            sender = new QQSender();
        }else if("WX".equals(product)){
            sender = new WXSender();
        }else{
            System.out.println("对不起,产品不存在!");
        }
        return sender;
    }
}
~~~



### 多方法简单工厂

~~~java
package tech.aistar.design.factory.common.test02;

/**
 * 多方法简单工厂 - 每个产品对应一个创建方法
 *
 * 当新增一个产品的时候,还是动工厂类 - 不符合"开闭原则"
 * 
 *
 * @author: success
 * @date: 2020/8/3 9:58 上午
 */
public class SenderFactory {

    public Sender produceQQ(){
        return new QQSender();
    }

    public Sender produceWX(){
        return new WXSender();
    }
}
~~~



### 静态方法简单工厂

~~~java
package tech.aistar.design.factory.common.test03;

/**
 * 静态方法简单工厂 - 每个产品对应一个创建方法
 *
 * 当新增一个产品的时候,还是动工厂类 - 不符合"开闭原则"
 *
 *
 * @author: success
 * @date: 2020/8/3 9:58 上午
 */
public class SenderFactory {

    public static Sender produceQQ(){
        return new QQSender();
    }

    public static Sender produceWX(){
        return new WXSender();
    }
}
~~~



### 简单工厂优缺点

优点：

- 很明显，简单工厂的特点就是“简单粗暴”，通过一个含参的工厂方法，我们可以实例化任何产品类，上至飞机火箭，下至土豆面条，无所不能。所以简单工厂有一个别名：上帝类。

缺点：

- 任何”东西“的子类都可以被生产，负担太重。当所要生产产品种类非常多时，工厂方法的代码量可能会很庞大
- **在遵循开闭原则（对拓展开放，对修改关闭）的条件下，简单工厂对于增加新的产品，无能为力。因为增加新产品只能通过修改工厂方法来实现。**



### 拓展

开发中的简单工厂设计模式的应用 - **反射工厂**

* ***反射创建对象***

  * 获取的类的class实例

  * 调用newInstance方法

  * 代码

    ~~~java
    //1. 获取类的class实例
    try {
      Class<?> c = Class.forName("tech.aistar.design.factory.common.test04.QQSender");
    
      //2. 反射创建对象
      Sender qq = (Sender) c.newInstance();
    
    } catch (ClassNotFoundException e) {//类的全限定名不能写错
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
    ~~~



##工厂方法模式

简单工厂模式有一个问题就是，类的创建依赖工厂类，也就是说，**如果想要拓展程序，必须对工厂类进行修改，这违背了开闭原则，所以，从设计角度考虑，有一定的问题，如何解决？就用到工厂方法模式，创建一个工厂接口和创建多个工厂实现类，这样一旦需要增加新的功能， 直接增加新的工厂类就可以了，不需要修改之前的代码**。 

### 工厂方法模式优缺点

优点：

- 工厂方法模式就很好的减轻了工厂类的负担，把某一类/某一种东西交由一个工厂生产；（对应简单工厂的缺点1）
- 同时增加某一类”东西“并不需要修改工厂类，只需要添加生产这类”东西“的工厂即可，**使得工厂类符合开闭原则。**

缺点：

- 相比简单工厂，实现略复杂。
- 对于某些可以形成产品族的情况处理比较复杂（相对抽象工厂）。



## 抽象工厂

抽象工厂模式是所有形态的工厂模式中最为抽象和最具一般性的一种形态。抽象工厂模式是指当有多个抽象角色时，使用的一种工厂模式。**抽象工厂模式可以向客户端提供一个接口，使客户端在不必指定产品的具体的情况下，创建多个*产品族*中的产品对象**。根据里氏替换原则，任何接受父类型的地方，都应当能够接受子类型。因此，实际上系统所需要的，仅仅是类型与这些抽象产品角色相同的一些实例，而不是这些抽象产品的实例。换言之，也就是这些抽象产品的具体子类的实例。工厂类负责创建抽象产品的具体子类的实例。



## 抽象工厂模式优缺点

优点： 

- 抽象工厂模式隔离了具体类的生产，使得客户并不需要知道什么被创建。
- 当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
- 增加新的具体工厂和产品族很方便，无须修改已有系统，符合“开闭原则”。

​        缺点：

- 增加新的产品等级结构很复杂，需要修改抽象工厂和所有的具体工厂类。



# java.lang.Object

它是所有的类的根类,一个类都是直接或者间接继承这个Object对象的.它里面提供的API方法,应该就是所有对象都是可能使用的.

* String toString();//输出对象的内存地址.

  ~~~java
  public String toString(){
    return getClass().getName()+"@"+Integer.toHexString(hashcode());
  }
  ~~~

* equals方法

  boolean equals();//比较俩个对象

  基本类型使用 == 比较,对象类型一般使用equals比较.

  ==比较方式

  两种说法***:基本类型使用 == 比较的是值,对象类型使用 == 比较的是内存地址.***

  第二种说法: ***== 比较的就是值.***

  java.lang.Object中提供的equals方法的底层:

  底层实际上仍然是使用了 == 进行了比较.

  ~~~java
  public boolean equals(Object obj) {
    return (this == obj);
    //return b1 == b2;
  }
  
  Book b1 = new Book(1,"1001","java");
  Book b2 = new Book(1,"1001","java");
  System.out.println(b1 == b2);//false
  
  System.out.println(b1.equals(b2));//false
  ~~~

## 重写equals方法

~~~java
@Override
public boolean equals(Object obj){
  //1. 非空性
  if(null == obj)
    return false;
  //2. 自反性
  if(this == obj)
    return true;
  //3. 比较对象中具体的属性的值
  //比如假设只要俩个对象的id是一致的,那么就认为是同一个对象
  //是同一个对象,就返回true
  if(obj instanceof Book){
    Book b = (Book)obj;
    return this.id == b.getId();
  }
  return false;
}
~~~



## 关于hashcode

equals方法通常和hashcode同时出现,"好哥俩".出现在equals方法中的属性肯定也会出现在hashcode方法里.

java.lang.Object中提供的

~~~java
public native int hashCode();
~~~

把一个对象放到内存之前,先是调用hashcode方法来得到hash值,简单理解 - 一个hash值对应一个内存地址.

* 当对象比较多的时候,hash值要尽可能不重复,尽可能散列.
* 计算这个hash值的时候,速度要很快.

选用了一个非常好的质数31 - 反复验证,质数*N,是最有可能不重复的.

31*N = (N << 5)-N;

hashcode存在的意义在于去重.配合我们以后学习的集合框架来使用的.

[当hash值产生哈希碰撞的时候,还需要进一步还是用equals来判断是否为同一个对象.]

~~~java
//无序不可重复
Set<Book> sets = new HashSet<>();

Book b1 = new Book(1,"1001","java");
Book b2 = new Book(2,"1002","java");
Book b3 = new Book(3,"1003","java");
Book b4 = new Book(1,"1004","java");

sets.add(b1);
sets.add(b2);
sets.add(b3);
sets.add(b4);

System.out.println(sets.size());

如果没有hashcode方法存在的话,那么每次调用add方法都会执行equals方法,比较消耗时间的.提供hashCode的目的在于提供程序的性能.

当每次调用add方法的时候,会调用该对象的hashCode()方法来得到一个哈希值.根据这个哈希值来确定一个地址.然后
将这个对象放入到该地址对应的区域中.
  
当第二次调用add方法的时候,仍然还是会先调用该对象的hashCode方法来得到一个哈希值
如果这个哈希值在这之前没有出现过,说明可以直接得到一个新的地址,然后直接把对象扔进去
如果这个哈希值在这之前曾经出现过,说明这个位置可能被占用了,但是由于哈希值是通过计算得来的,它有可能存在哈希碰撞
[哈希冲突],因此还不能判断这个对象和之前的那个对象是同一个对象,这个时候才会要再次调用equals方法来进一步判断
如果equals返回true,说明这个位置真的被占用了,真的是同一个对象了,如果equals返回false,还是允许直接放.
~~~



经典的四句话:

* 当俩个对象相同的时候[equals返回true],hashCode一定是一样的.
* 当俩个对象不相同的时候,hashCode不一定不相等.
* HashCode如果不一样,俩个对象肯定不同.
* HashCode一样,俩个对象不一定相等.



## clone方法

~~~java
 protected native Object clone() throws CloneNotSupportedException;
 native也是关键字 - 调用的是本地方法栈中的方法
~~~

* 浅拷贝 - java.lang.Object类中默认提供的clone方法就是浅拷贝(浅克隆,浅复制,浅层复制)

  * 修改原来对象的基本数据类型以及***String类型以及Date类型***,是不会对克隆出来的对象造成任何影响的
  * 修改原来对象中的对象类型的时候,那么会对拷贝出来的对象造成影响的.
  * 总结:基本数据类型不共享,对象类型共享.

* 深拷贝

  并不高效,可以多次使用,提高代码的复用性.

  ***所有的类型都不共享.***

  应用场景:应用程序中存在A对象,然后需要一个**[独立的B对象](
              //特点:修改原对象b1,看是否对拷贝出来的副本对象b2造成影响.
              b1.setId(100);)**.B对象和A对象中所有的属性值高度保持一致.

  重写clone方法,实现自己的业务逻辑.

  ~~~java
  		/**
       * 深拷贝 - 所有的类型都不共享,原来的对象和副本对象是俩个完全独立的对象.
       * @return
       * @throws CloneNotSupportedException
       */
      @Override
      public Object clone() throws CloneNotSupportedException {
          Book newBook = new Book();//副本对象
  
          //副本对象中要重新设置原来对象中的所有的值.
          newBook.setId(id);
          newBook.setIsbn(isbn);
          newBook.setBookName(bookName);
          //其余属性一一设置..
  
          //设置关联的属性
          if(null!=info){
              BookInfo bookInfo = new BookInfo();
              newBook.setInfo(bookInfo);
              
              newBook.getInfo().setId(info.getId());
              newBook.getInfo().setRemark(info.getRemark());
          }
  
          return newBook;
      }
  ~~~

  



需要克隆的对象所在的类一定更要实现java.lang.Cloneable接口.否则将会抛出java.lang.CloneNotSupportedException不能被克隆的异常.



### clone和new的区别

* new实现:在JVM中申请一块空的区域,然后通过构造方法来对属性进行赋值的.

* clone实现:调用该方法,没有走构造,但是拷贝出来的对象是存在属性值,绝对不是通过构造方法来进行赋值的.

  直接在内存区域中,肯定创建一个块区域的,但是是直接将原来对象的所有的属性的值直接拷贝一份到这个新的区域,省却了通过构造方法来对属性进行赋值的过程,所以相对速度会快一点.



## getClass

简介:获取类的class实例,每个类都是经过***类加载器***,每个类都会映射成Class类的对象.

Class类是用来描述类的类.未来,***它是我们学习的反射技术的基础类.***

特点:一个类无论被实例化多少次,那么它在内存中的class实例永远只有1个.

~~~java
public final native Class<?> getClass();
~~~



获取类的class实例的几种方式:

* 对象.getClass();
* 类名.class;
* Class.forName("类的全限定名");
* 基本数据类型.class



## finalize()

~~~java
protected void finalize() throws Throwable { }
~~~

"不确定性很大",当GC垃圾回收线程想要回收一个垃圾对象之前,会调用这个对象的finalize(重写),来进行"垂死"之前的"挣扎".

***笔试题:final和finally和finalize三者区别!!!***



# 访问修饰符

|                    | 所有类 | 子类中 | 同包中 | 本类中 |
| ------------------ | ------ | ------ | ------ | ------ |
| public 公开的      | √      | √      | √      | √      |
| protected 受保护的 | ×      | √      | √      | √      |
| 缺省的             | ×      | ×      | √      | √      |
| private 私有的     | ×      | ×      | ×      | √      |



# 任务

* java.lang.String类中提供的常用的方法自己敲一遍.
* java.lang.StringBuilder类中提供的常用的方法自己也敲一遍

* 有基础的,自我感觉特别棒棒棒的!!!

  ~~~java
  1. 根据指定的字符串到原来的字符串中进行删除操作!//送分题
     //helloworld
    
    //del("ow","hellorld")
     public static String del(String delStr,String oldStr){
      	//用递归算法来实现...
        //abcedbceeebcwe -> bc整体
    
    		//1. 出口 - 判断字符串中是否包含bc
    
    		//2. delete->删除[start,end)
    	  //del("aedeeewe","bc")
     }
  
2. 第一个串: abcdededeffffffoo
     第二个串: ffffffpopodededekkk
       
     找俩个字符串中的最大长度的公串.
     dedede ffffff
  ~~~
  



# 字符串处理类

* java.lang.String类 - 不可变的字符串,多线程安全的.
* java.lang.StringBuilder类 - 可变的字符串,多线程不安全,效率高
* java.lang.StringBuffer类 - 可变的字符串,多线程安全,效率低



## 线程问题

~~~java
public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }
StringBuilder中提供的append方法在同一个时刻会存在多个线程在同时执行.
count+=len;
假设count = 5,len = 1;
但是+=不是一个原子性操作(++) - 线程演示案例.
1. 把count加载寄存器
2. 在寄存器中+1
3. 写回内存
  
在某个时刻俩个线程拿到的count都是5,都执行+1操作,出来的结果是6
~~~



# StringBuilder

~~~java
char[] value;//存放StringBuilder中的数据的
int count;//真正的有效的数据
capacity:容量,默认的容量是16个
~~~

~~~java
StringBuilder builder = new StringBuilder("abc");//长度是3个,容量是19个
//底层肯定是转换成了
//char[] value = {'a','b','c','','','','','','','',''...};//19个..

//调用append方法 - 学习过的数组的长度一旦确定了,将不能够改变.
@Override
public StringBuilder append(String str) {
  super.append(str);
  return this;
}

StringBuilder继承的一个抽象的父类AbstractStringBuilder类
  
public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();//len = 3
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

private void ensureCapacityInternal(int minimumCapacity) {
        // overflow-conscious code
        if (minimumCapacity > value.length)
            //扩容..
            expandCapacity(minimumCapacity);
    }

void expandCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity < minimumCapacity )
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
~~~



## String和StringBuilder转换

* String -> StringBuilder

  通过StringBuilder提供的带参构造StringBuilder(String str);

* StringBuilder -> String
  * 调用StringBuilder类中提供的String toString();
  * 调用String类型中提供的static String valueOf(Object obj);

* int -> String
  * 调用String类型中提供的static String valueOf(int i);





























