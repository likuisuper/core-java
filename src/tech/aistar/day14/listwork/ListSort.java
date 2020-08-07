package tech.aistar.day14.listwork;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 本类功能:
 * 1、读取N个字符串作为输入，创建一个集合存储以上N个字符串到集合中,写
 * 一个方法convertToStringArray,将集合作为参数,这个方法将集合中的元素进行
 * 排序，并转换成字符串数组输出。
 * 输入示例:
 * 4
 * a
 * d
 * c
 * b
 * 输出示例
 * a
 * b
 * c
 * d
 *
 * @author cxylk
 * @date 2020/8/7 16:45
 */
public class ListSort {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");
        convertToStringArray(list);
        System.out.println(list);
    }

//    public static void convertToStringArray(List<String> list){
//        //临时集合,用于存放排序后的数组
//        List<String> tempList=new ArrayList<>();
//        //将原集合的第一个元素数据设置到里面
//        tempList.add(list.get(0));
//        for (int i = 1; i < list.size(); i++) {
//            for (int j = 0; j < tempList.size(); j++) {
//                if(list.get(i).compareTo(tempList.get(j))>0){
//                    if(j==tempList.size()-1){
//                        tempList.add(list.get(i));
//                        break;
//                    }
//                }else{
//                    tempList.add(j,list.get(i));
//                    break;
//                }
//            }
//        }
//        for(String s:tempList){
//            System.out.println(s);
//        }
//    }

    public static void convertToStringArray(List<String> list){
        //Comparator 比较器
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //o1与o2相等返回0 o1>o2 返回>0 o1<o2 返回<0
                //定制排序 o1在前表示升序  o2在前表示降序
                //return o1.compareTo(o2);//升序
                return o2.compareTo(o1);//降序
            }
        });
        for (String s:list){
            System.out.println(s);
        }
    }
}
