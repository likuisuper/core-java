package tech.aistar.day08.relation.homework;

/**
 * 本类功能:圆实体类
 *
 * @author cxylk
 * @date 2020/7/29 11:48
 */
public class Circle extends Shape{
    private double radius;//半径

    private static final double PI=3.14;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI*Math.pow(radius,2);
    }

    @Override
    public double girth() {
        return 2*PI*radius;
    }
}
