package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;


public class LogInTest extends TestShopScenario {

    String usernameOK = "bootcamper@feelthepain.com";
    String passwordOK = "1qazxsw2";

    @Test
    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        String logOutPageText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(logOutPageText).as("My log out page text is not correct.").isEqualToIgnoringCase("authentication");

        homePage.goTologInPage();
        System.out.println("There is no user logged in.");

        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillInUsername(usernameOK);
        logInPage.fillInPassword(passwordOK);

        String pageHeaderText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(pageHeaderText).as("My Account page text is not correct.").isEqualToIgnoringCase("my account");
        System.out.println("Succesful login for user " + usernameOK);
    }
}
