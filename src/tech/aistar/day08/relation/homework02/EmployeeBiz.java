package tech.aistar.day08.relation.homework02;

import java.util.Arrays;

/**
 * 本类功能:业务类 - 着重操作实体类中的数据
 *
 * @author cxylk
 * @date 2020/7/29 13:00
 */
public class EmployeeBiz {
    /**
     * 添加一个员工
     * @param boss
     * @param e
     */
    public void addEmp(Employee boss,Employee e){
        //判断一下是否拥有权限来添加下属
        if(null==boss.getEmps()){
            System.out.println("sorry,你没有权限添加下属");
            return;
        }

        //对数组进行扩容
        Employee[] emps=boss.getEmps();
        emps= Arrays.copyOf(emps,emps.length+1);

        //把下属放入到扩容之后的数组中
        emps[emps.length-1]=e;

        //重新绑定下属数组到boss对象
        boss.setEmps(emps);
    }

    /**
     * 获取上司的所有的下属信息
     * @param boss
     */
    public void getEmpAll(Employee boss){
        if(null==boss.getEmps()){
            System.out.println("您是下属");
            return;
        }
        if(boss.getEmps().length==0){
            System.out.println("sorry,您还没有下属");
            return;
        }
        for(Employee emp:boss.getEmps()){
            System.out.println("\t"+emp);
        }
    }
}
