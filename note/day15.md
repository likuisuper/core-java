# File

api:**java.io** - IO流相关的API.

java.io.**File** 文件类,作用 - 就是把磁盘上的文件读取到JVM内存中,File类就是文件在内存中对应那个对象.

这个类本身只能获取文件[目录]的元信息,删除文件[目录],创建文件[目录].

它不能读取或者写入内容到文件.操作文件中具体的内容的时候需要使用流(Stream).



## 构造方法

* File(String path);//利用路径来构建一个File实例.路径可以是文件,也可以是目录的路径

  路径可以是绝对路径,也可以是相对路径.

  绝对路径 - 以磁盘号开头或者以/开头



## 常用方法

* 关于获取的方法
  * String getName();//获取file的名称.
  * String getAbsolutePath();//获取file的绝对路径
  * long length();//获取文件的大小.单位是b

* 关于判断的方法
  * boolean exists();//判断file是否存在.
  * boolean isDirectory();//判断file是否为目录 - 只能存在的
  * boolean isFile();//判断file是否为文件 - 只能判断存在的

* 关于创建的

  * boolean createNewFile();//创建文件,如果成功,返回true.

  * boolean mkdir();//创建单层次的目录
  * boolean mkdirs();//创建深层次的目录

* 关于删除的
  
* boolean delete();//删除文件或者空目录
  
* 关于加载项

  * File[] listFiles();//只能获取第一级的子集目录

  * File[] listFiles(FilenameFilter filter);//筛选指定的符合规则的文件.

    ~~~java
    public File[] listFiles(FilenameFilter filter) {//接口
      String ss[] = list();
      if (ss == null) return null;
      ArrayList<File> files = new ArrayList<>();
      for (String s : ss)
        if ((filter == null) || filter.accept(this, s))
          files.add(new File(s, this));
      return files.toArray(new File[files.size()]);
    }
    ~~~

    



## 随堂练习

给定一个目录路径,输出这个目录下的所有的file,如果是文件,则输出名称,如果是目录,输出绝对路径.



# IO流

简介:流是一组有顺序的,有起点**[源头]**和终点**[目标]**的字节集合,是对数据传输的总称或者

抽象,它的特性就是进行**数据传输**.

源头:键盘,磁盘,网络

目标:显示器,磁盘,网络

## 流分类

* 按照流的方向 - **参照物是JVM内存.**

  * **输入流** - 将外部文件的数据读入**JVM内存**
  * *输出流* - 把**JVM内存中的数据**写出到外部的文件.

* 流的读写单位

  * **字节流** - 可以**按照最小字节单位**进行读取和写入.是直接连接到**输入源**[**数据源**,"管道"]的流

    按照(1个字节8bit的二进制)为单位.一次可能会读取多个字节.

    [图片,视频 - 二进制文件]

  * **字符流**

    **是以字符**为单位进行数据处理的IO流,通常是使用字符流来**读取纯文本文件.**

    一次读入或者写出16位二进制

    不能使用字符流来处理二进制文件的.

* 流的功能

  * **节点流** - 基础流 - 才具备真正的读写能力.

    * ***FileInputStream/FileOutputStream***

  * **包装流** - "装饰器模式" - "拓展流"

    本身是不具备读写功能的.使用包装流,一定是使用节点流来构建的.



## 字节流的层次结构

**java.io.InputStream[C] - 抽象类 - 所有的字节输入流的顶级的抽象父类**

* **FileInputStream[C] - 操作文件的字节输入流**,该流是基础流,节点流,这个流才是真正具备读写能力.
* **ObjectInputStream - 操作对象类型的字节输入流**
* FilterInputStream
  * DataInputStream - 操作基本类型(包装类型)的字节输入流
  * **BufferedInputStream - 带缓存区功能的字节输入流**



java.io.OutputStream[C] - 抽象类 - 所有的字节输出流顶级的抽象父类

* **FileOutputStream[C] - 操作文件的字节输出流**,该流是基础流,节点流,这个流才是真正具备读写能力.
* **ObjectOutputStream - 操作对象类型的字节输出流**
* FilterOutputStream
  * DataOutputStream - 操作基本类型(包装类型)的字节输出流
  * BufferedOutputStream - 带缓存区功能的字节输输出流



# InputStream

* void close();//关闭流,流是一个昂贵的资源对象,使用完毕之后,一定要关闭.
* abstract int read();//一个字节一个字节进行读取
* ***int read(byte[] buf);//从输入流中读取一定的字节放入到缓冲区数组buf中.***



# Outputstream

* void close();//关闭流

* void flush();//刷新缓存.

* **void write(byte[] buf,int off,int len);**//

  因为之前已经将读取到的数据存储到buf数组中了,写入也是应该从buf中获取数据,从off下标处开始获取,写出len个.



# 具体编程步骤

~~~java
package tech.aistar.day15.io;

import java.io.*;

