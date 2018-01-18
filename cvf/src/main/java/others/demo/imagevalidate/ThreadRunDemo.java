package others.demo.imagevalidate;

public class ThreadRunDemo implements Runnable{
    private String name;
    public ThreadRunDemo(String name) {
        this.name = name;
    }
    public void run() {
        // TODO Auto-generated method stub
        for(int i= 0; i < 100;i++){
            System.out.println(this.name+"正在运行:"+i);
            try {
                Thread.sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
