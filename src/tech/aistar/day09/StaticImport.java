package tech.aistar.day09;

import java.util.Calendar;

//静态导入静态成员
import static java.util.Calendar.*;

/**
 * 本类功能:静态导入
 *
 * @author cxylk
 * @date 2020/7/30 20:12
 */
public class StaticImport {
    public static void main(String[] args) {
//        public final static int YEAR=1;
//        System.out.println(Calendar.YEAR);

        System.out.println(YEAR);

        System.out.println(MONTH);

        Calendar cal=getInstance();
    }
}
