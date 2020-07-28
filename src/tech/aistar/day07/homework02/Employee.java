package tech.aistar.day07.homework02;

import java.util.Arrays;

/**
 * 本类功能:
 * 完成员工类 Employee,需要包含员工的基本属性
 * (编号,姓名,工资)和上司以及下属,提供如下方法:
 * 属性的存/取方法
 * 业务方法包含:
 * 添加下属的方法
 * 输出自己所属下属的方法
 * 获取自己下属的人数个数.
 *
 * @author cxylk
 * @date 2020/7/27 18:57
 */
public class Employee {
    //编号
    private int id;

    //姓名
    private String name;

    //工资
    private double salary;


    //一个上司对应多个下属
    private Employee[] emps;

    public Employee() {
    }

    public Employee(int id, String name, double salary, Employee[] emps) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.emps = emps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee[] getEmps() {
        return emps;
    }

    public void setEmps(Employee[] emps) {
        this.emps = emps;
    }






    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
