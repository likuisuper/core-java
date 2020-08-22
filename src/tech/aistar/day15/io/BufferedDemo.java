package tech.aistar.day15.io;

import java.io.*;

/**
 * 本类功能:使用缓冲流
 *
 * @author cxylk
 * @date 2020/8/12 18:07
 */
//@SuppressWarnings("all")
public class BufferedDemo {
    public static void main(String[] args) {
        copy("src/tech/aistar/day15/FileDemo.java","src/tech/aistar/day15/FileDemo_副本3.txt");
    }

    /**
     * 拷贝文件
     * 语法糖写法 - 会自动关闭资源，不用再手动关闭
     * @param src
     * @param target
     */
    public static void copy(String src,String target){
        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))){

            int len=-1;
            int count=0;
            while(true){
                //和不使用这个缓冲流的区别:
                //底层默认初始化的这个缓冲数组8*1024 作用：面向磁盘的

                //初始化BufferedInputStream 对象的时候同时初始化了这个数组,然后
                //会把一定数量的数据加载到这个数组中

                //然后执行read方法的时候,实际上是从底层的这个缓冲数组中读取内容的
                //一旦底层的缓存数组中的数据被读取完毕之后,自动再接着讲磁盘下面的数据
                //接着读取到底层的字节数组中
                len=in.read();
                count++;
                if(len==-1)
                    break;
                out.write(len);
            }

            System.out.println("count:"+count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void copy2(String src,String target){
//        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
//        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))){
//            int len=-1;
//            while (true){
//                len=in.read();
//                if(len==-1)
//                    break;
//                out.write(len);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
