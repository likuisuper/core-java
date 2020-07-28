package tech.aistar.day07;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 13:47
 */
public class TestBuilderAppend {
    public static void main(String[] args) {
        testStringBuilder();

        testString();
    }

    public static void testString(){
        String str="";

        long start=new Date().getTime();

        for (int i = 0; i < 100000; i++) {
            str+=i;
        }
        System.out.println("消耗:"+(new Date().getTime()-start)+"ms");
    }

    public static void testStringBuilder(){
        StringBuilder sb=new StringBuilder();

        long start=new Date().getTime();

        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }

        System.out.println("消耗:"+(new Date().getTime()-start)+"ms");
    }
}
