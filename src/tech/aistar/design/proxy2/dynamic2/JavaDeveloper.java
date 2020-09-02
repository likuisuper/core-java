package tech.aistar.design.proxy2.dynamic2;

/**
 * 本类功能:一个java程序员会开发java代码和调试java代码
 *
 * @author cxylk
 * @date 2020/9/2 18:56
 */
public class JavaDeveloper implements Developer{
    private String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println(this.name+" is coding java");
    }

    @Override
    public void debug() {
        System.out.println(this.name+" is debugging java");
    }
}
