package tech.aistar.day08.principles.dp.version03;

/**
 * 本类功能:中介
 *
 * @author cxylk
 * @date 2020/7/29 16:54
 */
public class Middler extends MiddlerSup{
    //中介找房地产公司了

    //中介和房源也解耦合了...
    private HouseSup houseSup;

    public Middler() {
    }

    public Middler(HouseSup houseSup){
        this.houseSup=houseSup;
    }

    public void find(String name){
        houseSup.desc(name);
    }
}
