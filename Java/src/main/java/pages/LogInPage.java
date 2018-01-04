package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage {

    public WebDriver driver;

    @FindBy(id = "email")
    private static WebElement usernameField;

    @FindBy(id = "passwd")
    private static WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private static WebElement submitLoginButton;

    public LogInPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    public static void fillInUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        usernameField.sendKeys(Keys.TAB);
    }

    public static void fillInPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.TAB);
    }

    public static void submitLogIn() {
        submitLoginButton.click();
    }


}
