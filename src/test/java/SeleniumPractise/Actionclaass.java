package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Actionclaass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement h = driver.findElement(By.cssSelector("id[name='sa']"));
        WebElement t = driver.findElement(By.cssSelector("id[name='sa']"));

        Actions act = new Actions(driver);
        act.moveToElement(h).perform();

        act.contextClick(h);
        act.doubleClick(h);
        act.dragAndDrop(h, t).perform();
        act.keyDown(h, Keys.SHIFT).perform();
        act.dragAndDropBy(h, 100, 200).perform();




    }
}
