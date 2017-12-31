package homework;

import chapterSix.TestShopScenario;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.MyWishListsPage;

public class DeleteWishListTest extends TestShopScenario{


    @Test
    public void deleteWishList(){

        // login to personal account
        HomePage homePage = new HomePage(driver);
        homePage.login("Roel@vandenAssem.com", "1qazxsw2");
        // go to my wish lists page
        MyAccountPage myAccountPage= new MyAccountPage(driver);
        myAccountPage.goToMyWishLists();
        // make new wish list
        MyWishListsPage myWishListsPage = new MyWishListsPage(driver);
        myWishListsPage.makeNewWishList("Feel the pain");
        // delete wishlist
        myWishListsPage.deleteWishList(driver);

    }
}
