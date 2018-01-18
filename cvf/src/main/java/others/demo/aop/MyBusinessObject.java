package others.demo.aop;

public class MyBusinessObject implements BusinessObject{

    public void businessMethod1() {
        // TODO Auto-generated method stub
        doSecurityCheck();
    }

    public void businessMethod2() {
        // TODO Auto-generated method stub
        doSecurityCheck();
    }

    public void requestNoSecurityCheck() {
        // TODO Auto-generated method stub
        
    }

    public void doSecurityCheck() {
        // TODO Auto-generated method stub
        
    }

}
