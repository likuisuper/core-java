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
        delAllFolder("C:\\Program Files (x86)\\aaa");
    }

    public static void delAllFolder(String path){
//        File file=new File(path);
//        if(file.isDirectory()){
//            File[] files=file.listFiles();
//            for (File f : files) {
//                delFolder(f.getAbsolutePath());
//            }
//        }
//        //不管是不是文件夹都会被删除,当递归完,文件夹都为空
//        if(file.delete()){
//            System.out.println("删除成功");
//        }else
//            System.out.println("删除失败");


        //1.构建File实例
        File file=new File(path);
        //2.判断是否存在
        if(!file.exists()){
            System.out.println("sorry,目录不存在");
        }
        File[] files=file.listFiles();

        if(null!=files&&files.length>0){
            for (File f : files) {
                if(f.isDirectory()){
                    //递归调用自己

                    delAllFolder(f.getAbsolutePath());
                    f.delete();
                }else if(f.isFile()){
                    f.delete();
                }
                f.delete();
            }
        }
        file.delete();
    }
}
