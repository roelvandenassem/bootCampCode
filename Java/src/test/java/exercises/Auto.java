package exercises;

public class Auto {
    public void printBrand(String brand){
        System.out.println("Brand name is: " + brand);
    }

    public void printDoors(int doors){
        System.out.println("Number of doors is: " + doors);
    }

    public void printMotorType(String motorType){
        System.out.println("Motor type is: " + motorType);
    }

    public void calculateTorque(double force, double engineRPM){
        double torque = force * 5252 / engineRPM;
        System.out.println("Torque is: " + torque);
    }
}
