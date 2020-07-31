package tech.aistar.day10.all;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 15:57
 */
public class DouGen extends Player{
    //特殊的属性
    private int ha;//搞笑值

    public int getHa() {
        return ha;
    }

    public void setHa(int ha) {
        this.ha = ha;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DouGen{");
        sb.append("ha=").append(ha);
        sb.append('}');
        return sb.toString()+super.toString();
    }
}
