package tech.aistar.day07;

/**
 * 本类功能:班级实体类
 *
 * @author cxylk
 * @date 2020/7/27 11:02
 */
public class Classes {
    public int id;

    public int capacity;//容量

    public Classes() {
    }

    public Classes(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
