package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class javaSsriptExecutor {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html?utm_source=chatgpt.com");

//        WebElement element = driver.findElement(By.xpath("//button[@id='newTabBtn']"));
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);

        // Scroll

        WebElement element = driver.findElement(By.xpath("//button[@id='newTabsWindowsBtn']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        JavascriptExecutor js2 = (JavascriptExecutor)driver;
        js2.executeScript("arguments.value='sahil';", element);




    }
}
