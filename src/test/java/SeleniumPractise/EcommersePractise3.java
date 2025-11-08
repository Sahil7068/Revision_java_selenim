package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EcommersePractise3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6000));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] items = {"Cucumber", "Brocolli", "Beetroot", "Tomato", "Brinjal"};

        baseItem(driver, items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void baseItem(WebDriver driver, String[] items) {
        for (String item : items) {

            List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));

            products.stream().filter(s -> s.findElement(By.xpath(".//h4[@class='product-name']"))
                            .getText().split("-")[0].trim().contains(item)).findFirst()
                    .ifPresent(s -> s.findElement(By.xpath(".//div[@class='product-action']/button")).
                            click());

        }

    }
}
