package tech.aistar.day06;

import java.util.Calendar;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/24 14:37
 */
public abstract class CalendarDemo {
    public static void main(String[] args) {
        //1.构建日历对象
        //设计模式 - 简单工厂设计模式
        Calendar cal=Calendar.getInstance();
        System.out.println(cal);

        //2.获取日历中的指定的字段
        //int year=cal.get(1);//直接传入的是一个字面量

        //Calendar.YEAR=10;

        int year=cal.get(Calendar.YEAR);//通过常量进行赋值 - 提高程序的可读性
        System.out.println("year:"+year);

        int month=cal.get(Calendar.MONTH);
        System.out.println("month:"+month);

        //周日 - week=1
        int week=cal.get(Calendar.DAY_OF_WEEK)-1;//多了一天
        System.out.println(week);//5

        int date=cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("date:"+date);

        //访问Calendar中提供的字段
        int yearField=Calendar.YEAR;
        System.out.println(yearField);

        //对日历字段进行一一赋值
        Calendar dar=Calendar.getInstance();
    }
}
