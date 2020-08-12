package tech.aistar.design.decorator;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/12 16:47
 */
public class WuLongTea extends Batching {

    public WuLongTea(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public double getPrice() {
        return super.getPrice()+20.0d;
    }

    @Override
    public String getType() {
        return super.getType()+":乌龙品种";
    }
}
