package tech.aistar.day06;

import tech.aistar.util.DateUtil;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 本类功能:制作一个简易日历
 *
 * @author cxylk
 * @date 2020/7/24 17:57
 */
public class CalendarPrintDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份:>");
        int year=sc.nextInt();
        System.out.println("请输入月份:>");
        int month=sc.nextInt();

        printCalendar(year,month);
    }

    private static void printCalendar(int year, int month) {
        if(year<=0||month<1||month>12){
            System.out.println("参数不合法");
            return;
        }

        //1.获取某年某月最大天数
        int maxDays= DateUtil.maxDay(year,month);

        //2.获取今天是几号
        int date= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        //3.获取某年某月1号是周几
        int dayOfWeek=DateUtil.getDayOfWeek(year,month,1);
        //System.out.println(dayOfWeek);

        System.out.println("\t\t"+year+"年"+month+"月");
        System.out.println("一\t二\t三\t四\t五\t六\t日");

        //定义一个计数器用来换行
        int count=0;

        //打印周几之前的空格
        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("\t");
            count++;
        }

        for (int i = 1; i <=maxDays ; i++) {
            //输出号数，如果等于今天，就在后面加*号
            System.out.print(i==date?(i+"*\t"):(i+"\t"));
            count++;
            if(count==7){
                System.out.println();//打印完一行之后换行
                count=0;//让count重新计数
            }
        }
    }
}
