package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class NOK_LogInTest extends TestShopScenario{

    String usernameOK = "bootcamper@feelthepain.com";
    String usernameNOK = "nope";
    String passwordOK = "1qazxsw2";
    String passwordNOK = "1234";

    HomePage homePage = new HomePage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void usernameFormatNOK(){

        homePage.goTologInPage();
        String logOutPageText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(logOutPageText).as("My log out page text is not correct.").isEqualToIgnoringCase("authentication");

        homePage.goTologInPage();
        System.out.println("There is no user logged in.");

        logInPage.fillInUsername(usernameNOK);
        logInPage.fillInPassword(passwordOK);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("form-error"))));
        Assertions.assertThat(By.className("form-error").findElement(driver).getText())
                .as("Form error is not meant for email address.").isEqualTo("Email address");
        System.out.println("Correct form error is found.");

    }

    @Test
    public void passwordFormatNOK(){

        homePage.goTologInPage();
        String logOutPageText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(logOutPageText).as("My log out page text is not correct.").isEqualToIgnoringCase("authentication");

        homePage.goTologInPage();
        System.out.println("There is no user logged in.");

        logInPage.fillInUsername(usernameOK);
        logInPage.fillInPassword(passwordNOK);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("form-error"))));
        Assertions.assertThat(By.className("form-error").findElement(driver).getText())
                .as("Form error is not meant for email address.").isEqualTo("Password");
        System.out.println("Correct form error is found.");

    }

}
