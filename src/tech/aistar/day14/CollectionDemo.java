package tech.aistar.day14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/7 9:23
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //如果忽略泛型,以Object类型看待
        //List list=new ArrayList();

        //String表示泛型,泛型定义了集合中存储的元素类型
        List<String> list=new ArrayList<String>();

        //集合中有多少元素
        System.out.println(list.size());//0
        System.out.println(list.isEmpty());//true

        list.add("西游记");
        System.out.println(list.isEmpty());//false
        System.out.println(list.size());//1

        Collection<String> list1=new ArrayList<>();
        list1.add("水浒传");

        //向当前集合中添加另外一个集合
        list.addAll(list1);
        System.out.println(list.size());

        //清空集合元素
        list.clear();
        System.out.println(list.size());

        //集合的遍历
        list.add("红楼梦");
        list.add("三国演义");
        //Collection中没有根据索引获取数据的方法
        for(String x:list){
            System.out.println(x);
        }
        //迭代器遍历方式
        //Iterator<String> iterator=list.iterator();//Collection中的iterator
        Iterator<String> iterator=list.listIterator();//list中的iterator
        while(iterator.hasNext()){//hasnext是否有下一个元素
            System.out.println(iterator.next());//获取下一个元素
        }

        //for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //数组类型 String
        String[] strings=new String[list.size()];
        //将集合转化为数组
        list.toArray(strings);
        for(String s:strings){
            System.out.println(s);
        }
    }

}
