package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillInContactFormTest extends TestShopScenario{

    String email = "bootcamper@feelthepain.com";
    String orderReference = "4321234";
    String message = "Ipod defect while lifting, need new one";

    @Test
    public void fillInContactForm(){

        driver.findElement(By.cssSelector("a[title=contact]")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.submitForm(email, orderReference, message);
        Assertions.assertThat(driver.findElement(By.className("alert-success")).getText())
                .as("Alert message is not correct.").isEqualTo("Your message has been successfully sent to our team.");

    }
}
