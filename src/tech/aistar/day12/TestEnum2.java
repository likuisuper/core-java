package tech.aistar.day12;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/5 20:02
 */
public class TestEnum2 {
    public static void main(String[] args) {
        for(EnumDemo2 e:EnumDemo2.values()){
            System.out.println(e+":"+e.getSign());
        }
    }
}
