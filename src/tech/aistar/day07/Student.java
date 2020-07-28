package tech.aistar.day07;

/**
 * 本类功能:学生 - 实体类
 *
 * 类是一个抽象的概念，类是构建对象的蓝图或者模板
 * 对象是具体的
 *
 * @author cxylk
 * @date 2020/7/27 11:04
 */
public class Student {
    //没有疯封装之前 - 所有的属性都是直接暴露给外界的，外界是允许直接操作[访问+修改]

    //属性属于全局变量
    //没有static修饰的属性 - 示例变量 - 对象变量 - 变量是属于对象

    //基本类型
    //public int id=1;

    public int id;

    //定义一个姓名
    //对象类型
    //public String name="tom"
    public String name;

    //public String [] hobbies={"打游戏","敲代码"};
    public String[] hobbies;

    //对象与对象之前是有关系的
    //假设 - 一个学生只能属于一个班级
    public Classes classes;//默认值是null
}
