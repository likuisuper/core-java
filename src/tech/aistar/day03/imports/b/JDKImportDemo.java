package tech.aistar.day03.imports.b;

import java.util.Date;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/20 13:30
 */
public class JDKImportDemo {
    public static void main(String[] args) {
        String name="ok";
        System.out.println(name);

        //演示导包 - 除了java.lang下不需要导包，其他包都是需要手动导入的
        Date d=new Date();
        System.out.println(d);

        int result=(int)Math.pow(2,3);
        System.out.println(result);
    }
}