/**
 * 本类用来演示:第一个demo - 性能最低 - 单个字节单个字节进行读取和写入的
 *
 * @author: success
 * @date: 2020/8/12 9:33 上午
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        copy("src/tech/aistar/day15/FileDemo.java","src/tech/aistar/day15/FileDemo_副本.txt");
    }

    /**
     * 文件的拷贝操作 - FileInputStream/FileOutputStream
     * 路径可是绝对或者相对路径(src开头)
     * @param src 原文件的位置
     * @param target 目标文件的位置
     */
    public static void copy(String src,String target){
        //1. 确定流对象

        InputStream in = null;
        OutputStream out = null;

        //2. 确定文件输入流 - 确定源头
        try {
            in = new FileInputStream(src);

            out = new FileOutputStream(target);

            //3. 单个字节单个字节进行读取.
            //定义一个变量 - 用来保存每次读取到的内容
            int len = -1;

            //循环读取
            while(true){
                //如果已经到达流的尾部,in.read()返回-1
                len = in.read();

                //循环退出的条件
                if(len == -1)
                    break;

                //System.out.print((char)len);
                //将内容写到out输入流中
                out.write(len);
            }
            System.out.println("文件拷贝成功!");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {//IO异常是总的父类异常.
            e.printStackTrace();
        } finally {
            //专门进行一些释放资源的操作的.
            if(null!=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null!=out){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
~~~





# 作业

* 写一个程序,实现文件夹的拷贝! - 递归.

* 完成IBookDao.java

* DataInputStream/DataOutputStream 

  使用这个流来保存id的值.

  ~~~java
  Book b1 = new Book('1001','java');
  b1.getId();// -> 100
  Book b2 = new Book('1001','java');
  b2.getId();// -> 101
  Book b3 = new Book('1001','java');
  b3.getId();// -> 102
  ~~~

# 序列化和反序列化

* 序列化的过程 - 将内存中的对象写入到磁盘中的过程
* 反序列化的过程 - 将曾经写入到磁盘中的对象读取到JVM内存中.



可以序列化单个Java对象,序列化java中的对象数组,序列化java中的集合对象

* 序列化单个对象 - 对象所在类必须要实现可序列化接口***java.io.Serializable***[标记接口]

  如果这个单个对象中还关联了其他对象,这些关联的对象也要实现这个标记接口.

* 序列化数组 - 数组中的每个元素对象所在类也要实现这个标记接口

* 序列化一个集合对象 - 集合中的每个元素对象所在类也要实现这个标记接口.

***反之则会抛出一个java.io.NotSerializableException不可被序列化异常***

# ObjectInputStream/ObjectOutputStream

操作对象类型的字节输入流/字节输出流,这俩个流不属于基础流,不属于节点流.

这个流不具备真正的读写文件的能力.真正具备读写能力的流FileInputStream/FileOutputStream

构建一个能够读取/写入对象类型的文件字节输入流/输出流 - **必须以节点流作为"支撑"**

ObjectInputStream(InputStream in);

~~~java
ObjectInputStream in = new ObjectInputStream(new FileInputStream("路径"));
ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("路径"));
~~~

~~~java
//读对象
Object readObject();//读取对象

//写对象
void writeObject(Object obj);
~~~



## 细节操作

FileOutputStream - 两参构造

name - 路径

append - 是否追加写入,默认是false,追加 - true

~~~java
public FileOutputStream(String name, boolean append)
        throws FileNotFoundException
    {
        this(name != null ? new File(name) : null, append);
    }
~~~

分批次进行插入的时候,反序列化的时候,只能反序列化第一次保存 - 因此不能设置append为true.



# 装饰器模式

装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。

不推荐对原来的核心的对象进行直接的继承或者修改.

奶茶 NaiTea - 核心的 - > "节点流"

辅助配料 - 布丁,珍珠.... -> 装饰的东西 - "包装流"

奶茶店 - "核心职责类"和"装饰职责类" - 分开处理 - 组装各种口味的奶茶呀!!

目的 - 解耦合.

~~~java
思想:
1 - 不允许直接修改你的核心类 - 满足软件的"开闭原则".
2 - 不允许直接去继承核心的类 - 防止核心的类的子类过于膨胀,继承越多,模块与模块之间的耦合越高.
  
辅助配料的顶级的抽象类A
布丁 -> 继承A
珍珠 -> 继承A
~~~



## 组装功能更加强大的流

* 带缓存功能的能够读取对象类型的文件字节输入流.

  ~~~java
  ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("路径")));
  ~~~

  

# BufferedInputStream/BufferedOutputStream

利用IO流的装饰器思想.属于过滤流,包装流,拓展流 - 都不具备真正的读写能力,仅仅是为了提高读写的性能的.

构建一个带缓存功能的文件的字节输入流/输出流

~~~java
BufferedInputStream in = new BufferedInputStream(new FileInputStream("路径"));
~~~

底层:在创建BufferedInputStream对象的时候,底层初始化byte[] buf = new byte[8*1024];

~~~java
private static int DEFAULT_BUFFER_SIZE = 8192;

public BufferedInputStream(InputStream in) {
  this(in, DEFAULT_BUFFER_SIZE);
}

public BufferedInputStream(InputStream in, int size) {
  super(in);
  if (size <= 0) {
    throw new IllegalArgumentException("Buffer size <= 0");
  }
  buf = new byte[size];//构建该流对象的同时初始化了一个内存数组
}

~~~



# 字符流

只能操作字符文件,不能操作二进制文件.

* java.io.Reader - 字符输入流

  * java.io.InputStreamReader - 桥接器

    笔试题:请你获取键盘输入,but不允许使用Scanner.

    * java.io.FileReader - 节点流 - 真正具备读写字符文件

  * java.io.BufferedReader - 带缓冲功能的字符输入流.

* java.io.Writer - 字符串输出流

  * java.io.**PrintWriter - 自带缓冲功能**
  * java.io.OutputStreamReader
    * java.io.**FileWriter -** 文件字符输出流.



