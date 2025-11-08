package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pagination {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://stg.dayonework.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        driver.findElement(By.cssSelector("#identifier")).sendKeys("sahil.raza+33393e2efskr@dayonework.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("Test@1234567");
        driver.findElement(By.cssSelector("#loginButton")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Dashboard')]")).click();




    }
}
