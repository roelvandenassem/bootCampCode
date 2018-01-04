package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class AdjustPersonalInfoTest extends TestShopScenario {

    String username = "roel.vandenassem@polteq.com";
    String password = "Bootcamp";

    @Test
    public void adjustPersonalInfo() {
        if (driver.findElement(By.className("login")).isDisplayed());
        {
            HomePage homePage = new HomePage(driver);
            HomePage.goTologInPage();
            LogInPage logInPage = new LogInPage(driver);
            logInPage.fillInUsername(username);
            logInPage.fillInPassword(password);
            logInPage.submitLogIn();
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
        }
        else {
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).clear();
            driver.findElement(By.xpath("//input[@name=\'firstname\']")).sendKeys("Roel");
            driver.findElement(By.xpath("//input[@id=\"old_passwd\"]")).sendKeys(password);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@name=\'submitIdentity\']")))).click();
        }

    }
}
