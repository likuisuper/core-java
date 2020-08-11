package tech.aistar.day15.homework;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 本类功能:
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
//        // 定义一个HashMap集合
//        Map<Character, Integer> map = new HashMap<>();
//
//        // 把字符串转换为字符数组
//        char[] chs = str.toCharArray();
//
//        // 遍历字符数组，得到每一个字符
//        for (char ch : chs) {
//            // 拿刚才得到的字符作为键去集合中找，看返回值
//            Integer i = map.get(ch);
//
//            // 是null：说明该键不存在，就把该字符作为键，1作为值存储
//            if (i == null) {
//                map.put(ch, 1);
//            } else {
//                // 不是null：说明该键存在，就把值加1，然后重新存储该键和值
//                ++i;
//                map.put(ch, i);
//            }
//        }
//
//        map.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });


        Map<Character,Integer> map=new HashMap<>();

        //将字符串转换为字符数组
        char[] chars=str.toCharArray();

        //遍历字符数组
        for (char ch : chars) {
            Integer i=map.get(ch);//拿刚刚遍历得到的字符去map中找,看返回值
            if(i==null){
                //如果第一次出现,将该字符作为key,value就是出现次数,置为1
                map.put(ch,1);
            }else {//如果不是第一次出现
                ++i;
                map.put(ch,i);//更新字符对应的出现次数
            }
        }

//        map.forEach(new BiConsumer<Character, Integer>() {
//            @Override
//            public void accept(Character character, Integer integer) {
//                System.out.println(character+":"+integer);
//            }
//        });

//        map.forEach((k,v)->{
//            System.out.println(k+":"+v);
//        });

        Set<Map.Entry<Character,Integer>> set=map.entrySet();
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(set);
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue()-o2.getValue();
            }
        });

        System.out.println(list);
    }

}
