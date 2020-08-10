# 大纲

* 泛型
* 异常处理机制



# 泛型

* 认识泛型符号
* 什么是泛型
* 为什么需要泛型
* 泛型类
* 泛型方法
* 泛型类派生出来的子类
* 泛型通配符
* 设置泛型通配符界限
* 泛型擦除
* 泛型K,V



## 泛型的诞生

简介:Jdk5.0开始引入了泛型.

~~~java
package tech.aistar.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类用来演示:借助于集合框架来理解泛型的引入
 *
 * @author: success
 * @date: 2020/8/6 8:55 上午
 */
public class JDK5BeforeDemo {
    public static void main(String[] args) {
        //最顶级的集合接口java.util.Collection[I]
        //顶级接口下拥有List子接口[I] - 常用的集合实现类ArrayList[C]
        //集合是用来替代数组的使用的.

        //在jdk5.0之前还没有引入泛型的时候,如何创建集合对象呢?
        //jdk5.0之前的集合框架 - 类型不安全的框架
        List list01 = new ArrayList();
        //我们是可以向这个集合中添加任意的数据类型的.

        //没有看到任何泛型之前,add(Object obj);

        //并没有对添加到集合中的数据进行类型的校验.
        list01.add(10);//ok
        list01.add("ok");//ok
        list01.add(null);

        String result01 = (String) list01.get(1);
        System.out.println(result01);

        System.out.println(list01);

        //jdk5.0开始引入了泛型.
        //list02中就只能添加Long类型
        //保证了程序在编译期间的类型的安全.

        //泛型只能使用对象类型. - 本质:类型的参数化,就是把类型当成参数进行传递.
        List<Long> list02 = new ArrayList<Long>();
        list02.add(100L);
        list02.add(200L);

        System.out.println(list02);
        
        //jdk7.x以后 - new ArrayList<>中的泛型是可以省略不写的.why???
        List<String> list03 = new ArrayList<>();
        list03.add("ok");
        list03.add("ok");

        list03.add("good");



        System.out.println(list03);

        //只要程序在编译期间不报错,添加到容器中的数据的类型是属于泛型的
        //那么在运行期间涉及到转换类型的时候,肯定不会报错.
        String result02 = list03.get(1);//编译期间ok
        System.out.println(result02);
    }
}

~~~





## 泛型符号

* E - 元素-对象,应用在集合中.表示可以添加到集合容器中的数据的类型.
* T - 类型
* N - 数字
* K,V - 键值对,K-键,V-值
* ***? - 比较特殊,泛型通配符***



## 什么是泛型

Java泛型设计原则：只要在编译时期没有出现警告，那么运行时期就不会出现ClassCastException异常

泛型：**把类型明确的工作推迟到创建对象或调用方法的时候才去明确的特殊的类型**



**参数化类型:**

- **把类型当作是参数一样传递** - 隐形的
- **`<数据类型>` 只能是引用类型** - 泛型只能是对象类型



## 为什么需要泛型

**早期Java是使用Object来代表任意类型的，但是向下转型有强转的问题，这样程序就不太安全**

首先，我们来试想一下：没有泛型，集合会怎么样 - ***jdk5.x为什么要引入泛型???***

- Collection、Map集合对元素的类型是没有任何限制的。**本来我的Collection集合装载的是全部的Dog对象，但是外边把Cat对象存储到集合中，是没有任何语法错误的。**

- 把对象扔进集合中，集合是不知道元素的类型是什么的，仅仅知道是Object。因此在get()的时候，返回的是Object。**外边获取该对象，还需要强制转换**

  

***有了泛型以后:***

- 代码更加简洁【不用强制转换】
- 程序更加健壮【只要编译时期没有警告，那么运行时期就不会出现ClassCastException异常】
- 可读性和稳定性【在编写集合的时候，就限定了类型】

~~~java
//没有引入泛型...
//涉及到强制类型转换的时候 -> 涉及到java.lang.ClassCastException类型转换失败异常.
Animal dog = new Dog();
Cat c = (Cat)dog;//编译期间是通过的,但是在程序的运行期间是报错的.

 String result01 = (String) list01.get(1);
 System.out.println(result01);


//引入了泛型
//只要程序在编译期间不报错,添加到容器中的数据的类型是属于泛型的
 //那么在运行期间涉及到转换类型的时候,肯定不会报错.
 String result02 = list03.get(1);//编译期间ok
 System.out.println(result02);
~~~



## 泛型类

