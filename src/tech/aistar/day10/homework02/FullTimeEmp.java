package tech.aistar.day10.homework02;

/**
 * 本类功能:
 *
 * 每月基本工资是 3000元,提成方式如下:
 * 基本提成率是 10% (以基本工资为基础)
 * 	 如果当月超额完成任务的 30%,则按1.5倍 下发提成.
 * 	 如果当月超额完成任务的50%,则按2倍下发提成.
 * 	 如果当月超额完成任务的80%,则按3倍下发提成.
 *
 * @author cxylk
 * @date 2020/8/4 23:04
 */
public class FullTimeEmp extends Emp{
    private final double SALARY=3000.d;//基本薪资

    private double work;//任务量为1的话,就相当于100%完成

    private double rank=0.1d;//提成率

    public FullTimeEmp() {
    }

    public FullTimeEmp(double work) {
        this.work = work;
    }

    @Override
    public double calcSalary() {
        double total=0.0d;
        if(work>=1.8){//因为是超额，所以工作量是1+0.8
            total=SALARY+SALARY*rank*3;
        }else if(work>=1.5){
            total=SALARY+SALARY*rank*2;
        }else if(work>=1.3){
            total=SALARY+SALARY*rank*1.5;
        }else{
            total=SALARY+SALARY*rank;
        }
        return total;
    }
}
