package others.demo.staticproxy;

public class RealSubject implements ISubject{
    public void request() {
        System.out.println("realSubject requesting");
    }
}
