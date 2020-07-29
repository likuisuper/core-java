package tech.aistar.day08.relation.homework03;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 17:58
 */
public class TestEmp {
    public static void main(String[] args) {
        Emp e1=new SalariedEmployee("admin",new Date(),3000.0d);
        System.out.println(e1.getSalary(8));

        Emp e2=new HourlyEmployee("大妈",new Date(),170.0d,10.0d);
        System.out.println(e2.getSalary(8));

        Emp e3=new SalesEmployee("小明",new Date(),1000.0d,0.1);
        System.out.println(e3.getSalary(7));

        Emp e4=new BasedPlusSalesEmployee("小红",new Date(),1000.0d,0.1,2500.0d);
        System.out.println(e4.getSalary(7));

        Emp[] emps=new Emp[4];
        emps[0]=e1;
        emps[1]=e2;
        emps[2]=e3;
        emps[3]=e4;

        for(Emp emp:emps){
            System.out.println(emp.getName()+":"+emp.getSalary(7));
        }
    }
}
