package tech.aistar.day02;

/**
 * @Author 箜絔lk
 * @Date 2020/7/17 20:17
 */
public class SignDemo {
    public static void main(String[] args) {
        // \n和\r
        // \n = 换行 - 当输入完毕之后,光标是停在下一行的起始位置
        // \r = 回车 - 当输入完毕之后,光标是停在当前行的起始位置

        // \b 代表一个退格
        System.out.println("AAA\bCC");//AACC

        // \" 双引号
        // \' 单引号
        System.out.println("\"");

        // \
        System.out.println("\\");// \

        // \\
        System.out.println("\\\\");

        System.out.println("他说:\"穷是一种病\"");

        System.out.println("D:\\temp\\emp");

        //\t 制表符 - tab[正常是四格]
        System.out.println("D:\temp\news");
    }
}
