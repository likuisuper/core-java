package tech.aistar.day04.homework2;

/**
 * 本类功能:进制转换
 *
 * 要求：给定一个十进制的数(正整数)，输出这个十进制数的最精简的二进制数
 *
 * 比如10 -> 1010
 *
 * @author cxylk
 * @date 2020/7/21 17:34
 */
public class BaseConversion {
    public static void main(String[] args) {
        //java.lang.Integer - [int类型对应包装类型]
        //static String toBinaryString(int n);//jdk内置的十进制转二进制
        //String binary = Integer.toBinaryString(10);
        // System.out.println(binary);

//        String binary = toBinary(10);
//        System.out.println(binary);

        //test(10);

        System.out.println(toBinaryString(14));
    }
    public static void test(int n){
        if(n<0)
            System.out.println("请输入正整数");
        StringBuilder sb= new StringBuilder();
        int sum;
        for(int i=n;i>=1;i/=2){
            if(i%2==0)
                sum=0;
            else
                sum=1;
            sb.insert(0, sum);
        }
        System.out.println(sb);
    }

    /**
     * 十进制 -> 二进制
     * @param n
     * @return
     */
    public static int toBinaryString(int n){


        //思路 - 0 1 0 1

        // 0*10的0次方 = 0
        //1*10的1次方 = 10
        //0*10的2次方 = 0
        //1*10的3次方 = 1000

        //相加 = 1 0 1 0

        //定义一个指数的计数器
        int pos = 0;

        int binary = 0;//存储最终计算的二进制的数值

        while(true){
            //1. 得到商
            int s = n / 2;
            //2. 得到余数
            int y = n % 2;

            //TODO.. 待完成的功能....
            binary+= y*Math.pow(10,pos++);

            //3. 循环退出
            if(s == 0)
                break;

            n = s;
        }


        return binary;
    }
}
