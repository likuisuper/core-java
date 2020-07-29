package tech.aistar.day08.relation.homework03;

import java.util.Date;

/**
 * 本类功能:
 * Employee的子类，按小时拿工资的员工，
 * 属性：每小时的工资、每月工作的小时数
 * 每月工作超出160小时的部分按照1.5倍工资发放。
 *
 * @author cxylk
 * @date 2020/7/29 13:34
 */
public class HourlyEmployee extends Emp{
    private double hours;//工作时长

    private double salaryOfOneHour;//每个小时的工资

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, Date birthday, double hours,double salaryOfOneHour) {
        super(name, birthday);
        this.hours = hours;
        this.salaryOfOneHour=salaryOfOneHour;
    }

    @Override
    public double getSalary(int month) {
        //定义一个变量，用来保存总的薪酬
        double total=hours*salaryOfOneHour;
        if(hours>160){
            total+=(hours-160)*salaryOfOneHour*0.5;
        }
        return total+super.getSalary(month);
    }
}
