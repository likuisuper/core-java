package tech.aistar.day08.relation.homework02;


/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 13:00
 */
public class TestEmployee {
    public static void main(String[] args) {
        //创建一个上司对象
        Employee boss=new Employee(1,"cxylk",2500.0d,new Employee[0]);

        //创建两个下属
        Employee e1=new Employee(2,"admin",1000.0d,null);
        Employee e2=new Employee(3,"tom",1200.0d,null);

        //创建一个业务类对象
        EmployeeBiz biz=new EmployeeBiz();
        //添加下属
        biz.addEmp(boss,e1);
        biz.addEmp(boss,e2);

        //输出下属的信息
        biz.getEmpAll(boss);
    }
}
