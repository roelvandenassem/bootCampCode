package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {


    public static WebDriver driver;

    @FindBy(className = "login")
    private static WebElement signInButton;

    @FindBy(id = "contact-link")
    private static WebElement contactUsButton;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    public static void goTologInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("login")));
        signInButton.click();

    }

    public static void goToContactUsPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("contact-link")));
        contactUsButton.click();
    }
}
