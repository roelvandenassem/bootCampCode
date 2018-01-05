package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private WebDriver driver;


    // @FindBy(css="input[id=email")
    @FindBy(id = "email")
    private WebElement usernameField;

    @FindBy(id = "id_order")
    private WebElement orderReferenceField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

//    @FindBy(id="id_contact")
//    private WebElement subjectHeading;

    //    private WebElement alertMessageText;
    //    @FindBy(xpath=("//p[contains(@class, \"alert\")"])



    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clearFields(){
        usernameField.clear();
        messageField.clear();
        orderReferenceField.clear();
    }

    public void fillInUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void fillInMessage(String message){
        messageField.clear();
        messageField.sendKeys(message);
    }

    public void fillInOrderReference(String orderReference){
        orderReferenceField.clear();
        orderReferenceField.sendKeys(orderReference);
    }

    public void submitForm(){
        submitButton.click();
    }

    public void selectSubjectHeading(String subjectHeading){
        Select subject = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subject.selectByVisibleText(subjectHeading);
    }

}
