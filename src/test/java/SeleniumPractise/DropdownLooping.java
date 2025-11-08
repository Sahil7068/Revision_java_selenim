package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.IntStream;

public class DropdownLooping {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
//        for(int i =1;i<5;i++){
//            driver.findElement(By.id("hrefIncAdt")).click();
//        }

        //using IntStream
        IntStream.range(0, 4).forEach(s -> driver.findElement(By.id("hrefIncAdt")).click());

        driver.findElement(By.xpath("//input[@value='Done']")).click();
        driver.close();


    }
}
