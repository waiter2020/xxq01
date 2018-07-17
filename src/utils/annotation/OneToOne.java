package utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by  waiter on 18-7-11  下午8:06.
 *
 * @author waiter
 * <p>
 * 因为各表直接关系太多，所以做了这个注解
 * 标注在。。。在，，我无法描述，反正就是实体类的字段上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OneToOne {
    String name() default "";

    Class bean();
}
