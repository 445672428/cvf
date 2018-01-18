package others.demo.Dynamicproxy;

//真实主题类，即被代理类  
class RealSubject implements AbstractSubject {  
 public void request() {  
     System.out.println("RealSubject's request() ...");  
 }  
}  
