package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver driver;


    // @FindBy(css="input[id=email")
    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="id_order")
    private WebElement orderReferenceField;

    @FindBy(id="message")
    private WebElement messageField;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

    @FindBy(xpath=("//p[contains(@class, \"alert\")"])
    private WebElement alertMessageText;

//    @FindBy(id="id_contact")
//    private WebElement idContactDropdown;


    public ContactUsPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void submitForm(String email, String orderReference, String message){
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);
        submitButton.click();

    }

    public String getAlertMessage(){
        return alertMessageText.getText();
    }

}
