# 体系

大数据阶段,***微服务+分布式+集群***,ssm,springboot.深入java体系+全栈



强大的文本编辑软件 - notepad++过或者editplus或者vscode



# Java介绍

* java之父 - james gosling
* 前身 - "oak"语言[电视机的机顶盒,嵌入式设备]
* java - 爪哇 - 印度尼西亚的爪哇岛
* 正式诞生于1995年5月23日-[jdk1.0版本],1996年推出的jdk1.1版本.
* java原先是属于sun公司[太阳微电子]的,2009年被oracle[甲骨文]公司收购了.2010年10月24日正式合并了.



# 计算机编程语言的发展史

* 打孔

* 1010101010

* 汇编语言

* 面向过程语言:C

* 面向对象的语言:java,python

* java是纯净版的C++

  

# Java语言的特点

* 属于面向对象的语言[OO]
* 简单性
* 健壮性,与平台无关性,可移植性,跨平台性 - JVM[java虚拟机]
* 动态性
* 多线程



# 人与计算机交互的方式

* CLI - Command Line Interface - 命令行方式

  早期就是应用在unix操作系统[最早的系统,诞生是1969年]

  必须要使用大量的DOS[磁盘操作系统]命令,操作也是比较麻烦的

* GUI - Graphical User Interface - 图形化用户方式

  通过鼠标点击 - 傻瓜式操作.

感受 - jdk的安装目录下的bin目录

jdK的根目录放入到D:/>tools>jdk_1.8.07

以后所有的软件的安装都不要放在***中文路径目录***中以及带有特殊符号的目录中.



## DOS命令[非重点]

打开cmd - 打开黑窗口 - 打开控制台 - 打开命令行界面

* help - 是用来查看所有的dos命令

* 进入某个盘符,比如进入d

  ~~~cmd
  C:/>d:
  
  进入到D盘
  D:/>
  ~~~

* 查看当前所在位置下的所有的内容[目录或者文件]

  ~~~cmd
  D:/>dir
  ~~~

* 创建目录

  在D盘的根目录下创建了一个目录[文件夹]名称为success.

  md - make directory

  ~~~cmd
  D:/>md success
  ~~~

* 进入到某个目录中去,比如现在想进入到success目录中去

  cd - change directory

  ~~~cmd
  D:/>cd success
  ~~~

* 创建文件

  在success目录下新建一个test.txt文件

  cd.>新建文件[文件名以及文件的后缀名]

  ~~~cmd
  D:/success/>cd.>test.txt
  ~~~

* .和..

  单个点代表的是当前目录
  两个点代表的是上一级目录

  ~~~cmd
  D:/success/>cd .
  ~~~

  ~~~cmd
  返回上一级目录
  D:/success/>cd ..
  ~~~

  返回多级的上层目录

  ~~~cmd
  D:/success/>cd ../../..
  ~~~

  返回到当前磁盘的根目录

  ~~~cmd
  D:/success/temp/aaa/ccc>cd ../../..
  D:/success/temp/aaa/ccc>cd /
  ~~~

  

* 删除目录

  **磁盘的位置先恢复到d盘根目录下**[主要是恢复到和success目录是同级的目录]

  ~~~cmd
  D:>rmdir success
  ~~~

  * rmdir 目录名称

    仅仅只能删除空目录

  * rmdir /s /q 目录

    强制删除 - 非安全性的操作,在企业中是绝对不允许的.

    ~~~cmd
    D:> rmdir /s/q success
    ~~~

* exit - 关闭控制台

# 环境变量的配置

jdk版本8.x - 官方地址:www.oracle.com

没有进行环境变量配置的时候,要是想使用java.exe这些开发命令的时候,必须每次都要进入到bin目录,才能够识别这些命令,比较麻烦.目的就是希望在任何一个目录中输入这些命令都能够被识别.



为什么需要进行环境变量的配置?

* 打开cmd

  微软符号+r -> cmd

* 输入notepad命令 - 是用来打开记事本程序.

  记事本这个应用程序是允许我们用户进行两种交互方式的.分别是GUI以及CLI

* 感受进入到***java/jdk1.8/bin***目录[存放我们开发工具的,比如***java.exe***] - 将会闪退.

  说明这个java.exe程序是不允许使用GUI方式进行交互的.只能通过CLI的方式进行交互.

* **假设如果环境变量还没有配置的时候**,打开控制台,直接输入:

  ~~~cmd
  C:/>java
  ~~~

  ***会报不是内部或者外部的命令.***

* 思考:为什么输入notepad命令的时候是成功的,但是输入java命令的时候是失败的呢?

* 继续输入path命令 - 查看计算机中的环境变量的配置的路径.它会有很多路径,每个路径与路径之间都是用分号隔开[必须是英文模式下的分号]

  ~~~cmd
  C:/WINDOWS
  ~~~

  notepad.exe[NOTEPAD.exe]

