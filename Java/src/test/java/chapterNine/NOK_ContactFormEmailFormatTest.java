package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    String username = "nope@correct.nl";
    String email = "nope";
    String orderReference = "4321234";
    String message = "Help!";

    @Test
    public void nokContactFormEmailFormat() {

        String logInButtonText = driver.findElement(By.className("login")).getText();
        Assertions.assertThat(logInButtonText).as("Sign in button seems to be absent.").isEqualToIgnoringCase("Sign in");

        HomePage homePage = new HomePage(driver);
        homePage.goToContactUsPage();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.fillInFormWithoutSubmitting(email, orderReference, message);

        Assertions.assertThat(driver.findElement(By.className("form-error")).getText())
                .as("Form error is not meant for email address.").isEqualTo("Email address");
        System.out.println("Correct form error is found.");

        contactUsPage.fillInCorrectEmail(username, message);

        Assertions.assertThat(driver.findElement(By.className("form-ok")).getText())
                .as("Form ok is not meant for email address.").isEqualTo("Email address");
        System.out.println("Correct form ok is found.");

    }
}
