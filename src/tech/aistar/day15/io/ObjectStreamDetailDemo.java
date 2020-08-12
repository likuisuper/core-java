package tech.aistar.day15.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:操作对象类型的文件的字节输入流/输出流 - 细节操作
 *
 * @author cxylk
 * @date 2020/8/12 11:10
 */
public class ObjectStreamDetailDemo {
    public static void main(String[] args) {
        List<Book> books=new ArrayList<>();
        Book b1=new Book(1,"1001","java");
        Book b2=new Book(2,"1002","python");
        Book b3=new Book(3,"1003","ai");

        //books.add(b1);
        //books.add(b2);
        books.add(b3);

        //save(books,"src/tech/aistar/day15/io/books.txt");

        List<Book> list=findAll("src/tech/aistar/day15/io/books.txt");

        if(null!=list&&list.size()>0){
            list.forEach(e-> System.out.println(e));
        }
    }

    /**
     * 反序列化的过程
     * 将曾经写入到磁盘中的对象读取到JVM内存中
     * @param path
     * @return
     */
    public static List<Book> findAll(String path){
        ObjectInputStream in=null;

        List<Book> books=null;

        try {
            in=new ObjectInputStream(new FileInputStream(path));

            books= (List<Book>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null!=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return books;
    }

    /**
     * 序列化的过程
     * 将内存中的对象写入到磁盘中的过程
     * @param books
     * @param path
     */
    public static void save(List<Book> books,String path){
        //1.构建一个能够支持对象类型的文件字节输出流
        ObjectOutputStream out=null;

        try {
            //两参构造 name:路径 append:是否追加写入,默认是false,追加 -true
            //true - 追加写入
            //分批次进行插入的时候,反序列化的时候,只能反序列化第一次保存
            //因此不能设置append为true
            out=new ObjectOutputStream(new FileOutputStream(path,true));

            //out=new ObjectOutputStream(new FileOutputStream(path));

            //books里面是流，乱码
            out.writeObject(books);

            System.out.println("保存集合成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
