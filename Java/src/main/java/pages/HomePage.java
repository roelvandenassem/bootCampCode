package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


    public WebDriver driver;

    @FindBy(className = "login")
    private static WebElement signInButton;

    @FindBy(id = "email")
    private static WebElement emailField;

    @FindBy(id = "passwd")
    private static WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private static WebElement submitLoginButton;



    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public static void login(String username, String password) {
        signInButton.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }
}
