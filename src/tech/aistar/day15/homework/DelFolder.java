package tech.aistar.day15.homework;

import java.io.File;

/**
 * 本类功能:递归删除一个非空目录
 *
 * @author cxylk
 * @date 2020/8/11 19:26
 */
public class DelFolder {
    public static void main(String[] args) {
        delFolder("C:\\Program Files (x86)\\aaa");
    }

    public static void delFolder(String path){
        File file=new File(path);
        if(file.isDirectory()){
            File[] files=file.listFiles();
            for (File f : files) {
                delFolder(f.getAbsolutePath());
            }
        }
        //不管是不是文件夹都会被删除,当递归完,文件夹都为空
        if(file.delete()){
            System.out.println("删除成功");
        }else
            System.out.println("删除失败");

    }
}
