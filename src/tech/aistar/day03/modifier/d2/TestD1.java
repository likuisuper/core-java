package tech.aistar.day03.modifier.d2;

import tech.aistar.day03.modifier.defaults.D1;

/**
 * 本类功能:演示导包
 *
 * @author cxylk
 * @date 2020/7/20 12:51
 */
public class TestD1 {
    D1 d1=new D1();
    //d1.find;//不能访问find方法，应为该方法是缺省的，只能在本包中访问
}
