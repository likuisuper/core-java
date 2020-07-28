package tech.aistar.day08.relation.onetoone;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:20
 */
public class Husband {
    private int id;

    private String name;

    //在丈夫的实体类中维护了一个单个妻子对象
    private Wife wife;

    public Husband() {
    }

    public Husband(int id, String name, Wife wife) {
        this.id = id;
        this.name = name;
        this.wife = wife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Husband{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
