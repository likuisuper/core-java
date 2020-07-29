package tech.aistar.day08.relation.homework03;

import java.util.Date;

/**
 * 本类功能:
 *
 * SalesEmployee的子类，有固定底薪的销售人员，
 * 工资由底薪加上销售提成部分。属性：底薪。
 *
 * @author cxylk
 * @date 2020/7/29 17:55
 */
public class BasedPlusSalesEmployee extends SalesEmployee{
    private double baseSalary;

    public BasedPlusSalesEmployee() {
    }

    public BasedPlusSalesEmployee(String name, Date birthday, double sales, double rank, double baseSalary) {
        super(name, birthday, sales, rank);
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month)+baseSalary;
    }
}
