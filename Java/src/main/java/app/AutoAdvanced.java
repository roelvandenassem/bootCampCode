package app;

public class AutoAdvanced {

    //global variable, niet overschrijfbaar buiten class, overal bruibaar zonder per methode toe te voegen.
    private String brand;
    private double rpm;
    private double force;


    public AutoAdvanced(String brand) {
        this.brand = brand;
        this.rpm = rpm;
        this.force = force;
    }

    public void printBrand() {
        System.out.println("Car brand is: " + brand);
    }

    public void calculateTorque() {
        double torque = force * 5252 / rpm;
        System.out.println("Torque is: " + torque);
    }
}
