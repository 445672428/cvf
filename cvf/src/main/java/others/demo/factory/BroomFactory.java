package others.demo.factory;

public class BroomFactory extends VehicleFactory{
    public Moveable create() {
        return new Broom();
    }
}