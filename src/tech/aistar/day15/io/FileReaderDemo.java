package tech.aistar.day15.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 本类功能:字符输入流
 *
 * @author cxylk
 * @date 2020/8/16 14:08
 */
public class FileReaderDemo {
    public static final String PATH="src/tech/aistar/day15/io/001.jpg";

    public static void main(String[] args) {
        try(BufferedReader in=new BufferedReader(new FileReader(PATH))) {
            //字符流以字符为单位
            String line=null;
            while(true){
                line=in.readLine();//一行一行读取，如果读取不到，则返回null
                if(null==line)
                    break;
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
