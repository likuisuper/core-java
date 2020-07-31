package tech.aistar.design.template;

/**
 * 本类功能:
 *
 * @author cxylk
 * @date 2020/7/31 12:52
 */
public class TomKao extends PaperTemplate {
    @Override
    public String answer01() {
        return "A";
    }

    @Override
    public String answer02() {
        return "B";
    }
}

//假如这个是admin考生的答案
class AdminKao extends PaperTemplate{

    @Override
    public String answer01() {
        return "C";
    }

    @Override
    public String answer02() {
        return "D";
    }
}

class TestPaper{
    public static void main(String[] args) {
        PaperTemplate t1=new TomKao();
        t1.exam();

        System.out.println("============");

        PaperTemplate t2=new AdminKao();
        t2.exam();
    }
}
