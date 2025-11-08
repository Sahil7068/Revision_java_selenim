package RahulShettyWebTableUsingStream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class sort {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr//th[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> originalList = elements.stream().map(s->s.getText()).collect(Collectors.toList());

        List<String> sortedlist = originalList.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(originalList.equals(sortedlist));

        driver.quit();


    }
}
