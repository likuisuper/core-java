package tech.aistar.day11.homework;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/4 19:11
 */
public class SubString {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("This is a log file,it was store at")
                .append("\"d:\\Program File\\temp\" ")
                .append("directory.the format of log file was:\n")
                .append("20130509:Jack:M:1990-08-08");

        //1.打印结果d:\Program File\temp
        System.out.println(builder.indexOf(":"));
        System.out.println(builder.indexOf("\" "));
        System.out.print(builder.substring(36-1,55));

        System.out.println();

        //2.把第一个引号之前的部分中的所有空格替换为#
        //  把第二个引号之后的部分中的所有空格替换为*
        String str=builder.substring(0,36);
        System.out.println(str.replace(" ","#"));

        System.out.println(builder.indexOf(":",37));
        String str1=builder.substring(93,builder.length());
        System.out.println(str1.replace(" ","*"));

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
