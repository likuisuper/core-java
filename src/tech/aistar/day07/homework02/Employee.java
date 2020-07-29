package tech.aistar.day07.homework02;

import java.util.Arrays;

/**
 * 本类用来演示:
 *
 * 编号,姓名,工资
 *
 * @author: cxylk
 * @date: 2020/7/28 8:44 上午
 */
public class Employee {//员工类
    private int id;

    private String name;

    private double salary;

    //一个上司拥有多个下属
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

    /**
     * 添加下属
     * @param e
     */
    public void addEmp(Employee e){
        //判断是否为上司来调用这个方法.
        if(null == emps){
            System.out.println("sorry,您本身是下属!没有权限进行下属的添加操作");
            return;
        }
        //上司的对象给定的下属的数组的起始默认长度是0
        //对数组进行扩容操作,每次新增一个扩容1个
        emps = Arrays.copyOf(emps,emps.length+1);

        //把新增的员工e放入到emps中
        emps[emps.length-1]=e;
    }

    /**
     * 输出下属信息
     */
    public void findEmp(){
        if(null == emps){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        if(emps.length == 0){
            System.out.println("抱歉,您暂时还未拥有下属!请先添加!");
            return;
        }
        for (Employee emp : emps) {
            System.out.println("\t"+emp);
        }
    }

    /**
     * 输出下属的个数
     */
    public void findEmpCount(){
        if(null == emps){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        System.out.println("\t下属个数是:"+emps.length);
    }

    /**
     * 上司开除下属...
     * 开除的是比上司工资还要高的员工!!!
     */
    public void delBySalary(){
        if(null == emps){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        if(emps.length == 0){
            System.out.println("抱歉,您暂时还未拥有下属!不能开除了!");
            return;
        }

        //统计开除的人数
        int count = 0;

        for (Employee e : emps) {//下属的
            if(e.getSalary()>this.salary){
                count++;
            }
        }
        if(count==0){
            System.out.println("抱歉!所有下属工资都很低!");
            return;
        }
        //确定新的数组的长度 - 保留留下来的员工.
        Employee[] temps = new Employee[emps.length - count];
        //定义一个下标计数器
        int pos = 0;

        //遍历原来的数组
        for (Employee e : emps) {
            if(e.getSalary()<this.salary){
                temps[pos++] = e;
            }
        }

        this.emps = temps;
    }
}
