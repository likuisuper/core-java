package tech.aistar.day17;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 本类功能:反射技术操作数组
 *
 * @author cxylk
 * @date 2020/8/18 19:14
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr1={10,20,30,40};

        String[] arr2={"java","python","php"};

        //对上面的数组进行扩容操作
        int[] temp= (int[]) exchange(arr1);
        System.out.println(Arrays.toString(temp));

        String[] temp2= (String[]) exchange(arr2);
        System.out.println(Arrays.toString(temp2));
    }

    private static Object exchange(Object arr){
        //1.确定一个新数组，首先要先确定新的数组的元素类型以及数组的长度
        int len= Array.getLength(arr);

        //2.反射获取数组的组件类型 - 元素类型
        Class<?> type=arr.getClass().getComponentType();

        ///3.通过反射的技术来构建新的数组
        Object temp=Array.newInstance(type,len<<1);

        //4.遍历arr,然后将arr中的原始数组的数据放入到反射创建出来的新的数组temp中
        for (int i = 0; i < len; i++) {
            //4-1.依然通过下标来获取原始数组对应下标的数据
            Object value=Array.get(arr,i);

            //4-2.将value这个数据存放到temp数组中去
            //反射设置数组的值
            Array.set(temp,i,value);
        }
        return temp;
    }
}
