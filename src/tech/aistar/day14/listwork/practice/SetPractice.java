package tech.aistar.day14.listwork.practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 本类功能:
 *
 * 3、写一个程序，接收键盘输入，得到两个集合，输出这两个集合中都不重复的数。
 * 输入第一个数N，接下来N个数都作为第一个集合的元素，接着输入第二个数M，接下来
 * M个数都将作为第二个集合的元素。
 * 输入示例1:
 * 4
 * 1
 * 8
 * 3
 * 5
 * 2
 * 3
 * 5
 * 输出示例1:
 * 1
 * 8
 *
 * @author cxylk
 * @date 2020/8/7 17:55
 */
public class SetPractice {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        //输入第一个整数
        int countOne=scanner.nextInt();
        for (int i = 0; i < countOne; i++) {
            //向集合中添加对应整数个数的元素
            set1.add(scanner.nextInt());
        }

        //输入第二个整数
        int countTwo=scanner.nextInt();
        for (int i = 0; i < countTwo; i++) {
            set2.add(scanner.nextInt());
        }

        //创建第三个集合,用于存放两个集合中互不存在的数
        Set<Integer> set3=new HashSet<>();

        for(Integer value:set1){
            if(set2.add(value))
                set3.add(value);
        }
        for(Integer value:set2){
            if(set1.add(value))
                set3.add(value);
        }

        Iterator<Integer> integerIterator=set3.iterator();
        while(integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
    }
}
