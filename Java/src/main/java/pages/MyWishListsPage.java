package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyWishListsPage {

    private WebDriver driver;


    // @FindBy(css="input[id=email")
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "submitWishlist")
    private WebElement submitWishListButton;


    public MyWishListsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void makeNewWishList(String wishListName){
        nameField.sendKeys(wishListName);
        submitWishListButton.click();
    }

    public void deleteWishList(WebDriver driver){
            WebElement wishListsTable = driver.findElement(By.xpath("//*[@id='block-history']/table"));
            List<WebElement> rows = wishListsTable.findElements(By.tagName("tr"));
            List<WebElement> columns = wishListsTable.findElements(By.tagName("td"));
            List<String> value = new ArrayList<String>();

//            System.out.println(rows.size());
//
//            for (int j=0; j<columns.size(); j++){
//                System.out.println(columns.get(j).getText());
//                value.add(columns.get(j).getText());
//            }

//        List<WebElement> row = wishListsTable.findElements(By.xpath(".//tbody/tr"));
//        List<WebElement> column = row.get(row.indexOf(row)).findElements(By.xpath(".//td"));
//        column.get(index).getText().equals("Feel the pain");

        String wishListName = "Feel the pain";
        //First loop will find the name of the wish list in the first column
        for (int i=1;i<=rows.size();i++) {
            String firstColValue = null;
            firstColValue = driver.findElement(By.xpath(".//*[@id='block-history']/table/tbody/tr[1]/th[" + i + "]")).getText();
            if (firstColValue.equalsIgnoreCase(wishListName)) {

                // If the sValue match with the description, it will initiate one more inner loop for all the columns of 'i' row
                for (int j = 1; j <= 2; j++) {
                    String rowValue = driver.findElement(By.xpath(".//*[@id='block-history']/table/tbody/tr[" + j + "]/td[" + i + "]")).getText();
                    System.out.println(rowValue);
                }
                break;
            }
        }
    }
}
