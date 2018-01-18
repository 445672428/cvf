package others.demo.annotation;

import java.lang.reflect.Method;

public class AnnotationParse {
    public static void beginParse() {
        Class clazz = Annotation.class;
        if (clazz.isAnnotationPresent(ClassInfo.class)) {
            //从改类上面获取注解
            ClassInfo classInfo = (ClassInfo)clazz.getAnnotation(ClassInfo.class);
            System.out.println(classInfo.name());
        }
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println(methodInfo.value());
            }
        }
    }
}
