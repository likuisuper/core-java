package tech.aistar.day04.homework;

/**
 * 本类功能:输出每个数的阶乘，并输出阶乘之和
 *
 * @author cxylk
 * @date 2020/7/20 19:00
 */
public class FactorialDemo {
    public static void main(String[] args) {

/*        FactorialDemo f=new FactorialDemo();
        int sum=0;
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+"!="+f.factorial(i));
            sum+=f.factorial(i);
        }
        System.out.println("最终结果:"+sum);

 */
        //test(8);
        test02(8);
    }

    /*
     * 递归写法
     * @param n
     * @return

    public int factorial(int n){
        if(n==1)
            return 1;
        return n*factorial(n-1);
    }
     */

    /**
     *  编程从变量开始...
     * 	1!=1
     * 	2!=2
     * 	3!=6
     * 	4!=24
     * 	5!=120
     * 	6!=720
     * 	7!=5040
     * 	8!=40320
     * 	9!=362880
     * 	10!=3628800
     *
     * 	输出最终结果：
     * 	1!+2!+3!+4!+5!+6!+7!+8!+9!+10!=4037913
     * 	*
     * @param n 输出的行数
     */
    public static void test(int n){
        //定义一个字符串，用来拼接结果
        String str="";

        //定义一个变量，用来保存总的阶乘的值
        Long total=0L;

        //定义一个变量用来保存每个数值的阶乘的值
        long sum=1L;

        for (int i = 1; i <= n; i++) {
            sum*=i;
            System.out.println(i+"!="+sum);

            //计算总的阶乘
            total+=sum;

            //拼接表达式
            str+=(i!=n)?(i+"!+"):(i+"!");
        }
        System.out.println(str+"="+total);
    }

    /**
     * 神奇的数字[AmazingNumber]如下
     * 	 * 1*8+1= 9
     * 	 * 12*8+2= 98
     * 	 * 123*8+3= 987
     * 	 * 1234*8+4= 9876
     * 	 * 12345*8+5= 98765
     * 	 * 123456*8+6= 987654
     * 	 * 1234567*8+7= 9876543
     * 	 * 12345678*8+8= 98765432
     * 	 * 123456789*8+9= 987654321
     * 	 *
     * @param n 代表的是行数
     */
    public static void test02(int n){
        //1.参数有效性判断
        if(n<=0||n>9){
            System.out.println("参数不合法!");
            return;
        }
        //定义一个变量，保存第一个数值 * 左边的数值
        long sum=0L;
        for (int i = 1; i <=n ; i++) {
            sum=sum*10+i;
            System.out.println(sum+"*"+8+"+"+i+"="+(sum*8+i));
        }
    }

}
