package others.demo.imagevalidate;
//java中sleep和wait的区别  sleep是Thread类中的 而wait方法属于object类中
//sleep方法执行不会释放对象锁 当执行wait方法的时候线程会放弃对象锁进入等待此对象的等待锁定池
public class ThreadDemo extends Thread{
    private String name;
    public ThreadDemo(String name) {
        this.name = name;
    }
    public void run() {
        for(int i = 0; i < 1000;i++){
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
