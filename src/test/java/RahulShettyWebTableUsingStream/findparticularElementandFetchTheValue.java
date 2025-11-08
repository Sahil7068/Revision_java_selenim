package RahulShettyWebTableUsingStream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class findparticularElementandFetchTheValue {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.xpath("//tr//th[1]")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

        List<String> l = elements.stream().filter(s->s.getText().contains("Beans")).map(s->getVeggiePrice(s)).collect(Collectors.toList());

        l.forEach(s-> System.out.println(s));
        driver.quit();
    }

    private static String getVeggiePrice(WebElement s) {
        String f = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return f;
    }
}
