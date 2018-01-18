package others.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解分为三种 
/*
 * RetentionPolicy.SOURCE 该只能放在源码上面
 * RetentionPolicy.Class  使用源码和字节码上面
 * RetentionPolicy.RUNTIME 使用在源代码和字节码和jvm中
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented  //改注解能够出现在帮助文档当中
public @interface ClassInfo {
    String name() default "";
}
