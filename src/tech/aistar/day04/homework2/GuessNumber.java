package tech.aistar.day04.homework2;

import java.util.Scanner;

/**
 * 本类功能:猜数字
 *
 * //1 . 产生一个随机的整数[1-100] - 假装不知道  80
 *
 * //游戏的界面
 * //       =====猜数字游戏=====
 * //请你输入数字[1-100]> 50
 * //小了,[50-100]> 90
 * //大了,[50-90]> 80
 * //恭喜你,中奖了.总共猜了3次!
 *
 * @author cxylk
 * @date 2020/7/21 18:59
 */
public class GuessNumber {
    public static void main(String[] args) {
        //在jdk7.0之前，是要求sc必须要关闭的 - 获取键盘输入流[昂贵的资源]
        Scanner sc=new Scanner(System.in);

        //1.产生一个随机数 - java中的随机数都是伪随机数
        int n=(int)(Math.random()*100+1);//[1-100]之间的随机数
        System.out.println("幸运数:"+n);

        //2.定一个变量 - 猜数字的次数
        int count=0;

        //3.定义两个变量，最小边界和最大边界
        int start=1;

        int end=100;

        //定义一个标记位
        boolean flag=true;

        do{
            if(flag){
                System.out.println("====猜数字游戏====");
                //拼接printf

                //%s - 代表的是字符串

                //%d - 代表的是数字

                System.out.printf("请你猜数,范围[%d,%d]>",start,end);

                flag=false;
            }
            int num=sc.nextInt();
            //判断num和幸运数字的比较
            if(num<n){
                start=num;
                System.out.printf("太小了,范围[%d,%d]>",start,end);
                count++;
            }
            else if(num>n){
                end=num;
                System.out.printf("太大了,范围[%d,%d]>",start,end);
                count++;
            }
            else{
                count++;
                System.out.printf("恭喜你猜中了,幸运数字是[%d],总共猜了[%d]次\n",n,count);
                flag=true;
            }

        }while(true);

        //sc.close();
    }
/*    public static void guessNumber(){
        Scanner sc=new Scanner(System.in);
        double random=Math.random();
        int result=(int)(random*100+1);
        //System.out.println(result);
        System.out.println("-----------猜数字游戏-----------");
        System.out.println("请你输入数字[1-100]");

        int max=100;
        int min=0;

        int count=0;
        while(true){
            int num=sc.nextInt();
            if(num>100){
                System.out.println("请输入1-100之间的正整数");
                return;
            }
            count++;
            if(num>result){
                System.out.println("大了"+"["+min+"-"+num+"]");
                max=num;
            }
            else if(num<result){
                System.out.println("小了"+"["+num+"-"+max+"]");
                min=num;
            }
            else{
                System.out.println("恭喜你,猜中了！总共猜了"+count+"次");
                break;
            }
        }
    }*/
}
