package tech.aistar.day08.relation.homework;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 11:58
 */
public class TestShapeDemo {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        Shape square=new Square(10);

        Shape rect=new Rect(10,20);

        Shape circle=new Circle(10.0d);

        shapes[0]=square;
        shapes[1]=rect;
        shapes[2]=circle;

        for(Shape s:shapes){
            System.out.println(s.area());
            System.out.println(s.girth());
            System.out.println("====");
        }
    }

}
