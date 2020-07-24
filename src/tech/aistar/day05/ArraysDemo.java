package tech.aistar.day05;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/24 19:50
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr1={1,3,5};
        int[] arr2={1,3,5};

        //System.out.println(arr1);
        //System.out.println(arr2);
        System.out.println(arr1==arr2);//false

        //true,因为两者指向的地址中的内容相同
        System.out.println(Arrays.equals(arr1,arr2));

        int[] arr3={2,5,2,56,34,29};
        Arrays.sort(arr3);

        System.out.println(Arrays.toString(arr3));
    }
}
