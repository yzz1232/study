package yzz.study.annoation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Redis {
	
	int expire() default  60;
	
	TimeUnit unit() default TimeUnit.MILLISECONDS;
	
	String type();
}
