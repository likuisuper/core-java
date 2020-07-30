package tech.aistar.day08.principles.dp.version02;

/**
 * 本类功能:中介
 *
 * @author cxylk
 * @date 2020/7/29 15:42
 */
public class Middler {
    //中介找房源
    private House house;

    public void setHouse(House house){
        this.house=house;
    }

    public void find(String name){
        house.desc(name);
    }
}
