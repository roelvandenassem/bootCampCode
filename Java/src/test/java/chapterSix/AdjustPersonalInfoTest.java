package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AdjustPersonalInfoTest extends TestShopScenario {

    @Test
    public void adjustPersonalInfo() {
        if (driver.findElement(By.className("login")).isDisplayed()) ;
        {
            login();
            driver.findElement(By.className("icon-user")).click();
        }
        //else{
          //  driver.findElement(By.className("icon-user")).click();
       // }
        String firstName = driver.findElement(By.xpath("//input[@name=\'firstname\']")).getAttribute("value");
//        Assertions.assertThat(firstName).as("First name is not correct.").isEqualTo("Roel");
        if (firstName.equals("Roel")){
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).clear();
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("RoelTwee");
            driver.findElement(By.xpath("//input[@id=\"old_passwd\"]")).sendKeys(password);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name=\'submitIdentity\']")))).click();
            String firstName2 = driver.findElement(By.xpath("//input[@name=\'firstname\']")).getText();
            Assertions.assertThat(firstName2).as("First name 2 is not correct.").isEqualTo("RoelTwee");
        }
        else {
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).clear();
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("Roel");
            driver.findElement(By.xpath("//input[@id=\"old_passwd\"]")).sendKeys(password);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name=\'submitIdentity\']")))).click();
            Assertions.assertThat(firstName).as("First name is not correct.").isEqualTo("Roel");
        }

    }
}
