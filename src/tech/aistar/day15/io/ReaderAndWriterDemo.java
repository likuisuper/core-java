package tech.aistar.day15.io;

import java.io.*;
import java.lang.annotation.Target;

/**
 * 本类功能:使用字符流来完成拷贝 - 只能操作字符文件
 *
 * @author cxylk
 * @date 2020/8/16 14:18
 */
public class ReaderAndWriterDemo {
    public static final String SRC="src/tech/aistar/day15/io/001.jpg";
    public static final String TARGET="src/tech/aistar/day15/io/001_reader.jpg";

    public static void main(String[] args) {
        try(BufferedReader in=new BufferedReader(new FileReader(SRC))) {
            PrintWriter out=new PrintWriter(new FileWriter(TARGET));

            String line=null;

            while((line=in.readLine())!=null){
                out.println(line);
            }
            System.out.println("拷贝成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
