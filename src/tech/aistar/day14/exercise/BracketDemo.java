package tech.aistar.day14.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 本类功能:括号匹配
 *
 * @author cxylk
 * @date 2020/8/10 14:09
 */
public class BracketDemo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入括号");
        String str=sc.nextLine();
        if(match(str))
            System.out.println("匹配");
        else
            System.out.println("不匹配");
    }

    /**
     * 思路:
     * 获取键盘输入nextLine - [({})]
     * 把这个字符串打散成字符串数组.
     *
     * //新建一个LinkedList集合.然后将数组中的第一个元素压入栈顶.
     * list.push(arr[0]);//   [
     *
     * //从数组的第二个元素开始遍历.( { } ) ]
     *
     * 1. 获取栈顶元素,然后和当前遍历的数组的元素进行比较
     *    a. [ 和 ( -> 不匹配 -> 将当前的元素继续压入栈顶
     *       list -> [ (
     *
     *       循环遍历比较...
     *       list ->
     *    b . 如果当前的元素和栈顶元素匹配了,那么就弹出栈顶元素.
     *
     * 匹配的情况 - 判断list.isEmpty();//判断集合中是否存在元素.
     * @param str
     * @return
     */
    public static boolean match(String str){
        //将字符串转换成字符数组
        char[] chars=str.toCharArray();
        //创建集合
        LinkedList<Character> list=new LinkedList<>();
        //将第一个元素压入栈顶
        list.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            //获取当前遍历的元素
            Character c=chars[i];
            //获取栈顶元素
            Character top=null;
            //不判断的话,当匹配完一对括号后集合里面就空了，这时会报NoSuchElementException()异常
            if(list.isEmpty()){
                list.push(c);
                //跳过本轮循环，继续下一轮循环
                continue;
            }else {
                top=list.getFirst();
            }
            //比较
            if((top.equals('(')&&c.equals(')'))||(top.equals('[')&&c.equals(']'))||(top.equals('{')&&c.equals('}'))){
                //如果匹配，弹出栈顶元素
                list.pop();
            }else{
                //否则将当前元素压栈
                list.push(c);
            }
        }
        return list.isEmpty();//为空就是匹配成功
    }
}
