package tech.aistar.day09.test01;

import tech.aistar.day08.relation.homework.Shape;
import tech.aistar.day08.relation.homework.Rect;
import tech.aistar.day08.relation.homework.Circle;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 20:31
 */
public class ShapeBiz {
    //    public void rectGirth(Rect rect){
//        System.out.println(rect.girth());
//    }
//
//    public void circleGirth(Circle circle){
//        System.out.println(circle.girth());
//    }

    //采用多态的应用2 - 方法的参数类型可以写成父类,那么调用方法的时候
    //可以传入这父类的任何一个子类对象
    public void shapeGirth(Shape s){

        //调用的时候调用的是子类重写之后的方法.
        System.out.println(s.girth());
    }
}
