package tech.aistar.day09.crp;

/**
 * 本类功能:第二代机器人
 *
 * 合成/复用原则...
 *
 * 1.实现代码的复用性
 * 2.新的版本要扩展功能
 * 3.不要使用继承
 *
 * @author cxylk
 * @date 2020/7/29 20:37
 */
public class AIRoot {
    private Root root;

//    public void setRoot(Root root){
//        this.root=root;
//    }

    public AIRoot(){
        this.root=new Root();//聚合
    }

    public void test(){
        //复用之前版本的代码
        root.test();

        //扩展新版本的
        System.out.println("会按摩");
    }
}
