package tech.aistar.day11;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/8/3 18:44
 */
public class BookInfo {
    private int id;

    private String remark;

    public BookInfo() {
    }

    public BookInfo(int id, String remark) {
        this.id = id;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookInfo{");
        sb.append("id=").append(id);
        sb.append(", remark='").append(remark).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
