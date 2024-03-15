import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class StepicTest {
    @Test
    public void stepicFirstTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/explicit_wait2.html");
        WebElement price = driver.findElement(By.id("price"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElement(price, "$100"));
        driver.findElement(By.id("book")).click();
        int x = Integer.parseInt(driver.findElement(By.id("input_value")).getText());
        driver.findElement(By.id("answer")).sendKeys(num(x));
        driver.findElement(By.id("solve")).click();
        Assert.assertTrue(driver.switchTo().alert().getText().startsWith("Congrats, you've passed the"));

        driver.quit();

    }
    public String num(int x) {
        return String.valueOf(Math.log(Math.abs(12 * Math.sin(x))));
    }

}
