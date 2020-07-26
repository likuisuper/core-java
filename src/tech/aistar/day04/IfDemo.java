package tech.aistar.day04;

/**
 * 本类功能:if语句
 *
 * @author cxylk
 * @date 2020/7/20 16:11
 */
public class IfDemo {
    public static void main(String[] args) {
        boolean flag = false;
        if(flag) {
            //只有一行代码的时候,{}才可以被省略不写...
            System.out.println("flag...");
        }

        int age = 18;
        if(age>=18)
            //条件成立,执行
            System.out.println("成年");
        else
            //条件不成立,执行
            System.out.println("未成年");
        System.out.println("===华丽丽的分割线===");

        int score = 98;
        if(score>=90){
            System.out.println("优秀!");
        }else if(score>=80){
            System.out.println("良好!");
        }else{
            System.out.println("差!");
        }
    }
}
