package tech.aistar.day08.relation.homework03;

import java.util.Date;

/**
 * 本类功能:
 * Employee的子类，销售人员，工资由月销售额和提成率决定。
 * 属性：月销售额、提成率
 *
 * @author cxylk
 * @date 2020/7/29 13:43
 */
public class SalesEmployee extends Emp{
    private double sales;//销售额

    private double rank;//提成率

    public SalesEmployee() {
    }

    public SalesEmployee(String name, Date birthday, double sales, double rank) {
        super(name, birthday);
        this.sales = sales;
        this.rank = rank;
    }

    @Override
    public double getSalary(int month) {
        return super.getSalary(month)+sales*rank;
    }
}
