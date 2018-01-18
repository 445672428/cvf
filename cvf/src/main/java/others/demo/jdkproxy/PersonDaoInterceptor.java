package others.demo.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInterceptor implements InvocationHandler {
    private Object target;

    private Transaction transaction;

    public PersonDaoInterceptor(Object target,Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        if (method.getName().equals("savePerson") || method.getName().equals("updatePerson")) {
            this.transaction.beginTransaction();
            method.invoke(target, args);// 目标对象调用方法
            this.transaction.commit();
        } else {
            method.invoke(target, args);
        }
        return null;
    }

}
