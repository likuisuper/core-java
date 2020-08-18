package tech.aistar.day17;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/18 9:19
 */
public class Point {
    //私有的属性
    //私有的是2
    private int x;

    private String y;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("x=").append(x);
        sb.append(", y='").append(y).append('\'');
        sb.append('}');
        return sb.toString();
    }
//    int m;//默认的是0
//
//    protected int n;//受保护的是4
//
//    public int z;//公开的是1


    public Point() {
        System.out.println("Point空参构造");
    }

    public Point(int x, String y) {
        System.out.println("x:"+x+",y:"+y);
    }

    public void test(){
        System.out.println("test()...");
    }

    public void test(int x){
        System.out.println("x:"+x);
    }

    public void test(int x,String y){
        System.out.println("x:"+x+",y:"+y);
    }

    public static void testStatic(){
        System.out.println("static...");
    }

    private void testPrivate(){
        System.out.println("private..");
    }

    public String getResult(){
        return "ok";
    }
}
