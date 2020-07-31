package tech.aistar.day10.all;

/**
 * 本类功能:总的父类 - 相声演员
 *
 * @author cxylk
 * @date 2020/7/31 15:56
 */
public class Player {
    //共同的特征
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
