package tech.aistar.day17.anno.extend;

import java.lang.annotation.*;

/**
 * 本类功能:让子类可以继承父类注解
 *
 * @author cxylk
 * @date 2020/8/19 19:56
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Select {
    String value();
}
