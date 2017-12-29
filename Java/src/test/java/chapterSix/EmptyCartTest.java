package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EmptyCartTest extends TestShopScenario {

    @Test
    public void EmptyCart(){
        driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();
        driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
        driver.findElement(By.xpath("//a[@title=\'iPod shuffle\']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[contains(.,'Add to cart')]"))));
        driver.findElement(By.xpath("//button[contains(.,'Add to cart')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(.,'Continue shopping')]"))));
        driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();
        String productInCart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[3]/div/a/span[1]")).getText();
        Assertions.assertThat(productInCart).as("My shopping cart is empty.").isEqualToIgnoringCase("1");
        driver.findElement(By.xpath("//a[@title=\'View my shopping cart\']")).click();
//        driver.findElement(By.className("icon-trash")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("remove_link")))).click();
        driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();

//        Actions actions = new Actions(driver);
//        WebElement viewShoppingCart = driver.findElement(By.xpath("//a[@title=\'View my shopping cart\']"));
//        actions.moveToElement(viewShoppingCart);
//        WebElement deleteItems = driver.findElement(By.className("ajax_cart_block_remove_link"));
//        actions.moveToElement(deleteItems).click();

//*[@id="center_column"]/p

    }
}
