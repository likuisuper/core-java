package tech.aistar.day03.params;

/**
 * 本类功能:参数列表
 *
 * @author cxylk
 * @date 2020/7/20 13:08
 */
public class ParamDemo {
    public static void main(String[] args) {
        //String[] args也可以这样写:String...

        ParamDemo paramDemo=new ParamDemo();

        //此处的100，"张三"就是实参
        String result=paramDemo.add(100,"张三");
        System.out.println("result:"+result);

        paramDemo.sub(10,20,30);
    }

    /**
     * 此处的age,name就是形参 - 告诉方法的调用者在调用方法的时候需要传入的参数
     * 需要注意类型，顺序以及个数，高度保持一致
     * @param age
     * @param name
     * @return
     */
    public String add(int age,String name){
        return "姓名:"+name+",年龄:"+age;
    }

    /**
     * 可变长列表
     * @param arr
     */
    public void sub(int... arr){
        //此处的arr实际上是一个数组
        System.out.println(arr[0]);

        for(int x:arr){
            System.out.println(x);
        }
    }
}
