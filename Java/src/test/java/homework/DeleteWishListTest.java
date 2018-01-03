package homework;

import chapterSix.TestShopScenario;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import pages.MyAccountPage;
import pages.MyWishListsPage;

public class DeleteWishListTest extends TestShopScenario{


    @Test
    public void deleteWishList(){

        String oldWishListName = "Feel the pain";
        String newWishListName = "Feel the pain";
        String username = "Roel@vandenAssem.com";
        String password = "1qazxsw2";


        // login to personal account
        HomePage homePage = new HomePage(driver);
        HomePage.goTologInPage();
        LogInPage logInPage = new LogInPage(driver);
        LogInPage.login(username, password);

        // go to my wish lists page
        MyAccountPage myAccountPage= new MyAccountPage(driver);
        MyAccountPage.goToMyWishListsPage();

        // make new wish list
        MyWishListsPage myWishListsPage = new MyWishListsPage(driver);
        myWishListsPage.makeNewWishList(newWishListName);

        // delete wish list
        myWishListsPage.deleteWishList(driver, oldWishListName);

        // check if old wish list is deleted


        // check if new wish list is added


    }
}
