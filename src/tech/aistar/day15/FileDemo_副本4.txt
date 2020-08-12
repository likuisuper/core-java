package tech.aistar.day15;

import java.io.File;
import java.io.IOException;

/**
 * 本类功能:java.io.file
 *
 * @author cxylk
 * @date 2020/8/11 15:09
 */
public class FileDemo {
    public static void main(String[] args) {
        //第一个参数是它父目录,第二个参数是它本身
//        File file=new File("src/tech/aistar","day15");
//        System.out.println(file);//src\tech\aistar\day15

        //test01("src/tech/aistar/day15/FileDemo.java");
        //test("D:\\Python");
        //test02("D:\\Java程序设计\\file.txt");//d盘中创建文件

        //test03("D:\\ClassNote\\aa\\bb");
        //test03("D:\\Java程序设计\\JDBCDemo\\cc\\bb");

        //test04("D:\\Java程序设计\\JDBCDemo\\cc\\bb\\dd.txt");

        //test05("D:\\Java程序设计\\JDBCDemo\\cc\\bb");

        //只能获取第一层的子集方法
        //test06("src/tech/aistar/design");

        //test07("src/tech/aistar/design/factory");

        test08("D:\\GoogleDownload");
    }

    public static void test01(String path){
        //1.利用一个路径来构建一个file实例
        File file=new File(path);

        //判断file是否存在
        if(!file.exists()){
            System.out.println("sorry，文件不存在");
            return;
        }

        //获取文件的绝对路径
        System.out.println(file.getAbsoluteFile());//D:\AISTAR\corejava_j08_student\src\tech\aistar\day15\FileDemo.java

        System.out.println(file.getAbsolutePath());//D:\AISTAR\corejava_j08_student\src\tech\aistar\day15\FileDemo.java

        //2.获取file的名称 - 如果是一个文件，文件的名称是包含后缀的
        System.out.println(file.getName());//FileDemo.java

        System.out.println(file);//src\tech\aistar\day15\FileDemo.java

        System.out.println(file.getPath());//src\tech\aistar\day15\FileDemo.java

        //获取父目录
        System.out.println(file.getParent());//src\tech\aistar\day15
    }

    /**
     * 文件的创建
     * @param path
     */
    public static void test02(String path){
        //1.构建一个file实例
        File file=new File(path);

        //2.判断一下文件是否存在
        if(file.exists()){
            System.out.println("sorry,文件已经存在了");
            return;
        }

        //3.调用创建文件的方法
        try {
            if(file.createNewFile()){//如果成功创建,则返回true
                System.out.println(file+",创建成功");
            }else{
                System.out.println("sorry,文件创建失败！可能没有权限");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test03(String path){
        File file=new File(path);

        if(file.exists()){
            System.out.println("sorry,目录已经存在了");
            return;
        }

        //只能判断存在的，未存在的不能判断
//        if(!file.isDirectory()){
//            System.out.println("sorry,不是有效的目录");
//            return;
//        }

        if(file.mkdir()){
            //创建单层次的目录,一次只能创建一个
            System.out.println(file+",创建成功");
        }else{
            System.out.println("sorry,创建失败了");
        }
    }

    /**
     * 创建深层次的目录
     * @param path
     */
    public static void test04(String path){
        File file=new File(path);

        //System.out.println(file.length());//获取文件大小

        if(file.exists()){
            System.out.println("sorry,目录已经存在了");
            return;
        }

//        if(file.isFile()){
//            System.out.println("sorry,不是一个有效的目录");
//            return;
//        }

        if(file.mkdirs()){//创建深层次的目录
            System.out.println(file+",创建成功");
        }else{
            System.out.println("sorry,创建失败了");
        }
    }

    /**
     * 删除空目录或者文件
     * @param path
     */
    public static void test05(String path){
        File file=new File(path);

        if(!file.exists()){
            System.out.println("sorry,目录不存在");
            return;
        }
        //如果file是文件,直接删除
        //如果file是空目录,直接删除
        //如果file是非空目录,删除失败
        if(file.delete()){
            System.out.println(file+"删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    public static void test06(String path){
        File file=new File(path);

        //只能获取第一层的子集方法
        File[] files=file.listFiles();

        if(null!=files&&files.length>0){
            for (File f : files) {
                //如果是目录,直接输出目录的绝对路径
                if(f.isDirectory()){
                    System.out.println(f.getAbsolutePath());
                }else if(f.isFile()){
                    //如果是文件,直接输出文件的名称
                    System.out.println(f.getName());
                }
            }

        }

    }

    /**
     * 获取某个目录下所有的file
     * @param path
     */
    public static void test07(String path){
        File file=new File(path);

        //只能获取第一层的子集方法
        File[] files=file.listFiles();

        if(null!=files&&files.length>0){//递归出口
            for (File f : files) {
                //如果是目录，直接输出
                if(f.isDirectory()){
                    System.out.println(f.getAbsolutePath());

                    //递归调用自己
                    test07(f.getAbsolutePath());
                }else if(f.isFile()){
                    //如果是文件，直接输出文件的名称
                    System.out.println(f.getName());
                }
            }

        }
    }

    public static void test08(String path){
        File file=new File(path);

        File[] files=file.listFiles(new MyFilenameFilter(".gif"));

        if(null!=files&&files.length>0){//递归出口
            for (File f : files) {
                if(f.isDirectory()){
                    test08(f.getAbsolutePath());
                }else if(f.isFile()){
                    System.out.println(f.getName());
                }
            }
        }
    }
}
