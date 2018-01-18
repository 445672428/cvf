package others.demo.imagevalidate;
//java多线程中run方法和start方法的区别 start方法是真正的启动线程来运行  不需要等到run方法体代码执行完毕而直接继续执行下面的代码
//run方法只是一个普通的方法程序中依然只有一条只线程
public class RunThreadDemo {
    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("线程一");
        ThreadDemo threadDemo2 = new ThreadDemo("线程二");
        ThreadDemo threadDemo3 = new ThreadDemo("线程三");
        ThreadDemo threadDemo4 = new ThreadDemo("线程四");
        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();
        threadDemo4.start();
        
        ThreadRunDemo runDemo1 = new ThreadRunDemo("run1");
        ThreadRunDemo runDemo2 = new ThreadRunDemo("run2");
        ThreadRunDemo runDemo3 = new ThreadRunDemo("run3");
        
        //thread和runnable的区别  继承thread不适合资源共享实现runnable容易实现资源共享
        //优点适合多个相同的程序代码线程去处理同一个资源 可以避免java中的单继承的限制 增加 程序的健壮性代码可以被多个线程共享
        
        //sleep和yield区别 sleep当线程进入停滞状态sleep所在的线程全部进入停滞状态  而 yield方法有权让当前线程让出cup的占有权
        //obj.wait()与obj.notify必须要与synchronized(obj)一起使用  相对应的notify()是对对象锁的唤醒操作
        
    }
}
