package tech.aistar.util;

/**
 * 本类功能:日期工具类
 *
 * @author cxylk
 * @date 2020/7/23 8:25
 */
public class DateUtil {
    public static void main(String[] args) {
        maxDay(2020,2);
    }

    public static int maxDay(int year,int month){
        int days=-1;
        switch (month){
            default:
                System.out.println("天数为"+"31"+"天");
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("天数为"+30+"天");
                break;
            case 2:
                days = isLeapYear(year)?29:28;
        }
        return days;
    }

    /**
     * 闰年:能够被4整除但是不能被100整除，或者能被400整除
     * @param year 年份
     * @return
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}
