package tech.aistar.day06;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本类功能:日期格式化处理类
 *
 * @author cxylk
 * @date 2020/7/24 19:05
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        //E代表输入的是周几
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        //System.out.println(sdf);

        //异常- 程序在运行的过程中发生了不正确的情况
        //注意传入的模板的正确性，否则会抛出一个异常java.lang.IllegalArgumentException
        //如果此行发生了异常，那么异常行下面的代码将不会执行了
        //SimpleDateFormat sdf=new SimpleDateFormat("cxylk");

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

        //2.获取当前系统的日期
        Date now=new Date();

        //日期格式化成指定模板形式的字符串

        //String format(Date date);//由SimpleDateFormat的"父类"DateFormat提供的

        String sdate=sdf.format(now);

        System.out.println(sdate);

        System.out.println("==========华丽丽的分割线=========");

        //把日期形式的字符串 -> 日期类型
        //注意：字符串中的日期的格式要和SimpleDateFormat(String pattern)中的pattern高度保持一致
        //否则会抛出java.text.ParseException - 解析失败异常
        String str="2020-09-08";
        SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");

        //把字符串解析成日期类型
        //parse方法的时候，需要手动强制抓取异常
        //alt+enter - 生成try..catch
        try {
            //如果此行抛出了java.text.parseExceptin,那么程序就进入到
            //catch块中国去执行里面代码，并且try{}中的此行下面的代码不会执行
            Date date = format.parse(str);
            System.out.println(date);
        } catch (ParseException e) {
            //e.printStackTrace();//打印异常的堆栈信息
            //日志的记录
            //e.printStackTrace();
            //换成下面这行
            System.out.println("啦啦啦啦啦");
        }
        System.out.println("=====end=====");
    }
}
