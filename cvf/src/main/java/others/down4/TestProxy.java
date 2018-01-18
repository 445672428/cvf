package others.down4;


/**
 * Created by wjg on 2017/9/11.
 */
public class TestProxy {

    public static void main(String[] args){
        final ProxyPool proxyPool = new ProxyPool();
        for(int i=0;i<10;i++){
            proxyPool.addProxy(new Proxy(Integer.toString(i),i));
        }
        new Thread(new Runnable() {
            public void run() {
                System.out.println(proxyPool.getProxy().toJson());
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(proxyPool.getProxy().toJson());
            }
        }).start();

    }
}
