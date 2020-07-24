package tech.aistar.day05;

import java.util.Arrays;

/**
 * 本类功能:数组拷贝的两种方式
 *
 * @author cxylk
 * @date 2020/7/23 10:11
 */
public class ArrayCopyDemo {
    public static void main(String[] args) {
        int[] arr={1,2,4,5};

        int[] temp= Arrays.copyOf(arr,arr.length);

        System.out.println(Arrays.toString(temp));

        System.out.println(Arrays.toString(copy02(arr,3)));

    }

    /**
     * public static native void arraycopy(Object src,  int  srcPos,
     *                                         Object dest, int destPos,
     *                                         int length);
     *
     *   * @param      src      原数组对象
     *   * @param      srcPos   从原数组中的srcPos下标处开始取数据.
     *   * @param      dest     目标数组对象
     *   * @param      destPos  放入到目标数组中的destPos下标处.
     *   * @param      length   从原数组中拷贝的个数
     * @param arr
     * @return
     */
    public static int[] copy01(int[] arr){
        //arr中的数据全部放入到temp中 - 拷贝

        //1.定义一个目标数组对象
        int[] temp=new int[arr.length];

        //2.直接调用API
        //该方法底层肯定是直接操作了temp
        System.arraycopy(arr,0,temp,0,arr.length);

        return temp;
    }

    public static int[] copy02(int[] arr,int len){
        int[] temp=Arrays.copyOf(arr,len);
        return temp;
    }
}
