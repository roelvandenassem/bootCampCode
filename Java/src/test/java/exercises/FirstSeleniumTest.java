package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String username = "roel.vandenassem@polteq.com";
    String password = "Bootcamp";
    String welcomeMessage = "Welcome to your account. Here you can manage all of your personal information and orders";

    @Test
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        // navigate to url, click on login button, fill out username and password field and click on submit login button.
        driver.get(url);
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        String pageHeaderText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(pageHeaderText).as("My Account page text is not correct.").isEqualToIgnoringCase("my account");
        driver.quit();
    }
}


// d

/*
    @BeforeTest
    public void logInSuccesFull() {
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        // navigate to url, click on login button, fill out username and password field and click on submit login button.
        driver.get(url);
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }

    @Test
    public void checkMyAccountPage() {
        // WebElement pageHeader = driver.findElement(By.className("page-heading"));
        String pageHeaderText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertThat(pageHeaderText).as("My Account page text is not correct.").isEqualToIgnoringCase("my account");
    }
 */