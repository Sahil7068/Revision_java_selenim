package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

import java.time.Duration;

public class WindowHandles {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html?utm_source=chatgpt.com");

        driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();

        Set<String> handle = driver.getWindowHandles();

        Iterator<String> h = handle.iterator();

        String parentWindow = h.next();

        if (h.hasNext()){
            String childWindow = h.next();
            driver.switchTo().window(childWindow);
            System.out.println("The title of the childwindow is " + driver.getTitle());
            driver.close();
            driver.switchTo().window(parentWindow);
            System.out.println("The title of the parentwindow is " + driver.getTitle());
        }

    }
}
