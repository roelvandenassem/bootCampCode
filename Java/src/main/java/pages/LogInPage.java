package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage {

    public WebDriver driver;

    @FindBy(id = "email")
    private static WebElement emailField;

    @FindBy(id = "passwd")
    private static WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private static WebElement submitLoginButton;

    public LogInPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
}

    public static void login(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }
}
