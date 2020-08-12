package tech.aistar.design.decorator;

/**
 * 本类功能:顶级的接口
 *
 * @author cxylk
 * @date 2020/8/12 16:13
 */
public interface MilkTea {
    /**
     * 获取价格
     * @return
     */
    double getPrice();

    /**
     * 获取奶茶的种类的名称
     * @return
     */
    String getType();
}
