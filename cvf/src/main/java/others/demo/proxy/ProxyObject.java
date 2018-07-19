package others.demo.proxy;
//代理对象角色
public class ProxyObject extends AbstractObject{
    RealObject realObject = new RealObject();
    @Override
    public void operation() {
        //调用目标对象之前可以做相关操作
        realObject.operation();        
        //调用目标对象之后可以做相关操作
    }
}
