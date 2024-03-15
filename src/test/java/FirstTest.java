import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class FirstTest {

    @Test
    public void stepicFirstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://suninjuly.github.io/huge_form.html");
        List<WebElement> elements = driver.findElements(By.xpath("//*[@type=\"text\"]"));
        for (WebElement x: elements) {
            x.sendKeys("Lala");
        }
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        sleep(5000);
        Alert res = driver.switchTo().alert();
        String text = res.getText();

        res.accept();
        Assert.assertTrue(text.startsWith("Congrats, you've passed the task!"));
        driver.quit();

    }
}
