package tech.aistar.design.decorator;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/12 16:15
 */
public class NaiTea implements MilkTea{
    @Override
    public double getPrice() {
        return 10.0d;
    }

    @Override
    public String getType() {
        return "原味奶茶";
    }
}
