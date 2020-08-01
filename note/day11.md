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

