package tech.aistar.day15.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 本类功能:桥接器
 *
 * 编码 - 解码的过程
 *
 * 编码 - 字符->字节的过程
 *
 * 解码 - 字节->字符
 *
 * 笔试题 - 不允许使用Scanner来获取键盘输入
 *
 * Scanner(InputStream in);
 *
 * InputStream in=System.in
 *
 * @author cxylk
 * @date 2020/8/16 13:49
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("请你输入>");

        try {
            String line=in.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请你输入");
//        try {
//            String line=in.readLine();
//            System.out.println(line);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
