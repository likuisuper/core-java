package tech.aistar.day07.homework02;

import tech.aistar.day07.homework02.Employee;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/27 21:08
 */
public class TestEmployee {
    public static void main(String[] args) {
        //定义一个boss - 上司对象
        Employee boss=new Employee(1,"lk",2500.0d,new Employee[0]);



        //定义若干个下属对象
        Employee employee1=new Employee(2,"tom",2560.0d,null);

        Employee employee2=new Employee(3,"james",1200.0d,null);

        Employee employee3=new Employee(4,"jack",2560.0d,null);

        EmployeeBiz employeeBiz=new EmployeeBiz();

        employeeBiz.addEmp(employee1);
        employeeBiz.addEmp(employee2);
        employeeBiz.addEmp(employee3);

        employeeBiz.findEmp(boss);

    }
}
