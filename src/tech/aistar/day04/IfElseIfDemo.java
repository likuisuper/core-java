package tech.aistar.day04;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/20 15:29
 */
public class IfElseIfDemo {
    public static void main(String[] args) {
        int maxDays=getMaxDay(2021,2);
        System.out.println(maxDays);
        System.out.println(isLeapYear(2020));
    }

    /**
     * 前提2月份 - 判断是否为闰年
     *
     * 闰年 - 能够被4整除，但是不能被100整除
     *        或者能够直接被400整除
     *
     * @param year 年份
     * @param month 月份
     * @return 该年该月最大的天数
     */
    public static int getMaxDay(int year,int month){
        int day=-1;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            day=31;
        else if(month==2){
            //三目运算符
            return day=isLeapYear(year)?29:28;
        }
        else
            day=30;

        return day;
    }

    /**
     * 前提2月份 - 判断是否为闰年
     *
     * 闰年 - 能够被4整除，但是不能被100整除
     *        或者能够直接被400整除
     * @param year 年份
     * @return 是否是闰年
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 !=0) || year % 400 == 0;
    }
}
