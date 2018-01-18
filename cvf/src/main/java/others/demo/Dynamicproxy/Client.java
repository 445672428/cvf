package others.demo.Dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

//测试类  
public class Client {  
 public static void main(String[] args) {  

     // 被代理类的实例  
     AbstractSubject realSubject = new RealSubject();  

     // 获得被代理类的类加载器，使得JVM能够加载并找到被代理类的内部结构，以及已实现的interface  
     ClassLoader loader = realSubject.getClass().getClassLoader();  

     // 获得被代理类已实现的所有接口interface,使得动态代理类的实例  
     Class<?>[] interfaces = realSubject.getClass().getInterfaces();  

     // 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序  
     InvocationHandler handler = new DynamicProxy(realSubject);  

     /*  
      * loader : 被代理类的类加载器  
      * interfaces ：被代理类已实现的所有接口，而这些是动态代理类要实现的接口列表  
      * handler ： 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序  
      *   
      * return ：返回实现了被代理类所实现的所有接口的Object对象，即动态代理，需要强制转型  
      */ 
     //获得代理的实例  
     AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(  
             loader, interfaces, handler);  

     proxy.request();  
     //打印出该代理实例的名称  
     System.out.println(proxy.getClass().getName());  
 }  
} 