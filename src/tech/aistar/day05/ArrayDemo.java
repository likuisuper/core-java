package tech.aistar.day05;

import java.util.Arrays;

/**
 * 本类功能://数组的基本语法
 *
 * @author cxylk
 * @date 2020/7/22 10:44
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //1.定义一个长度为3的int型数组
        int[] arr=new int[3];
        System.out.println(arr);

        //数组的赋值方式
        //1.可以通过下标一一赋值
//        arr[0]=10;
//        arr[1]=20;
//        arr[2]=30;

        //2.可以通过普通for循环进行赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*100+1);
        }

        //3.可以在定义数组的同时进行赋值
        int[] arr2={123,34,22};

        //3-1
        int[] arr3=new int[]{199,39,3};

        //4.可以先声明一个数组，然后再进行统一赋值
        int[] arr4=new int[3];
        //统一赋值
        arr4=new int[]{34,32,355};
        //arr4={222,333,2};//error

        //java.lang.ArrayIndexOutOfBoundsException - 数组下标越界异常
        //System.out.println(arr[3]);

        //数组的遍历方式
        //1.可以通过下标一一进行赋值
        //System.out.println(arr[0]);

        //获取数组的长度，长度不是方法，是属性
        //System.out.println(arr.length);

//        String[] strs=new String[3];
//        //对象类型默认值是null
//        System.out.println(strs[0]);

        //普通for循环遍历
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("========");

        //3.jdk5.0以后提供的foreach语法 - 增强for循环(只读的for)
        for(int x:arr2){
            System.out.println(x);
        }

        System.out.println("=====");
        //4.自定义输出方式
        int[] arr5={433,33,24};
        String str=toArrayString(arr5);
        System.out.println(str);

        //细节
        int[] arr6=null;//java.lang.NullPointException - 空指针异常 - null.东西

        //int[] arr6=new int[0];
        String arr6Str=toArrayString(arr6);
        System.out.println(arr6Str);

        String str1=null;
        //System.out.println(str1.equals("tom"));报错
        //把常量放在比较的右边，因为null.东西会报空指针异常
        System.out.println("tom".equals(str1));

    }

    /**
     * 自定义数组的数组方式 - [想,想,想]
     * @param arr
     * @return
     */
    public static String toArrayString(int[] arr){
        //1.进行数组的参数有效性判断

        //还是会报错，因为短路或中只要第一个条件为真，就不会执行第二个条件
//        if(arr.length==0||null==arr){
//            return "[]";
//        }

        //null和arr的位置不要互换，要把常量放在等式的左边
        if(null==arr||arr.length==0){
            return "[]";
        }

        String str="[";

        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            str+=(i!=arr.length-1)?(arr[i]+","):arr[i];
        }

        str+="]";
        return str;
    }

}
