package SeleniumPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandlePopUp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement popUp = driver.findElement(By.cssSelector("#PopUp"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", popUp);

        popUp.click();

        Set<String> handle = driver.getWindowHandles();

        Iterator<String> it = handle.iterator();

        String parentWindowId = it.next();
        System.out.println("ParentWindow id " + parentWindowId);

        while(it.hasNext()){
            String childWindow = it.next();
            System.out.println("Childwindow id " + childWindow);


            driver.switchTo().window(childWindow);
            String childTitle = driver.getTitle();
            System.out.println("The title is " + childTitle);
            driver.close();
            driver.switchTo().window(parentWindowId);
        }

    }
}
