package tech.aistar.day07.homework02;

import java.util.Arrays;

/**
 * 本类功能:业务类
 *
 * @author cxylk
 * @date 2020/7/28 19:23
 */
public class EmployeeBiz {
    /**
     * 添加下属
     * @param emp
     */
    public void addEmp(Employee emp) {
        //判断是否为上司来调用这个方法(就是判断传进来的数组长度)
        if(null==emp.getEmps()){
            System.out.println("你是下属,没有权限添加下属");
            return;
        }
        //上司的对象给定的下属的数组的起始默认长度是0
        //对数组进行扩容操作，每次新增一个扩容1个
        //emp.getEmps()=Arrays.copyOf(emp.getEmps(),emp.getEmps().length+1);


        //把新增的员工emp放入到emps中
        //emp.setEmps();
    }

    /**
     *输出下属信息
     */
    public void findEmp(Employee emp){
        if(null == emp.getEmps()){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        if(emp.getEmps().length == 0){
            System.out.println("抱歉,您暂时还未拥有下属!请先添加!");
            return;
        }
        for (Employee emp1 : emp.getEmps()) {
            System.out.println("\t"+emp1);
        }
    }

    /**
     * 输出下属的个数
     */
    public void findEmpCount(Employee emp){
        if(null==emp.getEmps()){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        System.out.println("\t下属个数是:"+emp.getEmps().length);
    }

    /**
     * 上司开除下属...
     * 开除的是比上司工资还高的员工
     * @param
     */
/*    public void delBySalary(Employee emp){
        if(null==emp.getEmps()){
            System.out.println("sorry,您是下属!没有下属了");
            return;
        }
        if(emp.getEmps().length==0){
            System.out.println("抱歉,您暂时还未拥有下属!不能开除了!");
            return;
        }
        //统计开除的人数
        int count=0;

        for(Employee e:emp.getEmps()){
            if(e.getSalary()>emp.getSalary()){
                count++;
            }
        }
        if(count==0){
            System.out.println("抱歉!所有下属工资都很低!");
        }

        //确定新的数组的长度 - 保留留下来的员工
        Employee[] temps= new Employee[emp.getEmps().length-count];

        //定义一个下标计数器
        int pos=0;

        //遍历原来的数组
        for(Employee e:emp.getEmps()){
            if(e.getSalary()<emp.getSalary()){
                temps[pos++]=e;
            }
        }

        emp.getEmps()=temps;
    }*/
}
