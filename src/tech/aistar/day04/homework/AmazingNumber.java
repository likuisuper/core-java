package tech.aistar.day04.homework;

/**
 * 本类功能:打印数字
 *
 * @author cxylk
 * @date 2020/7/20 19:07
 */
public class AmazingNumber {
    public static void main(String[] args) {
        int sum=0;
        for(int i=1,j=1;i<=9;i++){
            sum=sum*10+i;
            System.out.println(sum+"*"+8+"+"+j+"="+(sum*8+i));
            j++;
        }
    }

}
