package tech.aistar.day10.inter.poly;

import tech.aistar.day10.inter.relation.Cimpl;
import tech.aistar.day10.inter.relation.IC;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 18:53
 */
public class MethodReturn {
    //方法的返回类型写成接口,方法的返回值可以写成接口的实现类
    public static IC test(){
        return new Cimpl();
    }
}
