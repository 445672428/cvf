package others.demo.staticproxy;
public class ProxySubject implements ISubject{
    private RealSubject realSubject;
    public ProxySubject() {
        realSubject = new RealSubject();
    }
    public void request() {
        System.out.println("do something before");
        realSubject.request();
        System.out.println("do something after");
    }
}