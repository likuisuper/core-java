package tech.aistar.day14.homework;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/10 18:05
 */
public class TestPurcase {
    public static void main(String[] args) {
        List<Purcase> list=new ArrayList<>();

        Purcase p1 = new Purcase("宝洁","洗手粉",18.5);
        Purcase p2 = new Purcase("联合利华","肥皂",4.5);
        Purcase p3 = new Purcase("宝洁","牙膏",32.5);
        Purcase p4 = new Purcase("宝洁","毛巾",14.5);
        Purcase p5 = new Purcase("洁利","洗面奶",26.0);
        Purcase p6 = new Purcase("好迪","洗发水",27.5);
        Purcase p7 = new Purcase("多芬","沐浴露",38.5);
        Purcase p8 = new Purcase("宝洁","洗洁精",3.4);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);

        printTotal(list);
    }

    public static void printTotal(List<Purcase> list){
        //1-统计品牌名和总价
        //key - 品牌名
        //value - 该品牌对应的Purcase集合
        Map<String,List<Purcase>> maps=new HashMap<>();

        //2.遍历list集合，进行统计的工作
        for (Purcase p : list) {
            //第一次进来
            String brand=p.getBrand();

            //判断maps是否包含当前的key
            if(maps.containsKey(brand)){
                //根据key获取之前的value
                List<Purcase> purcases=maps.get(brand);
                purcases.add(p);
            }else{
                //每次都是遇到一个新的品牌名
                //创建一个集合
                List<Purcase> lists=new ArrayList<>();
                //把当前的p放入到Lists集合中去
                lists.add(p);
                //放入到maps集合中

                //map集合的特征针对key无序不可重复
                //如果后面放入的key和之前是一样的,那么后面的value会覆盖前面的value
                maps.put(brand,lists);
            }
        }
        //到此,已经完成了分类的工作了
        maps.forEach(new BiConsumer<String, List<Purcase>>() {
            @Override
            public void accept(String s, List<Purcase> purcases) {
                System.out.println(s);
                System.out.println(purcases);
            }
        });

        //遍历Purcase集合
        //brand以及价格
        Map<String,Double> countMap=new HashMap<>();
        //遍历maps集合 - 归类之后的集合对象

        //map集合迭代方式 - 传统的两种必须要手写
        Set<String> sets=maps.keySet();//将maps集合中的所有的key全部放入到set集合中
        //set集合也是可以通过迭代器进行迭代的
        Iterator<String> iter=sets.iterator();
        while(iter.hasNext()){
            String key=iter.next();//key就是brand
            //获取该品牌对应的集合对象
            List<Purcase> purs=maps.get(key);
            //定义一个变量,用来保存这个品牌的总价
            double total=0.0d;

            for (Purcase pur : purs) {
                total+=pur.getCost();
            }
            countMap.put(key,total);
        }

        //进行排序
        //第一种方式通用的方式
        //排序的集合
        List<PurcaseDTO> dtos=new ArrayList<>();

        //遍历countMap集合
//            countMap.forEach(new BiConsumer<String, Double>() {
//                @Override
//                public void accept(String s, Double aDouble) {
//
//                }
//            });

        countMap.forEach((brand,total)->{
            dtos.add(new PurcaseDTO(brand,total));
        });

        //对dtos进行排序
//        dtos.sort((p1,p2)->{
//            return (int) (p2.getTotal()-p1.getTotal());
//        });

        //dtos.forEach(System.out::println);

//        dtos.forEach(e->{
//            System.out.println(e.getBrand()+":"+e.getTotal());
//        });

        //链式编程
        //java.util.Stream[I]
        dtos.stream().sorted((p1,p2)->{
            return (int)(p2.getTotal()-p1.getTotal());
        }).forEach(e->{
            System.out.println(e.getBrand()+":"+e.getTotal());
        });


    }
}
