package tech.aistar.design.factory.abstracts;

/**
 * 本类功能:负责创建多个产品族中的多个产品
 *
 * @author cxylk
 * @date 2020/8/3 18:21
 */
public interface ProductFactory {//抽象工厂
    Sender produceSender();

    Caller produceCaller();
}
