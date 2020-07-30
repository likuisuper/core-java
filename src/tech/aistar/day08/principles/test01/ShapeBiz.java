package tech.aistar.day08.principles.test01;

import tech.aistar.day08.relation.homework.Shape;

/**
 * 本类功能:形状业务类 - 负责输出周长和面积
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
