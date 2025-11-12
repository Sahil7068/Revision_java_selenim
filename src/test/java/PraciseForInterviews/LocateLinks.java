package PraciseForInterviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocateLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        List<WebElement> l = driver.findElements(By.tagName("a"));

        System.out.println(l.size());

        for(WebElement lin : l){
            String links = lin.getAttribute("href");
            System.out.println(links);
        }
    }
}
