package exercises;

import app.AutoAdvanced;
import org.testng.annotations.Test;

public class CarGame {

    @Test
    public void checkCar(){
        Auto auto = new Auto();
        auto.printBrand("Volvo");
        auto.printDoors(5);
        auto.printMotorType("D5");
        auto.calculateTorque(3, 1);
    }

    @Test
    public void checkBetterCar(){
        AutoAdvanced autoAdvanced = new AutoAdvanced("Tesla");
        autoAdvanced.printBrand();
    }
}
