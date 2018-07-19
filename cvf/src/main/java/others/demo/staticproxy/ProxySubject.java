package others.demo.staticproxy;
public class ProxySubject implements ISubject{
    private RealSubject realSubject;
    public ProxySubject() {
        realSubject = new RealSubject();
    }
    public void request() {
        realSubject.request();
    }
}