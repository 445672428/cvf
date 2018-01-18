package others.demo.listener;

public class MyPersonListener implements PersonListener{

    public void dorun(Even even) {
        // TODO Auto-generated method stub
        Person person = even.getPerson();
        person.eat();
    }

    public void doeat(Even even) {
        // TODO Auto-generated method stub
        Person person = even.getPerson();
        person.eat();
    }

}