* 解释一下windows操作系统是如何能够识别到notepad.exe程序的

  比如C:/>notepad

  * 首先windows是先到当前目录下去寻找是否存在notepad.exe程序.如果当前目录下存在notepad.exe,那么就直接执行.

  * 如果当前目录下不存在notepad.exe,那么windows就会继续去扫描path[环境变量配置的路径],**扫描的顺序**

    **是从左到右,直到扫描到C:/**WINDOWS目录中发现存在了notepad.exe,所以能够成功执行

  * 如果path路径中也没有哪个目录中包含natepad的时候,那么就会提示报错,不是内部或者外部的命令.

  总结:***path路径是windows操作系统在执行命令的时候会去检查的路径.***



## 具体步骤

* 右击计算机 -属性 -  高级系统设置 - 高级 - 环境变量 - 系统变量 - 新建

  变量名:JAVA_HOME

  变量值:D:/Java/jdk1.8.0_66

* 找到Path - 编辑

  %JAVA_HOME%\bin

* 以后,凡是系统级的配置修改了,那么控制台一定要重启,才能够看到最新的效果.

* 检测环境变量是否配置成功

  ~~~cmd
  java -version
  java version "1.8.0_66"
  Java(TM) SE Runtime Environment (build 1.8.0_66-b17)
  Java HotSpot(TM) 64-Bit Server VM (build 25.66-b17, mixed mode)
  ~~~



# Java程序体验

***java程序从编写 - 编译 - 执行的过程和原理.*** - 不用关心代码是怎么写的???

以.java为后缀的文件 - java的源文件

以. class为后缀的文件 - java的字节码[二进制]文件

HelloWorld.java

~~~java
//定义类
//public 和 class都是java中的关键字
//关键字 - 这门语言赋予了这些单词具备特殊的功能
//功能 - 定义一个公开的类
//类是java的基本单位.
//{} - block块 - 代码块
public class HelloWorld{//此处的HelloWorld是类名[类的简称]
  //固定的语法 - main方法 - 程序的主入口.
  //现阶段 - 程序代码都是写在main方法体内的
  public static void main(String[] args){
		//jdk中提供的方法[封装好了的"神器"]
    //输出一句话.
    System.out.println("HelloWorld");
  }
}
~~~

定位到HelloWorld.java的所在的当前目录

javac 文件名.后缀名

~~~java
admindeMacBook-Pro:Desktop admin$ javac HelloWorld.java 
~~~

对java的源文件进行**编译.**[结论:java的源程序是不能够直接被底层的计算机系统识别的]

在当前目录中就会生成HelloWorld.class文件[字节码文件]

~~~java
admindeMacBook-Pro:Desktop admin$ java HelloWorld
HelloWorld
~~~



## 流程

.java[源文件] -> 经过jdk中的编译器(javac.exe) -> .class[字节码文件] 

-> 经过jvm[java虚拟机]中的解释器[java.exe] -> 对.class文件进行逐行解释[翻译]

-> 翻译成底层的操作系统的能够识别的语言.



jvm - "YY"成 以.class文件为指令的CPU



# JDK和JRE和JVM

* JVM(Java Virtual Machine) - Java虚拟机 - 不跨,每个不同的操作系统的虚拟机是不一样的.

  java程序就是在jvm上运行的.  - "翻译官" - **健壮性**,与**平台无关性**,**可移植性**,**跨平台性**

* JRE(Java Runtime Environments) - java运行时环境.针对用户而言的,如果计算机中只要运行java程序的.只要安装jre即可.    jre中包括jvm以及支持java程序能够运行的核心的内库.

* JDK(Java Development Kits) - java开发工具包 - 针对开发者.jdk中包含开发工具[java.exe,javac.exe,jar.exe,javadoc.exe,javap.exe...]以及JRE.

  

## 编译型和解释型语言

C语言->编译型语言->一次性**编译**成操作系统识别的语言.

"中文的新华字典" -> 一次性的编译成[翻译] -> "日本的新华字典"



Java语言->解释型语言->只要每次使用到的时候就去翻译

"中文的新华字典" 并不会一次性全部翻译成 "日本的新华字典".

查看到哪个汉字,那么翻译成对应的日文.



# Java支持三个技术平台

* JavaSE(j2se) - java standard editional - java标准版 - java的核心

  适合进行桌面程序的开发.

* JavaEE - java enterprise editional - java企业版,它不是一门具体的技术

  而是一套技术的规范.javasee中包含十三种核心技术[servlet,jsp...].

  更名成Jakarta

* JavaME(Java Micro editional) - java微型版 - 手持设备



# 包

package.作用:包是用来管理类的.包对于类的作用就是相当于文件夹对于文件的作用.



命名规则:

* 包名是推荐使用公司的域名倒置(比如com.baidu)+项目代号

* 全部由小写字母组成.如果出现多个单词,单词用.隔开

  每个单词都是一个目录.

* 不能以javax或者java开头.

* package 声明包;//一定要出现在类文件中的首行的

* 之前的HelloWorld是类的简称.类的全称[类的全限定名]

  包名+类名- ***tech.aistar.day01.HelloWorld***



# 类的命名规则

* 文件名和类名要高度保持一致.

* 类名必须是由字母,数字,下划线或者$中的元素构成.

  ***但是不能以数字开头***

* 推荐使用**大驼峰命名法则** - 首字母必须是大写,其他单词的首字母也要大写,其他的单词采用小写

  HelloWorld,[python或者mysql中hello_world-匈牙利命名方式]

* 命名不允许使用中文,中文的拼音.
* 不能是java中的关键字[public class static void main package out if while for ...]
* 不能是java中的内置的对象(System,String,Date...)
* 提倡见名知意.
* 不能使用java中的三个***字面量***true,false,null
* 不能使用java中的俩个***保留关键字const,goto***



# java中三种注释类型

注释是给人看的.   1/3

* 单行注释  ctrl+/

* 多行注释

  ~~~cmd
  /*
  
  
  */
  ~~~

* 文档注释 - 用来解释Type,以及解释方法.

  ~~~java
  /**
  
  
  
  */
  ~~~

  









