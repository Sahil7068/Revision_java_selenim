package PraciseForInterviews;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchNewTab {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement newTab = driver.findElement(By.xpath("//button[contains(text(),'New Tab')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", newTab);

        newTab.click();

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();

        String parentWindowId = it.next();
        System.out.println("ParentWindow id " + parentWindowId);

        while(it.hasNext()) {
            String childWindowId = it.next();
            System.out.println("ChildWindow id " + childWindowId);

            driver.switchTo().window(childWindowId);
            String childWindwoTitle = driver.getTitle();
            System.out.println(childWindwoTitle);

        }




    }
}
