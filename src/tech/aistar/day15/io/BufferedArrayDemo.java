package tech.aistar.day15.io;

import java.io.*;

/**
 * 本类功能:使用缓冲流+自定义数组 - 最终使用字节流来操作文件时最终推荐的版本
 *
 * @author cxylk
 * @date 2020/8/12 18:39
 */
public class BufferedArrayDemo {
    public static void main(String[] args) {
        copy("src/tech/aistar/day15/FileDemo.java","src/tech/aistar/day15/FileDemo_副本4.txt");
    }

    public static void copy(String src,String target){
        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))) {

            int len=-1;

            //自定义缓冲区数组
            byte[] buf=new byte[8*1024];//面向内存的 - 会把底层的数组中的数据读取到buf中

            while(true){
                //和不使用这个缓冲流的区别
                //底层的默认初始化的这个缓冲数组8*1024 作用：面向磁盘的

                //初始化BufferedInputStream对象的时候同时初始化了这个数组,然后
                //会把一定数量的数据加载到这个数组中

                //然后执行read方法的时候,实际上是从底层的这个缓冲数组中读取内容的

                //一旦底层的缓存数组中的数据被读取完毕之后，自动再接着将磁盘中下面的数据
                //读取到底层的字节数组中

                //in.read()这个版本性能也挺高，不过它是一个一个字节的读
                len=in.read(buf);//一下子把8kb的数据读取到buf中，再读出去

                if(len==-1)
                    break;

                out.write(buf,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void copy2(String src,String target){
//        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
//        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))) {
//
//            int len=-1;
//            byte[] buf=new byte[8*1024];
//            while(true){
//                len=in.read(buf);
//                if(len==-1)
//                    break;
//                out.write(buf,0,len);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void copy3(String src,String target){
//        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
//        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))) {
//
//            int len=-1;
//            byte[] buf=new byte[8*1024];
//            while(true){
//                len=in.read(buf);
//                if(len==-1)
//                    break;
//                out.write(buf,0,len);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
