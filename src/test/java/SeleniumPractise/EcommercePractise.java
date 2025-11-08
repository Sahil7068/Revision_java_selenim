package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class EcommercePractise {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        String[] items = {"Cucumber", "Brocolli", "Beetroot"};

        int j = 0;


        for (String item : items) {
            j++;

            List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));

            products.stream().filter(s -> s.findElement(By.xpath(".//h4[@class='product-name']"))
                            .getText().split("-")[0].trim().contains(item))
                    .findFirst().ifPresent(s -> {
                        // get all buttons inside this product and click them
                        List<WebElement> buttons = s.findElements(By.xpath(".//div[@class='product-action']/button"));
                        buttons.forEach(WebElement::click);   // click each button
                    });
            if (j == items.length) {
                System.out.println(j);
                break;
            }
        }

//        driver.close();
    }
}
