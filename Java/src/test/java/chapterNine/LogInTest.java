package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

@Test
public class LogInTest extends TestShopScenario {

    String username = "bootcamper@feelthepain.com";
    String password = "1qazxsw2";

    public void loginTest() {

        HomePage homePage = new HomePage(driver);
        HomePage.goTologInPage();
        String logOutPageText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(logOutPageText).as("My log out page text is not correct.").isEqualToIgnoringCase("authentication");
        System.out.println("There is no user logged in.");
        LogInPage logInPage = new LogInPage(driver);
        LogInPage.login(username, password);
        String pageHeaderText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(pageHeaderText).as("My Account page text is not correct.").isEqualToIgnoringCase("my account");
        System.out.println("Succesful login for user " + username);
    }
}
