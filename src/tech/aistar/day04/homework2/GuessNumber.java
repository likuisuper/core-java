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
        guessNumber();
    }
    public static void guessNumber(){
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
    }
}
