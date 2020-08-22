package tech.aistar.day15.homework;

import tech.aistar.day10.homework01.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/20 21:04
 */
public class Test3 {
    public static final String PATH="src/tech/aistar/day15/homework/emp.txt";

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        try(BufferedReader in=new BufferedReader(new FileReader(PATH))) {
            //字符流以字符为单位
            String line=null;
            while(true){
                line=in.readLine();//一行一行读取，如果读取不到，则返回null
                if(null==line)
                    break;
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}