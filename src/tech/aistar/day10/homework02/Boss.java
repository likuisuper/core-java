package tech.aistar.day10.homework02;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 21:09
 */
public class Boss extends Emp{
    //拿固定薪资,每月为50000元
    private final double BASE_SALARY=50000.0d;

    @Override
    public double calcSalary() {
        return BASE_SALARY;
    }
}
