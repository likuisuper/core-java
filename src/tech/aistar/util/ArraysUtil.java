package tech.aistar.util;

import java.util.Arrays;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/22 14:23
 */
public class ArraysUtil {

    public static void main(String[] args) {
        int[] arr={5,5,5,7,2,1,5};

        /*
        int[] temp=getIndexByTarget(arr,5);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));//此时的arr指向的值仍然不变，因为该方法中没有改变它的值
        //要想改变此时arr的值，让arr指向temp就可以
        arr=temp;
        System.out.println(Arrays.toString(arr));//此时arr指向的值和temp指向的值一样

         */

        //-------------------------------------
        int[] temp=delByIndex(arr,4);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));


        //----------------------------------
        //System.out.println(Arrays.toString(delByTarget(arr,5)));

        //----------------------------
/*        int[] temp=delByPos(arr,2);
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(arr));*/


        //------------------------
        //System.out.println(Arrays.toString(delDoubleElement01(arr)));

//        System.out.println(Arrays.toString(delDoubleElement02(arr)));
//        System.out.println(Arrays.toString(arr));

        //-------------------
        //System.out.println(Arrays.toString(insertOneElement(arr,3,8)));


     }

    /**
     * 找出数组中最大的值
     * @param arr
     * @return
     */
    public static int getMaxElement(int[] arr){
        if(null==arr||arr.length==0)
            return -1;//返回错误的标记即可
        //定义一个变量，用来保存最大值
        int max=arr[0];//假设数组第一个元素是最大的
        //遍历数组
        for (int i = 1; i <arr.length ; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    /**
     * 找出数组中target元素对应的所有的下标
     * @param arr
     * @param target 元素
     * @return
     */
    public static int[] getIndexByTarget(int[] arr,int target){
        if(null==arr||arr.length==0)
            return new int[0];
        //1.定义一个变量代表target出现的次数
        int count=0;

        //2.遍历原数组，计算count出现的次数
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target)
                count++;
        }

        //count可能为0,即target没有出现
        if(count==0)
            return new int[0];

        //程序走到这一步，代表target肯定出现了

        //3.定义一个临时数组，来存储下标值，它的长度就是target出现的次数
        int[] temp=new int[count];

        //定义一个下标计数器，代表temp数组的下标
        int pos=0;

        //4.遍历原数组，把下标存到临时数组中
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target)
                temp[pos++]=i;//先用pos的值，再让它加1
        }
        return temp;
    }

    /**
     * 根据下标删除数组中的元素
     *
     * 思路:int[] arr = {5,4,5,7,2,1,5};
     *      int[] temp = new int[arr.length-1];//下标是唯一的
     *
     *      1. 遍历arr -> i!=index -> arr[i]放入到新的temp中.
     *
     *      2. 如果是index位置的值,不把它放入到temp中
     *
     *      3. 返回temp数组 - 给我们的感觉好像是进行删除操作.
     *
     * main: arr --->[5,4,5,7,2,1,5] <------方法中的arr(main方法中arr的副本)
     *
     *  temp----->[5,4,5,7,1,5],让方法中的arr=temp，main方法中arr的值仍然不变
     *
     * @param arr 数组
     * @param index 下标是唯一的
     * @return
     */
    public static int[] delByIndex(int[] arr,int index){
        if(null==arr||arr.length==0)
            return null;
        //1.定义一个临时数组，并确定该数组的长度
        //因为是删除操作，所以数组长度比原数组长度小
        int[] temp=new int[arr.length-1];

        //定义一个下标计数器pos
        int pos=0;

        //2.遍历数组
        for (int i = 0; i < arr.length; i++) {
            if(i!=index)
                temp[pos++]=arr[i];
        }

        return temp;

        //下面for循环之后，main方法中的arr值改变
/*        for (int i = 0; i < arr.length-1; i++) {
            arr[i]=temp[i];
        }
        return arr;*/

    }

    /**
     * 根据元素进行删除
     *
     * 思路：
     *
     * 1.先确定target出现的次数
     *
     * 2.定义一个数组，并确定它的长度
     *
     * 3.遍历arr
     *
     * 4.return temp
     *
     * 删除数组中所有的target元素
     * @param arr
     * @param target
     * @return
     */
    public static int[] delByTarget(int[] arr,int target){
        if(null==arr||arr.length==0)
            return new int[0];
        //1.确定target是否存在
        int count=0;

        //2.遍历
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]==target)
                count++;
        }

        if(count==0)
            return new int[0];

        //3.target肯定存在
        //确定新的数组的长度 - 新的数组就是不包含target元素
        //长度就是原来数组长度-target元素出现的次数
        int[] temp=new int[arr.length-count];

        //定义下标计数器
        int pos=0;

        //4.遍历原来数组
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=target)
                temp[pos++]=arr[i];
        }
        return temp;

    }

    /**
     * 操作数组的原则 - 尽量不要对原来的数组进行直接的操作.
     *
     * 根据下标进行删除操作
     *  {5,4,5,7,2,1,5};
     *
     *  假设index = 3
     *
     *  思路:从index位置开始,后面的覆盖前面的 - arr[i] = arr[i+1]
     *  {5,4,5,2,1,5,5};
     *
     * @param index
     * @return
     */
    public static int[] delByPos(int[] arr,int index){
        if(null==arr||arr.length==0)
            return new int[0];

        //1.定义一个临时数组，确定长度
        //长度就是arr的长度，因为要把arr的数拷贝到temp中
        int[] temp=new int[arr.length];

        //2.拷贝
        for (int i = 0; i < arr.length; i++) {
            temp[i]=arr[i];
        }

        //3.从index开始，让后面的数替代前面的数
        for(int i=index;i<temp.length-1;i++){//因为i+1不能超过temp的长度
            temp[i]=temp[i+1];
        }

        //4.再创建一个数组，去除最后一个重复的数据
        int[] news=new int[temp.length-1];//长度就是temp数组长度去掉最后一个重复数据
        for (int i = 0; i < news.length; i++) {
            news[i]=temp[i];
        }
        return news;
    }

    /**
     * 数组排重 - 去除数组中重复的数据,只保留1个.
     *
     * 思路:
     * arr = {5,4,5,7,2,1,5};
     *
     * 定义数组
     * temps= {0,0,0,0,0,0,0};
     *
     * 永远将arr[0]放入到temp中 -> temp[0] = 5
     * temps= {5,0,0,0,0,0,0};
     *
     * 调用根据元素删除的方法->立即到arr中将刚刚的arr[0]全部删除
     * arr -> {4,7,2,4,1};
     *
     * arr = temp;
     *
     * temps[1] = arr[0] = 4
     * temps= {5,4,7,2,1,0,0};
     *
     * @param arr
     * @return
     */
    public static int[] delDoubleElement01(int[] arr) {
        if (null == arr || arr.length == 0)
            return new int[0];

        //1.定义一个新数组
        int[] temp = new int[arr.length];//里面数据都是0

        //定义一个下标计数器
        int pos = 0;

        do {
            //永远将arr[0]放到temp中去
            temp[pos++] = arr[0];
            //调用删除元素的方法，立即到arr中将刚刚的arr[0]全部删除
            arr = delByTarget(arr, arr[0]);
            //当arr中没有元素的时候，跳出
            if (arr.length == 0)
                break;
        } while (true);
        temp=Arrays.copyOf(temp,pos);//复制该数组的前pos位
        return temp;
    }


    /**
     * 思路:
     * arr = {5,4,5,7,2,1,5};
     *
     * i=0,接下来遍历j=i+1位置开始->数组的最后
     *
     * if(arr[i] == arr[j]){
     *     //根据下标删除
     * }
     *
     * 数组排重 - 去除数组中重复的数据,只保留1个.
     * @param arr
     * @return
     */
    public static int[] delDoubleElement02(int[] arr){
        if(null==arr||arr.length==0)
            return null;

        //1 2 2 2 5 6 7
        //1 2 2 5 6 7
        for(int i=0;i< arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    arr=delByPos(arr,j);
                    //j--是防止出现两个重复元素在一起的时候漏删
                    j--;
                }
            }
        }

        //也可以从后往前删，避免漏掉
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = arr.length; j >=i+1 ; j--) {
//                if(arr[i]==arr[j]){
//                    arr=delByIndex(arr,j);
//                }
//            }
//        }

        return arr;

    }

    /**
     * 数组排重 - 去除数组中重复的数据,只保留1个.
     * @param arr
     * @return
     */
    public static int[] delDoubleElement03(int[] arr){
        if(null==arr||arr.length==0)
            return null;

        //1.定义一个布尔类型的数组
        boolean[] flags=new boolean[arr.length];

        //2.全部设置成true
//        for (int i = 0; i < flags.length; i++) {
//            flags[i]=true;
//        }

        Arrays.fill(flags,true);//统一进行赋值

        //把原数组中重复出现的元素的设置成false
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j]){
                    flags[j]=false;
                }
            }
        }
    }

    /**
     * 在arr数组的指定pos下标处插入一个指定的值target
     * @param arr
     * @param pos
     * @param target
     * @return
     */
    public static int[] insertOneElement(int[] arr,int pos,int target){
        return null;
    }

    /**
     * 在arr数组的指定pos下标处插入N个指定的值target
     * @param arr
     * @param pos
     * @param target
     * @return
     */
    public static int[] insertOneElement02(int[] arr,int pos,int... target){
        return null;
    }

}
