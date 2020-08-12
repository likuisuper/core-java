package tech.aistar.design.decorator;

/**
 * 本类功能:配料的顶级抽象类
 *
 * @author cxylk
 * @date 2020/8/12 16:19
 */
public abstract class Batching implements MilkTea{

    private MilkTea milkTea;//依赖倒置原则

    public Batching(MilkTea milkTea){
        this.milkTea=milkTea;
    }

    @Override
    public double getPrice() {
        return milkTea.getPrice();
    }

    @Override
    public String getType() {
        return milkTea.getType();
    }
}
