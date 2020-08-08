package tech.aistar.day14;

import tech.aistar.util.DateUtil;

import java.util.*;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/7 13:48
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        //添加元素
        map.put("劫","吾所成之事,不可逆也");
        map.put("亚索","长路漫漫,唯剑作伴");
        map.put("烬","黎明中的花朵");
        map.put("烬","科比式外交");
        //map.put("烬","科比式外交");

        Set<Map.Entry<String,String>> set=map.entrySet();
        Iterator<Map.Entry<String,String>> iterator1=set.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        //亚索=长路漫漫,唯剑作伴
        //劫=吾所成之事,不可逆也
        //烬=科比式外交

        //输出map中键值对的个数,键值唯一
        System.out.println(map.size());//当有重复的key时，size为3

        //根据key获取value出现的位置
        System.out.println(map.get("劫"));
        //出现key值重复设置,则value会发生替换
        System.out.println(map.get("烬"));//科比式外交

        System.out.println(map.isEmpty());

        //返回map中所有value构成的集合
        Collection<String> values=map.values();
//        for(String x:values)
//            System.out.println(x);

        //返回map中所有Key值构成的集合
        Set<String> keys=map.keySet();
        //遍历map,输出map中的键值对
        for(String key:keys)
            System.out.println("key:"+key+"value:"+map.get(key));

        //Key Value -> Entry{key value}
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        Iterator<Map.Entry<String,String>> iterator=entrySet.iterator();

        while(iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

    }
}
