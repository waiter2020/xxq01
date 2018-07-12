package utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by  waiter on 18-7-12  上午11:24.
 *
 * @author waiter
 * 因为要统计部门总人数，所以写了这个
 * 标注在int型属性上，bean为要统计的表的实体类，name为要统计的字段，其值应等于标有此注解的第一个属性并且为int型
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Count {
    String name() ;
    Class bean();
}
