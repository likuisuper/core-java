package tech.aistar.day08.relation.homework03;

import java.util.Date;

/**
 * 本类功能:Employee的子类，拿固定工资的员工。属性：月薪
 *
 * @author cxylk
 * @date 2020/7/29 13:31
 */
public class SalariedEmployee extends Emp{
    private double baseSalary;//固定工资

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, Date birthday, double baseSalary) {
        super(name, birthday);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month)+baseSalary;
    }
}
