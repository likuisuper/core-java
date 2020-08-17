package tech.aistar.day15.homework;

import tech.aistar.day15.FileDemo;

import java.io.*;

/**
 * 本类功能:目录的拷贝
 *
 * @author cxylk
 * @date 2020/8/16 16:47
 */
public class FolderCopyDemo {
    public static void main(String[] args) {
        copyAllFolder("D:\\Java程序设计","F:\\");
    }

    public static void copyAllFolder(String src,String target) {
        //构建原文件的路径
        File file=new File(src);

        if(file.isFile()){
            //如果是文件，直接调用拷贝的方法
            copyFile(src,target);
        }else if(file.isDirectory()){
            //构建目标的file - 文件夹的拷贝 - 文件夹的创建
            File fileb=new File(target);
            if(!fileb.exists()){
                fileb.mkdirs();
            }
            String[] names=file.list();//获取File下面的所有的第一级的子目录的名称
            //递归调用
            for (String name : names) {
                copyAllFolder(src+"/"+name,target+"/"+name);
            }
        }
    }

    /**
     * 文件的拷贝
     * @param src
     * @param target
     */
    public static void copyFile(String src,String target){
        try(BufferedInputStream in=new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(target))) {

            int len=-1;

            //自定义缓冲区数组
            byte[] buf=new byte[8*1024];

            while(true){
                len=in.read(buf);
                if(len==-1){
                    break;
                }
                out.write(buf,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
