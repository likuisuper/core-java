package tech.aistar.day07.homework02;

/**
 * 本类用来演示:测试类
 *
 * @author: cxylk
 * @date: 2020/7/28 8:51 上午
 */
public class TestEmployee {
    public static void main(String[] args) {
        //1. 定义一个boss - 上司对象
        //Employee[] emps = new Employee[0];
        Employee boss = new Employee(1,"boss",2500.0d,new Employee[0]);

        //2. 定义若干个下属信息
        Employee e1 = new Employee(2,"tom",2560.0d,null);
        Employee e2 = new Employee(3,"james",1200.0d,null);
        Employee e3 = new Employee(4,"jack",2560.0d,null);

       // e1.addEmp(e2);

        //3. 添加下属
        boss.addEmp(e1);
        boss.addEmp(e2);
        boss.addEmp(e3);

        boss.delBySalary();

        //4. 输出下属的个数
        boss.findEmpCount();

        //5. 输出下属的信息
        System.out.println("下属信息如下:>");
        boss.findEmp();
    }
}
