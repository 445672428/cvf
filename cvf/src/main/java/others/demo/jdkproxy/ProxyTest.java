package others.demo.jdkproxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public void test() {
        Object target = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        PersonDaoInterceptor interceptor = new PersonDaoInterceptor(target, transaction);
        PersonDao personDao = (PersonDao) Proxy.newProxyInstance(target.getClass().getClassLoader(), target
                .getClass().getInterfaces(), interceptor);
        personDao.updatePerson();
    }
}
