package h12;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, TYPE, METHOD})
@Retention(RUNTIME)
@Documented
@Inherited
public @interface Author {
    String value() default "";
    int level() default 0;
}