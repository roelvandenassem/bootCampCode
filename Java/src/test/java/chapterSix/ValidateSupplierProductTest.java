package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void suppliersValidation() {
//    Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\'supplier_list\']")));
//    dropdown.selectByVisibleText("AppleStore");

    driver.get("https://techblog.polteq.com/testshop/index.php?id_supplier=1&controller=supplier");
    //List<WebElement> allProducts = driver.findElements(By.xpath("*//div[@class=\"product-container\"]"));
        List<WebElement> allProducts = driver.findElements(By.xpath("//a[@id=\"product_list\"]/li[1]/div/div[2]/h5/a"));
    for(int i = 0; i < allProducts.size(); i++)
    System.out.println(allProducts.get(i));

   // #product_list > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > h5 > a
        //*[@id="product_list"]/li[1]/div/div[2]/h5/a
   }

}
