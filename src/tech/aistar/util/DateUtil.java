package tech.aistar.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 本类功能:日期工具类
 *
 * @author cxylk
 * @date 2020/7/23 8:25
 */
public class DateUtil {

    public static int maxDay(int year, int month) {
        int days = -1;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days=30;
                break;
            case 2:
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days=31;
                break;
        }
        return days;
    }

    /**
     * 闰年:能够被4整除但是不能被100整除，或者能被400整除
     *
     * @param year 年份
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    /**
     * 获取某年某月某日是周几
     *
     * @param year  年份
     * @param month 月份
     * @param date  几号
     * @return 周几
     */
    public static int getDayOfWeek(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();

        //对日历对象进行重新设置值
        calendar.set(year, month - 1, date);

        //如果是从星期一到星期日显示，就-2，否则-1
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) -2;
        return dayOfWeek;
    }

    /**
     * 日期格式化成指定模板的字符串表现方式
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        //1.构建SimpleDateFormat对象
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        if (null == date)
            return null;
        String sdate = sdf.format(date);
        return sdate;
    }

    /**
     * 将字符串解析成日期对象
     * @param sdate
     * @param pattern
     * @return
     */
    public static Date parse(String sdate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        if (null == sdate || sdate.trim().length() == 0)
            return null;

        Date date = null;
        try {
            date = sdf.parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
