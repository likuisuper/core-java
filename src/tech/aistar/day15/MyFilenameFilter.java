package tech.aistar.day15;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/11 19:07
 */
public class MyFilenameFilter implements FilenameFilter {

    private String suffix;//定义一个后缀

    public MyFilenameFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        //File还有一个构造 - File(File dir,String name)
        File file=new File(dir,name);

        //只要找出文件
        if(file.isDirectory()){
            return true;//如果这里return false,说明不会进入到目录里面去找
        }

        if(file.getName().endsWith(suffix))
            return true;

        return false;//不输出
    }
}
