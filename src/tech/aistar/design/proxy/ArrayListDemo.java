package tech.aistar.design.proxy;

import java.util.Arrays;
import java.util.List;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 21:05
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("ok","java");
        //System.out.println(list);//[ok,java]
        System.out.println(list.get(1));//java

        //报错java.lang.UnsupportedOperationException
        //System.out.println(list.remove(1));

        //因为Arrays是代理对象class java.util.Arrays$ArrayList
        //不是所有的功能都让代理来做，特别是这种删除的
        System.out.println(list.getClass());
    }
}
