package tech.aistar.day04;

import java.util.Scanner;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/22 8:26
 */
public class ScannerExecise {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("======a=====");
        int a=sc.nextInt();
        System.out.println("a:"+a);

        System.out.println("=====c======");
        String c=sc.nextLine();//失效
        System.out.println("c:"+c);

        System.out.println("=====b======");
        double b=sc.nextDouble();
        System.out.println("b:"+b);
    }
}
