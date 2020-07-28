package tech.aistar.day07.homework;

/**
 * 本类功能:显示器
 *
 * @author cxylk
 * @date 2020/7/27 18:01
 */
public class Monitor {
    //类型
    private String types;

    //尺寸
    private int size;

    //品牌
    private String brand;

    public Monitor() {
    }

    public Monitor(String types, int size, String brand) {
        this.types = types;
        this.size = size;
        setSize(size);
        this.brand = brand;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setSize(int size) {
        if(size==17||size==23||size==19||size==25){
            this.size=size;
            return;
        }
        this.size = 17;
    }

    public int getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Monitor{");
        sb.append("types='").append(types).append('\'');
        sb.append(", size=").append(size);
        sb.append(", brand='").append(brand).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
