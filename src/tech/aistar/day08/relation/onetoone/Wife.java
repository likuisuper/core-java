package tech.aistar.day08.relation.onetoone;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 18:20
 */
public class Wife {
    private int id;

    private String name;

    //一个妻子维护了一个丈夫类对象
    private Husband husband;

    public Wife() {
    }

    public Wife(int id, String name, Husband husband) {
        this.id = id;
        this.name = name;
        this.husband = husband;
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

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wife{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
