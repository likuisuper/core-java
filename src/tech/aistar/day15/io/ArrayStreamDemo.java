package tech.aistar.day15.io;

import java.io.*;

/**
 * 本类功能:文件的拷贝 - 流的读写操作 - 利用自定义的数组作为缓冲区
 * 用来减少IO交互{java和磁盘的交互}，用来提高读写性能
 *
 * @author cxylk
 * @date 2020/8/12 10:40
 */
public class ArrayStreamDemo {
    public static void main(String[] args) {
        copy("src/tech/aistar/day15/FileDemo.java","src/tech/aistar/day15/FileDemo_副本2.txt");
    }

    /**
     * 语法糖写法
     * try(可以申请多个资源对象){
     *     //由JVM自动关闭资源
     * }
     * @param src
     * @param target
     */
    public static void copy(String src,String target){
        try(InputStream in=new FileInputStream(src);
            OutputStream out=new FileOutputStream(target)){

            //自定义一个缓冲区数组

            //在没有使用byte[] 数组之前,我们第一个版本是读一个字节,写一个字节,
            //产生的IO交互比较频繁 - 性能会降低
            byte[] buf=new byte[3*1024];//一次性可以读取3Kb

            int len=-1;

            while(true){
                len=in.read(buf);//一次性从输入流中读取一定的字节放入到缓冲数组中

                if(len==-1)
                    break;
                out.write(buf,0,len);
            }

            System.out.println("文件拷贝成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
