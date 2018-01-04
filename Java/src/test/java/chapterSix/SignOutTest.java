package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LogInPage;

public class SignOutTest {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String username = "roel.vandenassem@polteq.com";
    String password = "Bootcamp";
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

//    @Test
//    public void logOutSuccesful() {
//        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();
//        // navigate to url, click on login button, fill out username and password field and click on submit login button.
//        driver.manage().window().maximize();
//        driver.get(url);
//        // login
//        driver.findElement(By.className("login")).click();
//        driver.findElement(By.id("email")).sendKeys(username);
//        driver.findElement(By.id("passwd")).sendKeys(password);
//        driver.findElement(By.id("SubmitLogin")).click();
//        // store page header text in string and assert it is right
//        String pageHeaderText = driver.findElement(By.className("page-heading")).getText();
//        Assertions.assertThat(pageHeaderText).as("My Account page text is not correct.").isEqualToIgnoringCase("my account");
//        // store welcome message text in string and assert it is right
//        String welcomeMessageText = driver.findElement(By.className("info-account")).getText();
//        Assertions.assertThat(welcomeMessageText).as("My welcome message text is not correct.").isEqualToIgnoringCase(welcomeMessage);
//        driver.findElement(By.className("logout")).click();
//        String logOutPageText = driver.findElement(By.className("page-heading")).getText();
//        Assertions.assertThat(logOutPageText).as("My log out page text is not correct.").isEqualToIgnoringCase("authentication");
//        // driver.quit();
//    }

    @Test
    public void logOutSuccesful() {
        WebDriver driver = navigateToUrl();
        LogInPage.fillInUsername("Roel@vandenAssem.com");
        LogInPage.fillInPassword("1qazxsw2");
        String userInfoTextLogIn = driver.findElement(By.className("header_user_info")).getText();
        Assertions.assertThat(userInfoTextLogIn).as("I'm not logged in.").isNotEqualToIgnoringCase("sign out");
        driver.findElement(By.className("logout")).click();
        String userInfoTextLogOut = driver.findElement(By.className("header_user_info")).getText();
        Assertions.assertThat(userInfoTextLogOut).as("I'm not logged out.").isEqualToIgnoringCase("sign in");
        driver.quit();
    }

    private WebDriver navigateToUrl() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    private void login(WebDriver driver) {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

}