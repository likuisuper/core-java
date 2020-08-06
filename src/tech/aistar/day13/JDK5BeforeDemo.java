package tech.aistar.day13;

import java.util.ArrayList;
import java.util.List;

/**
 * 本类功能:借助于集合框架来理解泛型的引入
 *
 * @author cxylk
 * @date 2020/8/6 10:07
 */
public class JDK5BeforeDemo {
    public static void main(String[] args) {
        //最顶级的集合接口java.util.Collection[I]
        //顶级接口下拥有List子接口[I] - 常用的集合实现类ArrayList[C]
        //集合是用来替代数组的使用的

        //在jdk5.0之前还没有引入泛型的时候,如何创建集合对象呢?
        //jdk5.0之前的集合框架 - 类型不安全的框架
        List list01=new ArrayList();
        //可以向这个集合中添加任意的数据类型的

        //没有看到任何泛型之前,add(Object obj)

        //并没有对添加到集合中的数据进行类型的校验
        list01.add(10);
        list01.add("ok");
        list01.add(null);

        //String result1=list01.get(1);//会报错,因为object不能转化为String类型的
        //进行强制转换
        String result1=(String)list01.get(1);
        System.out.println(result1);

        System.out.println(list01);

        //jdk5.0开始引入了泛型
        //list02中就只能添加Long类型
        //保证了程序在编译期间的类型的安全

        //泛型只能使用对象类型
        List<Long> list02=new ArrayList<Long>();
        list02.add(100L);//只能添加Long类型的
        list02.add(200L);
        System.out.println(list02);

        //JDK7.X以后 - new ArrayList<>中的泛型是可以省略的,why???
        List<String> list03=new ArrayList<>();
        list03.add("ok");
        list03.add("ok");

        list03.add("good");

        System.out.println(list03);

        //只要程序在编译期间不报错,添加到容器中的数据的类型是属于泛型的
        //那么在运行期间涉及到转换类型的时候,肯定不会报错
        String result2=list03.get(1);//编译期间ok
        System.out.println(result2);
    }
}
