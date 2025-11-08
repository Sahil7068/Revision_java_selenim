package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class FrameAndWindow {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement element = driver.findElement(By.id(""));

        driver.switchTo().frame("main");
        driver.switchTo().frame(3);
        driver.switchTo().frame(element);
        driver.switchTo().defaultContent();

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();

        String parentWindow = it.next();
        System.out.println(parentWindow);

        while(it.hasNext()){
            String childWindow = it.next();
            System.out.println(childWindow);
            driver.switchTo().window(childWindow);
            driver.close();
            driver.switchTo().window(parentWindow);
        }
    }
}
