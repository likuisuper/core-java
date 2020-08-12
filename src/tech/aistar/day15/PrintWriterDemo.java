package tech.aistar.day15;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 本类功能:字符输出流
 *
 * @author cxylk
 * @date 2020/8/12 20:30
 */
public class PrintWriterDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请你输入:>");

        String content=sc.nextLine();

        //JVM内存->磁盘中
        //输入的内容写到文件中
        String path="src/tech/aistar/day15/io/print.txt";

        //语法糖方式会自动关闭(自动刷新)

        //1.构建一个带缓冲功能的字符输出流 - 覆盖之前的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path))) {

        //2.构建一个带缓冲功能的字符输出流 - 支持追加写入的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path,true))){
//            out.print(content);
//            System.out.println("写入成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //1.不加最后的finally块的时候,写不进去
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if(null!=out){
////                out.close();
////            }
////        }

//        2.PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //加了finally就相当于自动刷新缓存
        //执行close方法是会最后还会再来一次刷新缓存,第二个true是没有必要加的
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            //out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if(null!=out){
//                out.close();
//            }
//        }

        //true ->追加写入
        //true ->自动刷新缓存
        //没有使用语法糖的时候,有的windows是写不进去的
        PrintWriter out=null;
        try {
            out=new PrintWriter(new FileWriter(path),true);

            out.print(content);

            //手动刷新缓存
            //out.flush();//没有finally块也能写入

            System.out.println("写出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2.
        //语法糖方式会自动关闭(自动刷新)

        //1.构建一个带缓冲功能的字符输出流 - 覆盖之前的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path))) {

        //2.构建一个带缓冲功能的字符输出流 - 支持追加写入的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path,true))){
//            out.print(content);
//            System.out.println("写入成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //1.不加最后的finally块的时候,写不进去
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if(null!=out){
////                out.close();
////            }
////        }

//        2.PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //加了finally就相当于自动刷新缓存
        //执行close方法是会最后还会再来一次刷新缓存,第二个true是没有必要加的
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            //out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if(null!=out){
//                out.close();
//            }
//        }

        //true ->追加写入
        //true ->自动刷新缓存
        //没有使用语法糖的时候,有的windows是写不进去的
        PrintWriter out2=null;
        try {
            out=new PrintWriter(new FileWriter(path),true);

            out.print(content);

            //手动刷新缓存
            //out.flush();//没有finally块也能写入

            System.out.println("写出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.
        //语法糖方式会自动关闭(自动刷新)

        //1.构建一个带缓冲功能的字符输出流 - 覆盖之前的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path))) {

        //2.构建一个带缓冲功能的字符输出流 - 支持追加写入的
//        try(PrintWriter out=new PrintWriter(new FileWriter(path,true))){
//            out.print(content);
//            System.out.println("写入成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //1.不加最后的finally块的时候,写不进去
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        finally {
////            if(null!=out){
////                out.close();
////            }
////        }

//        2.PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        //加了finally就相当于自动刷新缓存
        //执行close方法是会最后还会再来一次刷新缓存,第二个true是没有必要加的
//        PrintWriter out=null;
//        try {
//            out=new PrintWriter(new FileWriter(path));
//
//            out.print(content);
//
//            //手动刷新缓存
//            //out.flush();//没有finally块也能写入
//
//            System.out.println("写出成功");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            if(null!=out){
//                out.close();
//            }
//        }

        //true ->追加写入
        //true ->自动刷新缓存
        //没有使用语法糖的时候,有的windows是写不进去的
        PrintWriter out3=null;
        try {
            out=new PrintWriter(new FileWriter(path),true);

            out.print(content);

            //手动刷新缓存
            //out.flush();//没有finally块也能写入

            System.out.println("写出成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
