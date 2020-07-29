package tech.aistar.day08.relation.homework;

/**
 * 本类功能:正方形实体类 (继承的精髓)
 *
 * @author cxylk
 * @date 2020/7/29 11:55
 */
public class Square extends Rect{
    private int len;

    public Square() {
    }

    public Square(int len){
        super(len,len);
    }
}
