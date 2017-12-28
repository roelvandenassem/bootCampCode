package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        // Maximise window
        driver.manage().window().maximize();
        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");
        wait = new WebDriverWait(driver, 15, 50);
    }

    @AfterMethod
    public void tearDown(){
        // Quit driver
       // driver.quit();
    }
}
