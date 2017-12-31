package exercises;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Controles {

    @Test
    public void assertIntegerEqualTo(){
        int testInt = 10;
        System.out.println(testInt);
        Assertions.assertThat(testInt).as("testInt is not equal to 10").isEqualTo(10);
    }

    @Test
    public void assertStringIs() {
        String testString = "Hallo";
        Assertions.assertThat(testString).as("String is not 'Hello'").isEqualTo("Hello");
    }

    @Test
    public void assertStringIsNotEmpty() {
        String testString = "";
        Assertions.assertThat(testString).as("String is not present").isNotBlank();
    }
}
