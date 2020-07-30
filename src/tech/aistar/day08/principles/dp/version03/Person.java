package tech.aistar.day08.principles.dp.version03;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/29 16:55
 */
public class Person {
    //1.为了降低人和中介之间的耦合
    //人 应该 和中介公司进行交互了

    private MiddlerSup middlerSup;

    public void setMiddlerSup(MiddlerSup middlerSup) {
        this.middlerSup = middlerSup;
    }

    public void buy(String name){
        middlerSup.find(name);
    }
}
