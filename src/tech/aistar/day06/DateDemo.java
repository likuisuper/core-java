package tech.aistar.day06;

import java.util.Date;

/**
 * 本类功能:日期
 *
 * @author cxylk
 * @date 2020/7/24 11:01
 */
public class DateDemo {
    public static void main(String[] args) {
        //1.构建一个日期对象
        Date now=new Date();
        System.out.println(now);//Fri Jul 24 11:08:53 GMT+08:00 2020

        //2.根据指定的年月日来构建一个指定的日期对象
        //month的范围在[0-11]
        //Date(int year-1900,int month,int date);
        Date dt =new Date(2021-1900,4,1);//过时的

        System.out.println(dt);

        //3.常用方法
        int year=now.getYear()+1900;//必须要加1900
        System.out.println("year:"+year);

        //获取月份
        int month=now.getMonth()+1;//加1才会显示当前月份
        System.out.println("month:"+month);

        //获取日期
        int date=now.getDate();
        System.out.println("date:"+date);//24

        //获取时分秒
        System.out.println(now.getHours()+":"+now.getMinutes()+":"+now.getSeconds());

        //获取星期几

        //星期日 -> 0    星期一 -> 1
        System.out.println(now.getDay());

        System.out.println("===设置日期中的字段===");

        Date dts=new Date();

        dts.setYear(2022-1900);
        System.out.println(dts);

        System.out.println(dts.getYear()+1900);

        System.out.println(dts.getMonth());

        System.out.println("====毫秒数====");
        //Date->Long
        long time=now.getTime();//距离1970年1月1日的毫秒数
        System.out.println(time);//1595565397141

        //每隔1秒产生1个数
//        for(;;){
//            System.out.println(new Date().getTime());
//            try{
//                Thread.sleep(1000);//延迟1秒
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }

        //Long->Date
        //第一种方式：Date(Long time)
        Date da=new Date(0L);
        System.out.println(da);

        //日期对象是不能够计算的
        //业务：打印三天之后的日期
        long threeDate=new Date().getTime()+3L*24*60*60*1000;
        Date dm=new Date(threeDate);//通过构造方法
        System.out.println(dm);

        //第二种方式 - void setTime();

        Date ds=new Date();
        ds.setTime(threeDate);//通过setTime方法

        System.out.println(ds);

    }
}
