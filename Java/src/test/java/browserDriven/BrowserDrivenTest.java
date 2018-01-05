package browserDriven;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven{

    String username = "bootcamper@feelthepain.com";
    String orderReference = "4321234";
    String message = "Ipod defect while lifting, need new one";

    @Test
    public void fillInContactForm(){

        driver.findElement(By.cssSelector("a[title=contact]")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.selectSubjectHeading("Customer service");
        contactUsPage.fillInMessage(message);
        contactUsPage.fillInUsername(username);
        contactUsPage.fillInOrderReference(orderReference);
        contactUsPage.submitForm();

        Assertions.assertThat(driver.findElement(By.className("alert-success")).getText())
                .as("Alert message is not correct.").isEqualTo("Your message has been successfully sent to our team.");

    }
}
