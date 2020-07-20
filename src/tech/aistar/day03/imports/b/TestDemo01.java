package tech.aistar.day03.imports.b;

import tech.aistar.day03.imports.a.Demo01;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/20 13:30
 */
public class TestDemo01 {
    public static void main(String[] args) {

        //类的全限定名 - 包名.类名
        Demo01 d1=new Demo01();
        d1.add();

        //如果还想继续使用c包下的Demo01;

        tech.aistar.day03.imports.c.Demo01 d=new tech.aistar.day03.imports.c.Demo01();
        d.add();
    }
}
