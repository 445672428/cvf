package others.demo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SecurityInterceptor implements MethodInterceptor{

    public Object invoke(MethodInvocation invocation) throws Throwable {
        doSecurityCheck();
        return invocation.proceed();
    }
    public void doSecurityCheck() {
        
    }
}
