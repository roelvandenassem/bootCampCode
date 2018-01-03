package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyWishListsPage {

    private WebDriver driver;

    @FindBy(id = "block-history")
    private  WebElement wishListsTable;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "submitWishlist")
    private WebElement submitWishListButton;


    public MyWishListsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    public void makeNewWishList(String newWishListName) {
        nameField.sendKeys(newWishListName);
        submitWishListButton.click();
        driver.navigate().refresh();
    }

//    public int getRowsSize(){
//
//        //Make a list of the table rows to get the number of rows/rows.size
//        List<WebElement> rows = wishListsTable.findElements(By.tagName("tr"));
//        return rows.size();
//    }
//
//    public int getOldWishListRow(){
//
//        //Make a list of the table rows to get the number of rows/rows.size
//        List<WebElement> rows = wishListsTable.findElements(By.tagName("tr"));
//        return OldWishListRow;
//    }

    public void deleteWishList(WebDriver driver, String oldWishListName) {

        //Make a list of the table rows to get the number of rows/rows.size
        List<WebElement> rows = wishListsTable.findElements(By.tagName("tr"));
        System.out.println("Number of rows in this table = " + rows.size());

        //Iterate rows to get column.size and the content of each column in the row
        for (int row = 0; row < rows.size(); row++) {
            List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
            String rowContent = rows.get(row).getText();
            System.out.println(rowContent);

            //Find the correct row containing the name of the old wish list
            if (rowContent.contains(oldWishListName)) {
                //Iterate columns for this particular row that contains the name of the old wish list
                for (int column = 0; column < columns.size(); column++) {
                    //Get the class of each column so we can search for the column with the delete button next
                    String columnContent = columns.get(column).getAttribute("class");
                    //Find the correct column containing the delete button and click on it
                    if (columnContent.equals("wishlist_delete")) {
                        WebElement wishListDeleteButton = columns.get(column).findElement(By.className("icon-remove"));
                        wishListDeleteButton.click();
                        driver.switchTo().alert().accept();
                        System.out.println("Deleting wish list " + "'" + oldWishListName + "'");
                    }
                }
                break;
            }
        }
    }
}