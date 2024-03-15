import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SaucedemoTest {

    @Test
    public void addToCartFromProductDetailsTest() {
        WebDriver driver = new ChromeDriver();
        Auth.auth(driver);
        driver.findElement(By.id("item_2_title_link")).click();
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-onesie\"]")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertFalse(driver.findElements(By.xpath("//*[text() = \"Sauce Labs Onesie\"]")).isEmpty(), "The cart is empty");
        driver.quit();


    }
    @Test
    public void removeToCartFromProductDetailsTest() {
        WebDriver driver = new ChromeDriver();
        Auth.auth(driver);
        driver.findElement(By.id("item_2_title_link")).click();
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-onesie\"]")).click();
        driver.findElement(By.cssSelector("[data-test=\"remove-sauce-labs-onesie\"]")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//*[text() = \"Sauce Labs Onesie\"]")).isEmpty(), "The cart is not empty");
        driver.quit();
    }
    @Test
    public void filterAZTest() {
        WebDriver driver = new ChromeDriver();
        Auth.auth(driver);
        Select filter = new Select(driver.findElement(By.cssSelector("[data-test=\"product_sort_container\"]")));
        filter.selectByValue("za");
        List<WebElement> lst = driver.findElements(By.className("inventory_item_name"));
        List<String> res = new ArrayList<>();
        for (WebElement x: lst) {
        res.add(x.getText());
        }
        List<String> res1 = new ArrayList<>(res);
        Collections.sort(res);
        Collections.reverse(res);
        Assert.assertEquals(res, res1, "Wrong sort order");
        driver.quit();
    }


}
