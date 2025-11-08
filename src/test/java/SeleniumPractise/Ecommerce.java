package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Ecommerce {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] items = {"Cucumber", "Brocolli", "Beetroot"};

        for(String item: items) {

            List<WebElement> products = driver.findElements(By.cssSelector("div.product"));

            products.stream()
                    .filter(p -> p.findElement(By.cssSelector("h4.product-name"))
                            .getText().trim().contains(item))
                    .findFirst()
                    .ifPresent(p -> p.findElement(By.xpath(".//button[text()='ADD TO CART']")).click());
        }

        driver.close();



    }
}
