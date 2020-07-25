# java.lang.Math

这个类中提供了很多关于数学计算的方法.

* static long round(double a);//rounde底层实际就是执行的是Math.floor(a + 1/2);
* static double floor(double a);//返回的是小于或者等于最接近a的整小数
* static double pow(double a,double b);//返回的是a的b次方
* static double sqrt(double a);//开平方根
* static int abs(int a);//重载方法 - 求绝对值
* static double random();//返回的是[0.0,1.0)之间的随机小数
* static int max(int a,int b);//返回的是a和b之间的比较大的值.
* static int min(int a,int b);//返回的是a和b之间的比较小的值.



# 求随机数

java中的随机都是伪随机,有两种方式.

* java.lang.Math类中提供的random()方法.

* java.util.**Random类**中提供的int nextInt(int n);//**返回的就是[0,n)之间的随机整数.**

  ~~~java
  俩个构造方d
  Random();
  Random(long seed);
  构造方法就是决定了如何构建这个对象的方式.
  ~~~

  ~~~java
  //1. import java.util.Random;
  
  //2. 创建Random对象
  Random r = new Random();
  int result = r.nextInt(100)+1;//返回的是[1-100]
  
  //3. 返回3-5之间的随机整数
  ~~~



# java.util.Date

日期类 - 它是一个已经过时的类.因为老的项目中仍然在使用它,所以新的Jdk保留了它,如果新的jdk剔除它,导致老的项目编译不通过.新的项目中已经不推荐使用它了.现在主要使用java.util.Calendar日历类.

jdk8.x中提供了新的关于日期的API



## 构造方法

构造方法是允许重载的.

* Date();//没有过时,获取当前系统的日期
* Date(long time);//没有过时,利用毫秒数来构建一个日期对象.
* Date(int year,int month,int date);//根据指定的年月日来构建一个指定的日期对象.这是一个过时的构造



## 常用的方法

* int getYear();//获取年份
* int getXXX();//获取日期中的字段信息.
* void setXXX(参数列表);//手动一一设置日期中的字段的.



## long和Date之间的转换

* Date类型->long类型

  简介:获取日期的毫秒数,距离1970年1月1日.

  **long getTime();**

* long类型来构建Date类型

  Date(long time);

  **void setTime(long time);**



# java.util.Calendar

简介:java中提供的日历类,它是用来替代Date日期类的使用.

~~~java
public abstract class Calendar {
  
}
abstract - 关键字,抽象的,抽象的类是不能够被实例化的[不能通过new关键字来进行创建对象].
Calendar cal = new Calendar();//error
~~~



## 如何构建对象

static Calendar getInstance();

~~~java
Calendar cal = Calendar.getInstance();
~~~



## 常用方法

* int get(int field);//根据传入的field来返回指定的日历字段.
* void set(int field,int value);//给日历指定的字段设置值.
* **[set](https://www.matools.com/file/manual/jdk_api_1.8_google/java/util/Calendar.html#set-int-int-int-)**(int year, int month, int date);//统一进行赋值.



## 日历字段和日期字段相互转换

* Date getTime();//日历对象调用getTime方法就可以转换成日期类型.
* void setTime(Date date);//Date->Calendar

~~~java
//日期<->long
//long->Date
//1. Date(long time);
//2. void setTime(long time);

//Date->long
//1. long getTime(long time);


//日历->日期
//Date getTime();//java.util.Calendar

//日期->日历
//void setTime(Date d);//java.util.Calendar;
~~~

# 作业

~~~java
请你输入年份:>2020
请你输入月份:>7

日	一	二	三	四	五	六
        1  2  3 4
5  6  7
  
             24*
  
//1. 某年某月的1号是周几
//2. 获取某年某月最大天数
//3. 获取某年某月的日期
//4. 控制换行
~~~



# java.text.SimpleDateFormat

日期格式化处理类.

* 构造方法

  ~~~java
  SimpleDateFormat(String pattern);
  ~~~

* 代码演示

  ~~~java
  package tech.aistar.day06;
  
  import java.text.ParseException;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  /**
   * 本类用来演示:日期格式化处理类
   *
   * @author: success
   * @date: 2020/7/24 3:45 下午
   */
  public class SimpleDateFormatDemo {
      public static void main(String[] args) {
          //1. 利用一个pattern - 日期模板来构建一个格式化类对象
         // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
  
          //异常 - 程序在运行的过程中发生了不正常的情况.
          //注意传入的模板的正确性,否则会抛出一个异常java.lang.IllegalArgumentException非法参数异常
         //如果此行发生了异常,那么异常行下面的代码将不会执行了...
          //SimpleDateFormat sdf = new SimpleDateFormat("sucess");
  
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  
          //System.out.println("暗恋");
  
          //2. 获取当前系统的日期
          Date now = new Date();
  
          //日期格式化成指定模板形式的字符串.
  
          //未来的知识点???
          //String format(Date date);//由SimpleDateFormat的"爸爸"DateFormat提供的.
  
          String sdate = sdf.format(now);
  
          System.out.println(sdate);
  
          System.out.println("=====华丽丽的分割线===");
  
          //把日期形式的字符串 -> 日期类型
          //注意:字符串中的日期的格式要和SimpleDateFormat(String pattern)中的pattern的形式高度保持一致.
          //否则会抛出java.text.ParseException - 解析失败异常
          String str = "2020-09-08";
          SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
  
          //把字符串解析成日期类型.
          //未来的知识点 - parse方法的时候,需要手动强制抓取异常
          //alter+enter - 生成try..catch..
          try {
  
              //如果此行抛出了java.text.ParseException ,那么程序就进入到
              //catch块中去执行里面代码,并且try{}中的此行下面的代码不会执行.
              Date date = format.parse(str);
  
              System.out.println(date);
  
          } catch (ParseException e) {
              //e.printStackTrace();//打印异常的堆栈信息...
              //日志的记录...
              System.out.println("解析失败!可能是字符串格式和pattern不匹配!");
          }
  
          System.out.println("====end====");
  
      }
  }
  
  ~~~

  

## 拓展

*有基础的学生 - SimpleDateFormat的线程非安全性.*











































































































