package tech.aistar.day07.exercise;

/**
 * 本类功能:妾
 *
 * @author cxylk
 * @date 2020/7/28 20:31
 */
public class Concubine {
    private int id;

    private String name;

    public Concubine() {
    }

    public Concubine(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Concubine{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
