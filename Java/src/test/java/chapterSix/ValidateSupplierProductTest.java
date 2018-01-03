package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario {

    @Test
    public void suppliersValidation() {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name=\'supplier_list\']")));
        dropdown.selectByVisibleText("AppleStore");

        List<WebElement> allProducts = driver.findElements(By.cssSelector("[class=\'product-name\']"));
        boolean productPresent = false;
        for (WebElement products : allProducts) {
            String contents = products.getText();
            System.out.println(contents);
            if (contents.contains("MacBook Air")) {
                productPresent = true;
            } break;
        }
        Assertions.assertThat(productPresent).as("Product not found.").isTrue();
    }
}