**泛型类就是把泛型定义在类上，用户使用该类的时候，才把类型明确下来**....这样的话，用户明确了什么类型，该类就代表着什么类型...用户在使用的时候就不用担心强转的问题，运行时转换异常的问题了。

~~~java
package tech.aistar.day13;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2020/8/6 9:51 上午
 */
public class ObjectTools<T> {

    public T get(T t){
        return t;
    }

    //没有泛型的时候 - 都是使用object类型
    public Object find(Object obj){
        return obj;
    }
}
class TestTools{
    public static void main(String[] args) {
        ObjectTools<String> tools = new ObjectTools<>();

        String result01 = tools.get("ok");
        
        //编译期间一旦不会出现问题,程序运行期间就不会抛出类型转换失败的异常.
        //Integer tt = tools.get("ok");
        
        System.out.println(result01);

        ObjectTools<Integer> tools1 = new ObjectTools<>();
        Integer result02 = tools1.get(100);
        System.out.println(result02);

        ObjectTools t = new ObjectTools();

        //编译期间是正常的,但是运行期间存在类型转换失败的风险
        Integer s = (Integer) t.find("ok");
        System.out.println(s);
    }
}

~~~



## 泛型方法

我们可能就仅仅在**某一个方法上需要使用泛型**....**外界仅仅是关心该方法，不关心类其他的属性**...这样的话，我们在整个类上定义泛型，未免就有些大题小作了.

~~~java
package tech.aistar.day13;

/**
 * 本类用来演示:泛型方法
 *
 * 假设某个类中就那么几个方法需要使用泛型,那么就没有必要设置成泛型类.
 *
 * @author: success
 * @date: 2020/8/6 10:17 上午
 */
public class GenericDemo {

    /**
     * 无返回类型
     */
    public <E> void show(E e){
        System.out.println(e);
    }

    /**
     * 带返回类型
     * @param t
     * @param <T>
     * @return
     */
    public <T> T add(T t){
        return t;
    }

    /**
     * 静态方法.
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T find(T t){
        return t;
    }
}
class GenericTest{
    public static void main(String[] args) {
        GenericDemo d1 = new GenericDemo();
        d1.show("ok");

        Integer n = d1.add(100);
        System.out.println(n);

        System.out.println(GenericDemo.find(3.14));
    }
}
~~~



### 拓展 - 改造反射工厂

~~~java
//没有使用泛型
package tech.aistar.design.factory.generic;

import tech.aistar.day08.relation.extend.Cat;
import tech.aistar.day08.relation.extend.Dog;

/**
 * 本类用来演示:通用的工厂 - 可以用来创建任意对象
 *
 * @author: success
 * @date: 2020/8/6 10:25 上午
 */
public class ObjectFactory {

