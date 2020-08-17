package tech.aistar.day15.enums;

import tech.aistar.design.singleton.enums.Singleton07;

import java.io.*;

/**
 * 本类功能:反射和序列化(反序列化) -> 打破单例规则
 *
 * 枚举 -> (保证无论是采用反射攻击或者使用序列化和反序列) ->仍然保证是单例的
 *
 * @author cxylk
 * @date 2020/8/16 16:32
 */
public class TestSingleTon {
    public static final String PATH="src/tech/aistar/day15/enums/s.txt";

    public static void main(String[] args) {
        Singleton07 s1= Singleton07.getInstance();

        //通过反射的方式破坏单例
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(PATH))) {
            out.writeObject(s1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Singleton07 s2=null;

        //反序列化
        try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(PATH))) {
            s2= (Singleton07) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(s1==s2);
    }
}
