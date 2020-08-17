package tech.aistar.day15.prj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/16 14:48
 */
public class ObjectDaoUtil {//设置成泛型类
    public static <T> List<T> findAll(String path){
        List<T> list=null;

        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(path))) {
            list= (List<T>) in.readObject();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            list=null;
        } catch (IOException e) {
            //e.printStackTrace();
            list=null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> void save(T t,String path){
        //1.先判断文件中是否已经存在曾经序列化过的对象
        List<T> oldList=findAll(path);

        //新建一个新的集合对象 - 用来为此次保存服务
        List<T> newList=new ArrayList<>();

        //2.判断
        if(null!=oldList&&oldList.size()>0){
            //将oldList中的所有的数据全部转移到newList集合中去
            newList.addAll(oldList);
        }
        newList.add(t);

        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(newList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
