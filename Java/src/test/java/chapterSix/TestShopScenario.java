package chapterSix;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    String url = "https://techblog.polteq.com/testshop/index.php";
    String password = "Bootcamp";
    String username = "roel.vandenassem@polteq.com";

    public WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod (alwaysRun = true)
    public void setUp(){

        driver = BrowserFactory.getDriver("chrome");
        // Maximize window
        driver.manage().window().maximize();
        // Open the website
        driver.get(url);
        wait = new WebDriverWait(driver, 15, 50);
    }

    @AfterMethod
    public void tearDown(){
        // Quit driver
       // driver.quit();
    }

    public void login() {
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
    }

}
