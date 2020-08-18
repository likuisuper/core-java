package tech.aistar.day17.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 本类功能:自定义注解
 *
 * @author cxylk
 * @date 2020/8/18 21:14
 */
@Target({TYPE,METHOD,FIELD})//该注解可以被应用在类型或者方法上
@Retention(RetentionPolicy.RUNTIME)//注解的保留策略 - 才可以在程序的运行期间来拿到注解的信息
public @interface MyAnno {

    //注解中只有属性的概念，默认的是value名称
    //String value1();

    //String name;

    String[] value();
}
