package exercises;

import org.testng.annotations.Test;

public class AboutMethods {

    @Test
    private void printProduct(){
        System.out.println(multiply(10, 10));
    }

    private int multiply(int a, int b) {
        return a * b;
    }
}
