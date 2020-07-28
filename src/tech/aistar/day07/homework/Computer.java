package tech.aistar.day07.homework;

/**
 * 本类功能:计算机
 *
 * @author cxylk
 * @date 2020/7/27 17:57
 */
public class Computer {
    //品牌
    private String brand;

    //价格
    private double price;

    //描述
    private String description;

    //显示器类型
    private Monitor monitor;

    public Computer() {
    }

    public Computer(String brand, double price, String description, Monitor monitor) {
        this.brand = brand;
        this.price = price;
        setPrice(price);
        this.description = description;
        this.monitor = monitor;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<1000||price>20000){
            price=2000;
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Computer{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", monitor=").append(monitor);
        sb.append('}');
        return sb.toString();
    }
}