    public static Object getInstance(String className){
        Object obj = null;

        //1. 获取class实例
        try {
            Class<?> c = Class.forName(className);

            //反射创建类的对象...
            obj = c.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * 泛型应用在工厂
     * @param className
     * @param <T>
     * @return
     */
    public static <T> T createInstance(String className){
        T t = null;
        try {
            Class<?> c = Class.forName(className);
            t = (T) c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T createInstance2(T ts){
       T t = null;
       
       Class<?> c = ts.getClass();

        try {
            t = (T) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return t;
    }
}

class TestObjectFactory{
    public static void main(String[] args) {
       // Cat cat = (Cat) ObjectFactory.getInstance("tech.aistar.day08.relation.extend.Cat");

        //Dog dog = (Dog) ObjectFactory.getInstance("tech.aistar.day08.relation.extend.Cat");

        //Dog cat = ObjectFactory.createInstance("tech.aistar.day08.relation.extend.Cat");
        Cat cat = ObjectFactory.createInstance2(new Cat());
    }
}
~~~





## 泛型类派生出来的子类

**泛型类是拥有泛型这个特性的类，它本质上还是一个Java类，那么它就可以被继承**

那它是怎么被继承的呢？？这里分两种情况

1. **子类明确泛型类的类型参数变量**
2. **子类不明确泛型类的类型参数变量**



~~~java
package tech.aistar.day13;


import tech.aistar.day10.homework.book.Book;

/**
 * 本类用来演示:泛型类派生出来的子类
 *
 * @author: success
 * @date: 2020/8/6 10:48 上午
 */
public abstract class Sup<T> {
    public abstract T get(T t);
}
//**子类不明确泛型类的类型参数变量**
class Sub<T> extends Sup<T>{

    @Override
    public T get(T t) {
        return t;
    }
}
//**子类明确泛型类的类型参数变量**
class Sub2<Book> extends Sup<Book>{

    @Override
    public Book get(Book book) {
        return book;
    }
}
class TestSup{
    public static void main(String[] args) {
        //1. 子类没有明确泛型的类型参数变量
        Sup<String> sup = new Sub<>();
        String result= sup.get("ok");
        System.out.println(result);

        //2. 子类明确泛型类的类型参数变量
        Sup<Book> sup1 = new Sub<>();
        System.out.println(sup1.get(new Book()));
    }

}

~~~



## 拓展应用

泛型的实际的应用场景.

~~~java
/**
 * 本类用来演示:user的接口
 *
 * @author: success
 * @date: 2020/8/6 10:55 上午
 */
public interface IUserDao {
    void save(User user);
}

/**
 * 本类用来演示:图书业务接口
 *
 * @author: success
 * @date: 2020/8/6 10:55 上午
 */
public interface IBookDao {
    void save(Book book);
}

观察这俩个业务接口.
都存在插入数据的方法 - 唯一的区别,插入的对象类型不一样而已.
~~~

抽象出一个基础的,顶级的接口出来.

~~~java
/**
 * 本类用来演示: 顶级的业务接口
 *
 * @author: success
 * @date: 2020/8/6 10:58 上午
 */
public interface IBaseDao<T> {
    void save(T t);
    
    void update(T t);
    
    void delById(Integer id);
}
~~~

以后写代码,比如使用的是hibernate框架 - YY能力....

hibernate框架属于持久层框架 - 用来使用java代码和DB进行连接并且操作数据库中数据的一套框架.

既然是框架,框架的编程步骤都是一样的.

~~~java
UserDaoImpl.java
  
public void save(User user){
  Session ses = SessionUtil.openSession();//和db建立一次会话,一次连接.
  Transaction transction = ses.beginTransaction();//开启使用.

  //保存...
  ses.save(user);//关键的一步...
  
  //提交事务
  transaction.commit();
  
  //关闭session
  sesssionUtil.close(ses);

}

BookDaoImpl.java
  
public void save(Book book){
  Session ses = SessionUtil.openSession();//和db建立一次会话,一次连接.
  Transaction transction = ses.beginTransaction();//开启使用.

  //保存...
  ses.save(book);//关键的一步...
  
  //提交事务
  transaction.commit();
  
  //关闭session
  sesssionUtil.close(ses);

}
~~~

顶级接口的实现类

~~~java
package tech.aistar.day13.app;

/**
 * 本类用来演示:泛型实现类
 *
 * @author: success
 * @date: 2020/8/6 11:04 上午
 */
public class BaseDaoImpl<T> implements IBaseDao<T> {
    @Override
    public void save(T t) {
        //get - 所有的实现类的插入数据的步骤都是几乎是一样的
        //只是类型不一样而已..

        System.out.println("save:"+t);
        
//        Session ses = SessionUtil.openSession();//和db建立一次会话,一次连接.
//        Transaction transction = ses.beginTransaction();//开启使用.
//
//        //保存...
//        ses.save(t);//关键的一步...
//
//        //提交事务
//        transaction.commit();
//
//        //关闭session
//        sesssionUtil.close(ses);
    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delById(Integer id) {

    }
}

~~~

改造...

~~~java
public interface IBookDao {
    //定义自己这个接口中特有的方法...
    
    void findBook();
}

public interface IUserDao {
    //只要定义特有的方法
    void findUser();
}
~~~



UserDaoImpl.java

~~~java
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {
    @Override
    public void findUser() {
        System.out.println("findUser...");
    }
}
~~~

测试:

~~~java
public class TestUserDaoImpl {
    public static void main(String[] args) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();

        User user = new User();
        user.setUsername("admin");

        userDaoImpl.save(user);

        BookDaoImpl bookDao = new BookDaoImpl();

        Book book = new Book();

        book.setBookName("西游记");

        bookDao.save(book);
    }
}
~~~





## 泛型通配符

**?号通配符表示可以匹配任意类型，任意的Java类都可以匹配**.....

现在非常值得注意的是，当我们使用?号通配符的时候：**就只能调对象与类型无关的方法，不能调用对象与类型有关的方法。**



## 设置泛型通配符界限

* <? super Type>

  传递进来的只能是Type或Type的父类

* **<? extends Type>**

  **传进来的只能是Type或者Type的子类**

~~~java
? 泛型的符号,但是比较特殊.
  
泛型方法 - 可以使用E或者T
public <T> t get(T t){
  return t;
}
但是不允许这样写:
public <?> ? get(? t){
  return t;
}

~~~

## 泛型擦除

泛型是**提供给javac编译器使用的**，它用于限定集合的输入类型，让编译器在源代码级别上，即挡住向集合中插入非法数据。但编译器编译完带有泛形的java程序后，**生成的class文件中将不再带有泛形信息**，以此使程序运行效率不受到影响，这个过程称之为“擦除”。

~~~java
package tech.aistar.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * 本类用来演示:泛型的擦除
 *
 * 1. 泛型仅仅在编译期间有效
 * 2. 泛型在运行期间将会被擦除
 * 3. 因此泛型没有多态.
 *
 * @author: success
 * @date: 2020/8/6 1:23 下午
 */
public class GenericRemoveDemo {
    public static void main(String[] args) {
        List<Integer> list01 = new ArrayList<Integer>();
        List<Integer> list02 = new ArrayList<Integer>();

        //获取运行期间的类型...
        //获取类的class实例

        //1. 泛型在运行期间将会被擦除.
        System.out.println(list01.getClass());//class java.util.ArrayList
        System.out.println(list02.getClass());//class java.util.ArrayList

        //3. 泛型没有多态...
        //Number n = new Integer(10);//ok
        //Number m = new Long(10);//ok

        //编译不通过.
        //List<Number> list03 = new ArrayList<Integer>();
    }
}

~~~



## 泛型K,V

K - 键,V - 值,Map集合.

~~~java
package tech.aistar.day13;

import tech.aistar.day10.homework.book.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 本类用来演示:
 *
 * @author: success
 * @date: 2020/8/6 1:40 下午
 */
public class EntryDemo<K,V> {
    private K key;

    private V value;

    public EntryDemo() {
    }

    public EntryDemo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    private void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    private void setValue(V value) {
        this.value = value;
    }

    public void put(K key,V value){
        setKey(key);
        setValue(value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EntryDemo{");
        sb.append("key=").append(key);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

class TestKV{
    public static void main(String[] args) {
        EntryDemo<Integer, Book> books = new EntryDemo<Integer, Book>();
        books.put(1,new Book(1,"1001","java"));
        books.put(2,new Book(2,"1001","java"));

        System.out.println(books);

        //map集合
        Map<Integer,String> maps = new HashMap<>();
        maps.put(10,"1001");
        maps.put(20,"1002");
        System.out.println(maps);
    }
}
~~~



# 异常和错误

java.lang.Error以及java.lang.Exception都会拥有顶级的类java.lang.Throwable

## Error

* StackOverflowError - 堆栈溢出错误,当应用程序因为递归太深而找不到出口的时候.
* OutOfMemoryError - 内存溢出,内存泄漏错误.

错误一般都是虚拟机级别的错误,错误一旦发生了,程序员是解决不了的.



## Exception

简介:所谓的异常就是代表程序在运行的时候,发生了不正常的情况.异常又可以分成两大类.

* 运行时异常 - 未检测异常 - 不需要程序员处理异常
  1. 编译期间是不会通知程序员手动去处理异常的.
  2. 可以通过程序的严谨的判断,来避免运行时异常的发生了.
* 非运行时异常 - 已检测异常 - 需要程序员进行处理.
  1. 在编译期间就能够检测到程序在运行的时候可能会发生异常
  2. 因此需要在编译期间就报错,然后通知程序员手动去处理异常,比如使用try..catch..



### 运行时异常

都是属于java.lang.Runtime的子类.

* java.lang.ClassCastException - 类型转换失败异常

* java.lang.ArithmeticException - 当程序执行10/0,分母0

* java.lang.IllegalArgumentException - 非法参数异常.

  new SimpleDataFormat(String pattern);//pattern -> "success"

* java.lang.IndexOutOfBoundsException - 下标越界异常
  * java.lang.ArrayIndexOutOfBoundsException - 数组下标越界异常
  * java.lang.StringIndexOutOfBoundsException - 字符串下标越界异常

* java.util.InputMismatchException - 输入不匹配异常.
* java.lang.NullPointerException - 空指针异常



### 非运行时异常

* java.lang.CloneNotSupportedExceptio - 对象不支持clone.

  对象所在的实体类没有去实现一个标记接口java.lang.Cloneable

* java.util.ParseException - 解析失败异常.

* java.util.InterruptedException - 中断异常

* ***java.lang.NoSuchMethodException - 找不到此方法异常***

  ***当通过反射技术来调用一个不存在的构造或者反射调用一个不存在的方法的时候.***

* ***java.lang.IllegalAccessException - 非法访问异常***

  ***当通过反射技术来访问一个私有成员的时候.必须要设置setAccessible(true);***

* ***java.io.IOException - IO(Input/Output)流异常***
  * ***java.io.FileNotFoundException - 文件不存在异常.***

* ***java.lang.ClassNotFoundException - 类找不到.Class.forName("类的全限定名");***



## 异常的处理方式

主要针对的还是非运行时异常.

### 积极处理

使用try...catch来进行处理.

* 语法一 - 多个catch块 - 推荐用这个.这种写法可以针对各个异常来进行不同的异常之后的处理.

  ~~~java
  try{
    //代码...
  }catch(异常类型1 对象1){
    //..
  }catch(异常类型2 对象2){
    //...
  }
  
  注意:异常类型存在继承关系的.父类异常类型一定是出现在子类类型异常的下方.
  ~~~

* 语法二 - jdk7.0开始提供的,使用单个catch块

  ~~~java
  try{
    //代码...
    
  }catch(异常类型1 | 异常类型2 | 异常类型3 对象){
    //..
  }
  ~~~

* 语法三 - 直接使用Exception - 总的父类

  ~~~java
  try{
    //代码...
    
  }catch(Exception e){
    //..
  }
  ~~~



### finally

try和finally可以搭配使用

**try和catch以及finally搭配使用**

***finally中的代码是无论try中的代码是否出现了异常,finally块中的代码都会执行...***

防止有的昂贵的资源在程序出现异常的时候,没有得到及时的释放和清理.



#### 坑问题

finally代码块中对结果进行修改,是否会影响方法的返回值.

~~~java
 try{
   int i = 0;
   return;//结束整个方法的呀!
 }finally {
   System.out.println("finally...");
 }
~~~

当try中出现了return语句[结束整个方法的] - 请问finally中的代码执行否?

return语句是在finally语句之后执行的.



finally -> 基本数据类型进行修改.

~~~java
public static int test01(){
  int i = 0;
  try{
    ++i;
    return i;
  }finally {
    ++i;
  }
}
//结果是1
~~~

~~~java
public static int test02(){
  int i = 0;
  try{
    ++i;
    return i;
  }finally {
    return ++i; // finally中一旦出现了return语句,会对局部变量表存储的i产生影响了.
  }
}
//结果是2
~~~



finally->对对象类型进行修改

~~~java
 /**
     * finally块中修改对象类型是否会影响呢? - 产生了影响了.
     * @return
     */
public static Book test03(){
  Book b1 = new Book(1,"1001","java");

  try{
    b1.setBookName("python");
    return b1;
  }finally {
    b1.setBookName("web签单");
  }
}
Book{id=1, isbn='1001', bookName='web签单', price=0.0, author='null', publishDate=null}
~~~



### 消极处理

简介:通常情况下是由方法的最终的调用者来进行统一处理.其余地方全部采用消极处理.

~~~java
public static void add throws 异常类型{
  throw 非运行时异常的对象;
}
如果方法体中throw 运行时异常的对象   的 时候,是不会强制要求在方法的签名上throws的.
~~~

注意点:***千万千万不要把异常抛给main,等同于抛给了JVM,一旦发生了异常JVM就会中断.***



## 自定义异常

JDK内置的异常不满足实际的业务的时候,就需要手动自定义一个异常.



为什么需要使用抛出异常的方式来代替原先的SOUT错误输出形式!

因为以后在应用程序运行期间,无论什么时候发生了异常,我们的原则不能破坏用户体验.一旦程序发生了任何异常,让网页跳转到一个 - "服务器正在升级的页面....",那是因为我们的项目中使用到了Spring框架,这些框架中内部提供了全局的异常处理机制 - 它监控整个项目运行过程中,一旦有异常发生,那么就能够被他监控到,就会统一跳转.但是

如果仅仅是在代码中SOUT,是达不到监控的效果.



根据实际的业务中,项目中是需要自定义大量的异常的 - 提高可读性.



实现步骤:

* 写一个类去继承java.lang.Exception
* 提供父类5个构造



# 语法糖

try(申请资源;申请资源){

}catch(,,,){

}

~~~java
 /**
     * jdk7.0提供的语法糖
     * try(申请的资源) - 自动在使用完毕之后释放!!!!
     * @return
     */
public static int getNum(){
  try(Scanner sc = new Scanner(System.in)){
    int n = sc.nextInt();
    return n;
  }
}
~~~























