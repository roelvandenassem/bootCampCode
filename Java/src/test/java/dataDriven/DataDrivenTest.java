package dataDriven;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class DataDrivenTest extends TestShopScenario {

    String username = "bootcamper@feelthepain.com";
    String orderReference = "4321234";
    String message = "Ipod defect while lifting, need new one";

    @Parameters({"subject", "email", "orderID", "message"})
    @Test
    public void fillInContactForm(String subject, String email, String orderID, String message){

        driver.findElement(By.cssSelector("a[title=contact]")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.selectSubjectHeading(subject);
        contactUsPage.fillInMessage(message);
        contactUsPage.fillInUsername(email);
        contactUsPage.fillInOrderReference(orderID);
        contactUsPage.submitForm();

        Assertions.assertThat(driver.findElement(By.className("alert-success")).getText())
                .as("Alert message is not correct.").isEqualTo("Your message has been successfully sent to our team.");

    }
}
