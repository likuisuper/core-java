package tech.aistar.day08.relation.homework;

/**
 * 本类功能:矩形实体类
 *
 * @author cxylk
 * @date 2020/7/29 11:48
 */
public class Rect extends Shape{
    private int len;

    private int width;

    public Rect() {
    }

    public Rect(int len, int width) {
        this.len = len;
        this.width = width;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rect{");
        sb.append("len=").append(len);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }

    //重写父类中的两个方法

    @Override
    public double area() {
        return len*width;
    }

    @Override
    public double girth() {
        return 2*(len+width);
    }
}
