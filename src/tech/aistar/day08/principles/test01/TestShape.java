package tech.aistar.day08.principles.test01;

import tech.aistar.day08.relation.homework.Rect;
import tech.aistar.day08.relation.homework.Shape;
import tech.aistar.day08.relation.homework.Square;

/**
 * 本类功能:测试
 *
 * @author cxylk
 * @date 2020/7/29 20:32
 */
public class TestShape {
    public static void main(String[] args) {
        ShapeBiz biz = new ShapeBiz();

        //Rect rect = new Rect(10,5);
        Shape rect = new Rect(10,5);

        biz.shapeGirth(rect);

        Shape s1 = new Square(10);
        biz.shapeGirth(s1);
    }
}
