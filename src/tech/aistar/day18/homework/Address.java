package tech.aistar.day18.homework;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/19 21:21
 */
public class Address {
    private String province;
    private String city;

    public Address() {
//        this.province = province;
    }

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Adress{");
        sb.append("province='").append(province).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
