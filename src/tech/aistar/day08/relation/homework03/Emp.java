package tech.aistar.day08.relation.homework03;

import java.util.Calendar;
import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 13:20
 */
public class Emp {
    private String name;

    //生日
    private Date birthday;

    public Emp() {
    }

    public Emp(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public double getSalary(int month){
        //将Date类型->Calendar类型
        Calendar cal=Calendar.getInstance();
        cal.setTime(birthday);//利用指定的date类型来构建日历类型

        //定义一个变量
        double salary=0.0d;

        if(cal.get(Calendar.MONTH)+1==month)
            salary=100.0d;
        return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
