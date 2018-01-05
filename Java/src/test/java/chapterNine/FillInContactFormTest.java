package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillInContactFormTest extends TestShopScenario{

    @Test
    public void fillInContactForm(){

        driver.findElement(By.cssSelector("a[title=contact]")).click();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.submitForm("bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one");
        Assertions.assertThat(driver.findElement(By.className("alert-success")).getText())
                .as("Alert message is not correct.").isEqualTo("Your message has been successfully sent to our team.");
    }
}
