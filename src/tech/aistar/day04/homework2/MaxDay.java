package tech.aistar.day04.homework2;

/**
 * 本类功能:求某年某月的最大天数
 *
 * @author cxylk
 * @date 2020/7/21 18:36
 */
public class MaxDay {
    public static void main(String[] args) {
        maxDay(2020,2);
    }

    public static void maxDay(int year,int month){
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
                System.out.println(isLeapYear(year)?29:28);
        }
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
