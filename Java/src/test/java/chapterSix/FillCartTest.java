package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class FillCartTest extends TestShopScenario{

    protected WebDriver driver;

        @Test
        public void CartValidation() {
//            WebDriver driver=navigateToUrl();
//            WebDriverWait wait = new WebDriverWait(driver, 15, 50);
            driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
            driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
            driver.findElement(By.xpath("//a[@title=\'iPod shuffle\']")).click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(.,'Add to cart')]"))));
            driver.findElement(By.xpath("//button[contains(.,'Add to cart')]")).click();
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'Continue shopping')]"))));
            driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
            String productInCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div/a/span[1]")).getText();
            Assertions.assertThat(productInCart).as("My shopping cart is empty.").isEqualToIgnoringCase("1");

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
