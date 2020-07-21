package tech.aistar.day04;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/21 21:21
 */
public class SwitchDemo {
    public static void main(String[] args) {
        int n = 1;

        switch (n){//byte short int char enum String
            //Byte Short Integer Character
            case 1:
                System.out.println("=====凤姐====");
                break;//跳出switch块...
            case 2:
                System.out.println("======芙蓉======");
                //省略了break语句
                //没有发现break语句,那么会自动进入到下一个case中执行
            case 3:
                System.out.println("======苍老师======");
                break;
            //default语句是可以不写的
            default://匹配不到任何一个case
                System.out.println("====同性恋====");
                break;
        }
    }
}
