package tech.aistar.day11.homework;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/4 19:11
 */
public class SubString {
    //数据的初始化 - 构造方法或者静态代码块
    //private StringBuilder builder = new StringBuilder();

    //    public StringYouErYuan(){
//        builder.append("This is a log file,it was store at")
//                .append("\"d:\\Program File\\temp\" ")
//                .append("directory.the format of log file was:\n")
//                .append("20130509:Jack:M:1990-08-08");
//    }

    //通过静态代码块进行初始化
    private static StringBuilder builder = new StringBuilder();

    static{
        builder.append("This is a log file,it was store at")
                .append("\"d:\\Program File\\temp\" ")
                .append("directory.the format of log file was:\n")
                .append("20130509:Jack:M:1990-08-08");
    }

    /**
     * 1.截取此内容中的路径子字符串
     *   打印出的结果为(找出包裹路径的双引号的下标,substring)
     *   d:\Program File\temp
     * @return
     */
    public static String test01(){
        return builder.substring(builder.indexOf("\"")+1,
                builder.lastIndexOf("\""));
    }

    /**
     * 2.把第一个引号之前的部分中的所有空格替换为#
     *   把第二个引号之后的部分中的所有空格替换为*
     * @return
     */
    public static String test02(){
        //链式编程 - 可读性极差
        return new StringBuilder()
                .append(builder.substring(0,builder.indexOf("\""))
                        .replace(" ","#"))
                .append(builder.substring(builder.indexOf("\""),
                        builder.lastIndexOf("\"")))
                .append(builder.substring(builder.lastIndexOf("\""))
                        .replace(" ","*")).toString();
    }

    public static void main(String[] args) {

        System.out.println(test01());

        System.out.println(test02());

        //3.把\n后面的字符串取出打印
        System.out.println(builder.indexOf("\n"));
        System.out.println(builder.substring(94));

        //4.以:作为切割符,把\n后面截取出来的字符串分段打印
        //  20130509
        //  Jack
        //  M
        //  1990-08-08
        String str2=builder.substring(94);
        String[] strs=str2.split(":",94);
        for(String x:strs)
            System.out.println(x);


    }
}
