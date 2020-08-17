package tech.aistar.day15.homework;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 本类功能:字母排序
 *
 * 键盘输入字母abcdeafdfdwddf
 * 然后统计每个字母的个数
 * 按照字母的个数升序排
 * 当字母个数一样的时候,继续按照字母本身降序.
 *
 * @author cxylk
 * @date 2020/8/11 20:00
 */
public class AlphabetSort {
    public static void main(String[] args) {
        // 定义一个字符串：键盘录入方式
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        sort(line);
    }

    public static void sort(String str){
        //1.创建一个Map集合,key=字符串,value=字符串的个数
        Map<Character,Integer> maps=new HashMap<>();
        //2.将字符串转换为字符数组
        char[] chars=str.toCharArray();
        //遍历字符数组
        for (char ch : chars) {
            //判断maps集合中是否包含ch
            if(maps.containsKey(ch)){
                //如果已经包含，将字符以及它对应的次数加1放入put
                maps.put(ch,maps.get(ch)+1);
            }else{
                maps.put(ch,1);//ch第一次出现在maps中
            }
        }
        //4.排序规则 - 根据次数升序排，然后一样的时候，继续根据字母降序排
        //直接使用Entry对象

        List<Map.Entry<Character,Integer>> list=new ArrayList<>(maps.entrySet());

        list.sort((e1,e2)->{
            if(e1.getValue()>e2.getValue())
                return 1;
            else if(e1.getValue()==e2.getValue()){
                return e2.getKey().compareTo(e1.getKey());
            }
            return -1;
        });

        list.forEach(e-> System.out.println(e));

    }

}
