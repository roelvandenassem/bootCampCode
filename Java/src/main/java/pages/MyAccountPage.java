package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {


        public WebDriver driver;

        @FindBy(className = "lnk_wishlist")
        private static WebElement wishListButton;


        public MyAccountPage(WebDriver driver) {
            this.driver = driver;

            PageFactory.initElements(driver, this);
        }

        public static void goToMyWishListsPage() {
            wishListButton.click();
        }
}
