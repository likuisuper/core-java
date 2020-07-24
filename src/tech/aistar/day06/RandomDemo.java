package tech.aistar.day06;

import java.util.Random;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/24 9:55
 */
public class RandomDemo {
    public static void main(String[] args) {
        //1.导包
        //2.创建Random对象 - API - 构造方法
        Random r=new Random();
        //nextInt返回的是[0-n)之间的随机整数
        int result=r.nextInt(3)+3;//返回[3-5]之间的随机整数
        System.out.println(result);

        //输出0-10之间的随机整数,每次都会变化
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextDouble());
        }

        System.out.println("====种子构造====");

        //利用一个随机种子来构建一个Random对象
        Random r2=new Random(1L);

        //无论输出多少次，输出的数都不会变化
        for (int i = 0; i < 10; i++) {
            System.out.println(r2.nextDouble());
        }
    }
}
