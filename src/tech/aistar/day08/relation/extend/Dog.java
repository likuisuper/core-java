package tech.aistar.day08.relation.extend;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/28 15:27
 */
public class Dog extends Animal{
    //子类中存放自己独有的属性
    private double loyalty;//忠诚度

    public Dog(){
        //在子类中任何一个构造方法中，系统都会默认分配一个super();
        //前提：子类中的构造中没有手动提供任何一个super([参数列表])

        //super();//调用父类已经存在的空参构造

        System.out.println("Dog()空参构造被调用了...");
    }

    public double getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(double loyalty) {
        this.loyalty = loyalty;
    }

    //子类中可以顶一个自己独有的方法
    public void watchDoor(){
        System.out.println(getName()+"会看门");
    }

    //重写父类的toString方法，super代表强制使用(因为方法名与父类中的重复了)
    @Override
    public String toString(){
        return super.toString()+",loyalty:"+loyalty;
    }

    @Override
    public void spark(){
        System.out.println("汪汪~~~");
    }
}
