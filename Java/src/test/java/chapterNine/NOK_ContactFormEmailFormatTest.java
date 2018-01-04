package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    String usernameCorrect = "nope@correct.nl";
    String usernameIncorrect = "nope";
    String orderReference = "4321234";
    String message = "Help!";
    String subjectHeading = "Customer service";

    @Test
    public void nokContactFormEmailFormat() {

        String logInButtonText = driver.findElement(By.className("login")).getText();
        Assertions.assertThat(logInButtonText).as("Sign in button seems to be absent.").isEqualToIgnoringCase("Sign in");

        HomePage homePage = new HomePage(driver);
        homePage.goToContactUsPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInUsername(usernameIncorrect);
        contactUsPage.selectSubjectHeading(subjectHeading);
        contactUsPage.fillInOrderReference(orderReference);
        contactUsPage.fillInMessage(message);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("form-error"))));
        Assertions.assertThat(By.className("form-error").findElement(driver).getText())
                .as("Form error is not meant for email address.").isEqualTo("Email address");
        System.out.println("Correct form error is found.");

        contactUsPage.fillInUsername(usernameCorrect);
        contactUsPage.fillInMessage(message);

        Assertions.assertThat(driver.findElement(By.className("form-ok")).getText())
                .as("Form ok is not meant for email address.").isEqualTo("Email address");
        System.out.println("Correct form ok is found.");

    }
}
