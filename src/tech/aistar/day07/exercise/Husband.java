package tech.aistar.day07.exercise;


import java.util.Arrays;


/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 20:33
 */
public class Husband {
    private int id;

    private String name;

    private Wife wife;

    //一个丈夫对应多个妾
    private Concubine[] concubines;

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

    public Concubine[] getConcubines() {
        return concubines;
    }

    public void setConcubines(Concubine[] concubines) {
        this.concubines = concubines;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Husband{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", wife=").append(wife);
        sb.append(", concubines=").append(Arrays.toString(concubines));
        sb.append('}');
        return sb.toString();
    }
}
