package others.demo.staticproxy;

public class Test {
    public static void main(String[] args) {
        ISubject proxySubject = new ProxySubject();
        proxySubject.request();
    }
}