package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_FillInContactFormTest extends TestShopScenario {

    String usernameOK = "nope@correct.nl";
    String usernameNOK = "nope";
    String orderReference = "4321234";
    String message = "Help!";
    String subjectHeading = "Customer service";

    @Test
    public void nokEmailFormat() {

        String logInButtonText = driver.findElement(By.className("login")).getText();
        Assertions.assertThat(logInButtonText).as("Sign in button seems to be absent.").isEqualToIgnoringCase("Sign in");

        HomePage homePage = new HomePage(driver);
        HomePage.goToContactUsPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInUsername(usernameNOK);
        contactUsPage.selectSubjectHeading(subjectHeading);
        contactUsPage.fillInOrderReference(orderReference);
        contactUsPage.fillInMessage(message);
        contactUsPage.submitForm();

        Assertions.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText())
                .as("Alert message is not correct.").isEqualTo("Invalid email address.");
        System.out.println("Correct alert message found.");

    }

}
