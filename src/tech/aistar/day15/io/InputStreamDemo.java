package tech.aistar.day15.io;

import org.dom4j.io.OutputFormat;

import java.io.*;

/**
 * 本类功能:第一个Demo - 性能最低 - 单个字节单个字节进行读取和写入的
 *
 * @author cxylk
 * @date 2020/8/12 9:48
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        copy("src/tech/aistar/day15/FileDemo.java","src/tech/aistar/day15/FileDemo_副本.txt");
    }

    public static void copy(String src,String target){
        //1.确定流对象

        InputStream in=null;//输入流
        OutputStream out=null;//输出流

        //2.确定文件输入流 - 确定源头
        try {
            in=new FileInputStream(src);

            out=new FileOutputStream(target);

            //3.单个字节单个字节进行读取
            //定义一个变量 - 用来保存每次读取到的内容
            int len=-1;

            //循环读取
            while(true){
                //如果已经到达流的尾部,in read()返回-1
                len=in.read();

                //循环退出的条件
                if(len==-1){
                    break;
                }

                //会自动读取文件中的换行,所以不用println
                //将len转换为char输出，并且输出的文件中汉字是乱码的(utf-8中汉字占3个字节)
                //System.out.print((char)len);//读取文件内容

                //写入的文件不再乱码
                out.write(len);//拷贝文件
            }
            System.out.println("文件拷贝成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

    public static void copy2(String src,String target){
        try(InputStream in=new FileInputStream(src);
        OutputStream out=new FileOutputStream(target)) {
            int len=-1;
            while (true){
                len=in.read();
                if(len==-1){
                    break;
                }
                out.write(len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
